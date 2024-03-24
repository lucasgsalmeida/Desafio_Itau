package me.lucas.Desafio_Itau.service;

import me.lucas.Desafio_Itau.model.domain.estatistica.Estatistica;
import me.lucas.Desafio_Itau.model.domain.estatistica.EstatisticaResponseDTO;
import me.lucas.Desafio_Itau.model.domain.transacao.Transacao;
import me.lucas.Desafio_Itau.model.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private TransacaoRepository transacaoRepository;

    @Autowired
    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public ResponseEntity<EstatisticaResponseDTO> getEstatisticas() {
        List<Transacao> transacoes = transacaoRepository.findWithinLast60Seconds();

        DoubleSummaryStatistics stats = transacoes.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        if (stats.getCount() == 0) {
            EstatisticaResponseDTO estatisticaZero = new EstatisticaResponseDTO(
                    new Estatistica(0, 0.0, 0.0, 0.0, 0.0));
            return ResponseEntity.ok(estatisticaZero);
        }

        Estatistica estatistica = new Estatistica(
                (int) stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax());

        EstatisticaResponseDTO estatisticaResponse = new EstatisticaResponseDTO(estatistica);
        return ResponseEntity.ok(estatisticaResponse);
    }

}

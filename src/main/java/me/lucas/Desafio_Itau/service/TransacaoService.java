package me.lucas.Desafio_Itau.service;

import me.lucas.Desafio_Itau.model.domain.transacao.Transacao;
import me.lucas.Desafio_Itau.model.domain.transacao.TransacaoRequestDTO;
import me.lucas.Desafio_Itau.model.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public ResponseEntity saveTransacao(TransacaoRequestDTO data) {

        if (data == null) {
            return ResponseEntity.badRequest().build();
        }

        if (data.dataHora() == null || data.valor() == null) {
            return ResponseEntity.badRequest().build();
        }

        if (data.valor() < 0) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        if (!isDataHoraValida(data.dataHora())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        if (isDataHoraMaiorQueAtual(data.dataHora())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }


        Transacao transacao = new Transacao(data);
        transacaoRepository.save(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity deleteAllTransacoes()  {
        transacaoRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    private boolean isDataHoraMaiorQueAtual(String dataHora) {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime comparacao = OffsetDateTime.parse(dataHora);

        return comparacao.compareTo(now) > 0;

    }
    private boolean isDataHoraValida(String dataHora) {
        try {
            OffsetDateTime.parse(dataHora);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}

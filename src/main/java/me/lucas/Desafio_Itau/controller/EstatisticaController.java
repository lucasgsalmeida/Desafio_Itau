package me.lucas.Desafio_Itau.controller;

import me.lucas.Desafio_Itau.model.domain.estatistica.EstatisticaResponseDTO;
import me.lucas.Desafio_Itau.model.repository.TransacaoRepository;
import me.lucas.Desafio_Itau.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estatistica")
public class EstatisticaController {

    private final TransacaoRepository transacaoRepository;
    private final EstatisticaService estatisticaService;

    @Autowired
    public EstatisticaController(TransacaoRepository transacaoRepository, EstatisticaService estatisticaService) {
        this.transacaoRepository = transacaoRepository;
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaResponseDTO> getEstatisticas() {
        return estatisticaService.getEstatisticas();

    }

}

package me.lucas.Desafio_Itau.controller;

import me.lucas.Desafio_Itau.model.domain.transacao.TransacaoRequestDTO;
import me.lucas.Desafio_Itau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacao")

public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity registerTransacao(@RequestBody TransacaoRequestDTO data) {
        return transacaoService.saveTransacao(data);
    }

    @DeleteMapping
    public ResponseEntity deleteTransacao() {
        return transacaoService.deleteAllTransacoes();
    }
}


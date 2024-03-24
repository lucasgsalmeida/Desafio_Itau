package me.lucas.Desafio_Itau.model.domain.transacao;

import java.util.UUID;

public record TransacaoResponseDTO(UUID id, Double valor, String dataHora) {

    public TransacaoResponseDTO(Transacao transacao) {
        this(transacao.getId(), transacao.getValor(), transacao.getDataHora());
    }
}

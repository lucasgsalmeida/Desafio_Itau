package me.lucas.Desafio_Itau.model.domain.transacao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transacao {

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Double valor;

    private String dataHora;

    public Transacao(TransacaoRequestDTO data) {
        this.valor = data.valor();
        this.dataHora = data.dataHora();
    }
}

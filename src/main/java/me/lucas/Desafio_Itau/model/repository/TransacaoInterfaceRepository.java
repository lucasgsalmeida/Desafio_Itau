package me.lucas.Desafio_Itau.model.repository;

import me.lucas.Desafio_Itau.model.domain.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransacaoInterfaceRepository extends JpaRepository<Transacao, UUID> {
}

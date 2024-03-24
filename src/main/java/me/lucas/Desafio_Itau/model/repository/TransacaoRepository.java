package me.lucas.Desafio_Itau.model.repository;

import me.lucas.Desafio_Itau.model.domain.transacao.Transacao;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository implements TransacaoInterfaceRepository {

    private final List<Transacao> transacoes = new ArrayList<>();

    @Override
    public <S extends Transacao> S save(S entity) {
        transacoes.add(entity);
        return entity;
    }

    @Override
    public Optional<Transacao> findById(UUID uuid) {
        return transacoes.stream()
                .filter(transacao -> transacao.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return transacoes.stream()
                .anyMatch(transacao -> transacao.getId().equals(uuid));
    }

    @Override
    public <S extends Transacao> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public List<Transacao> findAll() {
        return transacoes;
    }

    @Override
    public List<Transacao> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return transacoes.size();
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Transacao entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Transacao> entities) {

    }

    @Override
    public void deleteAll() {
        transacoes.clear();
    }

    /*
    Obter transações dentro do intervalo de 60 segundos
     */
    public List<Transacao> findWithinLast60Seconds() {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime cutoffTime = now.minusSeconds(60);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        return transacoes.stream()
                .filter(transacao -> {
                    OffsetDateTime transacaoTime = OffsetDateTime.parse(transacao.getDataHora(), formatter);
                    return transacaoTime.isAfter(cutoffTime);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Transacao> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Transacao> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Transacao> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Transacao getOne(UUID uuid) {
        return null;
    }

    @Override
    public Transacao getById(UUID uuid) {
        return null;
    }

    @Override
    public Transacao getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Transacao> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Transacao> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Transacao> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Transacao> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Transacao> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Transacao> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Transacao, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Transacao> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Transacao> findAll(Pageable pageable) {
        return null;
    }
}

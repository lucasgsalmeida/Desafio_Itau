package me.lucas.Desafio_Itau.model.domain.estatistica;

public record EstatisticaResponseDTO(Integer count, Double sum, Double avg, Double min, Double max) {

    public EstatisticaResponseDTO(Estatistica estatistica) {
        this(estatistica.getCount(), estatistica.getSum(), estatistica.getAvg(), estatistica.getMin(), estatistica.getMax());
    }
}

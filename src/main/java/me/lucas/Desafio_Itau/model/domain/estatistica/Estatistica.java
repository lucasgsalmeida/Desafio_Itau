package me.lucas.Desafio_Itau.model.domain.estatistica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Estatistica {

    private Integer count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

}

package com.seidelsoft.SpringEcommerceBackend.model.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {

    MASCULINO(1L, "Masculino"),
    FEMININO(2L, "Feminino")
    ;

    private final Long id;
    private final String descricao;
}

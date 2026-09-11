package org.AlquilerApi.dtos.Categoria;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CategoriaGuardar {
    private String nombre;
    private BigDecimal tarifaBaseDiaria;
}
package org.AlquilerApi.dtos.Categoria;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoriaSalida implements Serializable {
    private Integer id;
    private String nombre;
}

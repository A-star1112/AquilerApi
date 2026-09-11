package org.AlquilerApi.Servicios.Interfaces;

import org.AlquilerApi.dtos.Categoria.CategoriaGuardar;
import org.AlquilerApi.dtos.Categoria.CategoriaModificar;
import org.AlquilerApi.dtos.Categoria.CategoriaSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoriaServicios {
    List<CategoriaSalida> obtenerTodos();

    Page<CategoriaSalida> obtenerTodosPaginados(Pageable pageable);

    CategoriaSalida obtenerPorId(Integer id);

    CategoriaSalida crear(CategoriaGuardar categoriaGuardar);

    CategoriaSalida editar(CategoriaModificar categoriaModificar);

    void eliminarPorId(Integer id);
}
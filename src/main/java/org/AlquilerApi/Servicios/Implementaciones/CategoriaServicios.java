package org.AlquilerApi.Servicios.Implementaciones;

import org.AlquilerApi.Modelos.Categoria;
import org.AlquilerApi.Repositorios.ICategoriaRepositorios;
import org.AlquilerApi.Servicios.Interfaces.ICategoriaServicios;
import org.AlquilerApi.dtos.Categoria.CategoriaGuardar;
import org.AlquilerApi.dtos.Categoria.CategoriaModificar;
import org.AlquilerApi.dtos.Categoria.CategoriaSalida;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServicios implements ICategoriaServicios {

    @Autowired
    private ICategoriaRepositorios categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoriaSalida> obtenerTodos() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<CategoriaSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Categoria> page = categoriaRepository.findAll(pageable);
        List<CategoriaSalida> categoriaDtos = page.stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(categoriaDtos, pageable, page.getTotalElements());
    }

    @Override
    public CategoriaSalida obtenerPorId(Integer id) {
        return modelMapper.map(categoriaRepository.findById(id).get(), CategoriaSalida.class);
    }

    @Override
    public CategoriaSalida crear(CategoriaGuardar categoriaGuardar) {
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaGuardar, Categoria.class));
        return modelMapper.map(categoria, CategoriaSalida.class);
    }

    @Override
    public CategoriaSalida editar(CategoriaModificar categoriaModificar) {
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaModificar, Categoria.class));
        return modelMapper.map(categoria, CategoriaSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
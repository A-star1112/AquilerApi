package org.AlquilerApi.Repositorios;

import org.AlquilerApi.Modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepositorios extends JpaRepository<Categoria, Integer> {
}
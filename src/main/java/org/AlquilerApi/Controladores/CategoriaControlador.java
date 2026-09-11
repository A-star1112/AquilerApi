package org.AlquilerApi.Controladores;

import org.AlquilerApi.Servicios.Interfaces.ICategoriaServicios;
import org.AlquilerApi.dtos.Categoria.CategoriaGuardar;
import org.AlquilerApi.dtos.Categoria.CategoriaModificar;
import org.AlquilerApi.dtos.Categoria.CategoriaSalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaControlador {

    @Autowired
    private ICategoriaServicios categoriaServicios;

    @GetMapping
    public ResponseEntity<Page<CategoriaSalida>> mostrarTodosPaginados(Pageable pageable) {
        Page<CategoriaSalida> categoriaSalida = categoriaServicios.obtenerTodosPaginados(pageable);

        if (categoriaSalida.hasContent()) {
            return ResponseEntity.ok(categoriaSalida);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/Lista")
    public ResponseEntity<List<CategoriaSalida>> mostraTodos() {
        List<CategoriaSalida> categoriaSalidas = categoriaServicios.obtenerTodos();

        if (!categoriaSalidas.isEmpty()) {
            return ResponseEntity.ok(categoriaSalidas);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaSalida> buscarPorId(@PathVariable Integer id) {
        CategoriaSalida categoriaSalida = categoriaServicios.obtenerPorId(id);

        if (categoriaSalida != null) {
            return ResponseEntity.ok(categoriaSalida);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CategoriaSalida> crear(@RequestBody CategoriaGuardar categoriaGuardar) {
        CategoriaSalida categoria = categoriaServicios.crear(categoriaGuardar);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaSalida> editar(@PathVariable Integer id, @RequestBody CategoriaModificar categoriaModificar) {
        CategoriaSalida categoria = categoriaServicios.editar(categoriaModificar);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        categoriaServicios.eliminarPorId(id);
        return ResponseEntity.ok("Categoria eliminada correctamente");
    }
}
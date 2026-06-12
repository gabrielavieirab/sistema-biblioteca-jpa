package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Autor;
import com.exemplo.biblioteca.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
@Tag(name = "Autores", description = "Endpoints para gerenciamento de autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    @Operation(summary = "Listar todos os autores")
    public List<Autor> listar() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar autor por ID")
    public ResponseEntity<Autor> buscar(@PathVariable Long id) {
        return autorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo autor")
    public Autor salvar(@RequestBody Autor autor) {
        return autorService.salvar(autor);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um autor existente")
    public ResponseEntity<Autor> atualizar(@PathVariable Long id, @RequestBody Autor autor) {
        try {
            return ResponseEntity.ok(autorService.atualizar(id, autor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um autor")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

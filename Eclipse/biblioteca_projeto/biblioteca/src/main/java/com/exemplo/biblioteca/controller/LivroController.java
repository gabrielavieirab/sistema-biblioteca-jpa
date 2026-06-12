package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@Tag(name = "Livros", description = "Endpoints para gerenciamento de livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    @Operation(summary = "Listar todos os livros")
    public List<Livro> listar() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro por ID")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo livro")
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um livro existente")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        try {
            return ResponseEntity.ok(livroService.atualizar(id, livro));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um livro")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

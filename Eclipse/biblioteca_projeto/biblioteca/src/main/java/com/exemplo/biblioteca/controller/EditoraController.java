package com.exemplo.biblioteca.controller;

import com.exemplo.biblioteca.model.Editora;
import com.exemplo.biblioteca.service.EditoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoras")
@Tag(name = "Editoras", description = "Endpoints para gerenciamento de editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    @Operation(summary = "Listar todas as editoras")
    public List<Editora> listar() {
        return editoraService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar editora por ID")
    public ResponseEntity<Editora> buscar(@PathVariable Long id) {
        return editoraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastrar uma nova editora")
    public Editora salvar(@RequestBody Editora editora) {
        return editoraService.salvar(editora);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma editora existente")
    public ResponseEntity<Editora> atualizar(@PathVariable Long id, @RequestBody Editora editora) {
        try {
            return ResponseEntity.ok(editoraService.atualizar(id, editora));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma editora")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        editoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

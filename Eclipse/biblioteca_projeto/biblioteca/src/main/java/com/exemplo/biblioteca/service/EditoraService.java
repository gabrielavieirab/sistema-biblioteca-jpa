package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Editora;
import com.exemplo.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> listarTodos() {
        return editoraRepository.findAll();
    }

    public Optional<Editora> buscarPorId(Long id) {
        return editoraRepository.findById(id);
    }

    public Editora salvar(Editora editora) {
        return editoraRepository.save(editora);
    }

    public Editora atualizar(Long id, Editora editoraAtualizada) {
        return editoraRepository.findById(id).map(editora -> {
            editora.setNome(editoraAtualizada.getNome());
            editora.setCidade(editoraAtualizada.getCidade());
            editora.setCnpj(editoraAtualizada.getCnpj());
            return editoraRepository.save(editora);
        }).orElseThrow(() -> new RuntimeException("Editora não encontrada"));
    }

    public void deletar(Long id) {
        editoraRepository.deleteById(id);
    }
}

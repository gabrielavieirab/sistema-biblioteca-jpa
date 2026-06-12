package com.exemplo.biblioteca.service;

import com.exemplo.biblioteca.model.Livro;
import com.exemplo.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setEditora(livroAtualizado.getEditora());
            return livroRepository.save(livro);
        }).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}

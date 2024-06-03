package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.LivroService;
import br.com.fatecmogidascruzes.validator.LivroValidator;

public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;
    private final LivroValidator validator;

    public LivroServiceImpl(LivroRepository repository, LivroValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void adicionarLivro(Livro livro) {
        if (validator.validarAdicionar(livro)){
            repository.adicionarLivro(livro);
            System.out.println("Livro cadastrado com sucesso!");
        }
    }

    @Override
    public void atualizarLivro(Livro livro) {
        int index = repository.findIndexPorId(livro.getId());
        if (index != -1) {
            if (validator.validarAlterar(livro)){
                repository.alterarLivro(index, livro);
                System.out.println("Livro atualizado com sucesso!");
            }
        } else {
            System.out.println("Ocorreu algo de errado ao atualizar informações do livro, por favor verifique as informações e tente novamente");
        }
    }
    
    @Override
    public boolean excluirLivroPorId(long id) {
        int index = repository.findIndexPorId(id);
        if (index != -1) {
            repository.delete(index);
            System.out.println("Livro excluído com sucesso!");
            return true;
        } else {
            System.out.println("Livro não encontrado com ID: " + id);
            return false;
        }
    }

    @Override
    public boolean excluirLivroPorIsbn10(String isbn10) {
        Livro livro = repository.findByIsbn10(isbn10);
        if (livro != null) {
            int index = repository.findIndexPorId(livro.getId());
            repository.delete(index);
            System.out.println("Livro excluído com sucesso!");
            return true;
        } else {
            System.out.println("Livro não encontrado com ISBN-10: " + isbn10);
            return false;
        }
    }

    @Override
    public boolean excluirLivroPorIsbn13(String isbn13) {
        Livro livro = repository.findByIsbn13(isbn13);
        if (livro != null) {
            int index = repository.findIndexPorId(livro.getId());
            repository.delete(index);
            System.out.println("Livro excluído com sucesso!");
            return true;
        } else {
            System.out.println("Livro não encontrado com ISBN-13: " + isbn13);
            return false;
        }
    }

}
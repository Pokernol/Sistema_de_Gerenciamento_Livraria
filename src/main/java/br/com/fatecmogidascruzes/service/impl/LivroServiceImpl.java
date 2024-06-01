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
    public void alterarLivro(Livro livro) {
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

}
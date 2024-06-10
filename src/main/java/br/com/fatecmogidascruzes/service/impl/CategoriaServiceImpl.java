package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import br.com.fatecmogidascruzes.model.repository.CategoriaRepository;
import br.com.fatecmogidascruzes.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {

        this.repository = repository;
    
    }

    public void adicionarCategoria(Categoria categoria) {
        repository.save(categoria);
        System.out.println("Categoria " + categoria.getNome() + " adicionada com sucesso!");
    }

    public void atualizarCategoria(long id, Categoria categoria) {
        try {
            repository.atualizarCategoria(id, categoria);
            System.out.println("Categoria " + categoria.getNome() + " atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Categoria buscarCategoriaPorNome(String nome) {
        Categoria categoria = repository.findByName(nome);
        if (categoria != null) {
            return categoria;
        } else {
            System.out.println("Categoria com nome " + nome + " não encontrada.");
            return null;
        }
    }

    public void excluirCategoria(int id) {
        try {
            repository.removerCategoria(id);
            System.out.println("Categoria removida com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ID informado.");
        }
    }

}

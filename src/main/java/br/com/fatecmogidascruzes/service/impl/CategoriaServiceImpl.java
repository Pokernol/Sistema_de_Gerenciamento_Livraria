package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import br.com.fatecmogidascruzes.model.repository.CategoriaRepository;

public class CategoriaServiceImpl {
    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {

        this.repository = repository;
    
    }

    public void adicionarCategoria(Categoria categoria) {
        repository.adicionarCategoria(categoria);
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

    public boolean excluirCategoria(int id) {
        if (repository.removerCategoria(id)) {
            System.out.println("Categoria com ID " + id + " excluída com sucesso!");
            return true;
        } else {
            System.out.println("Categoria com ID " + id + " não encontrada.");
            return false;
        }
    }

}

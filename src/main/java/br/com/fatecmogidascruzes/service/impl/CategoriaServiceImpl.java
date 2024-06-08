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

}

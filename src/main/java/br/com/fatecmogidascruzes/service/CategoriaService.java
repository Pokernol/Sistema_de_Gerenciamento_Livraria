package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Categoria;

public interface CategoriaService {

    void adicionarCategoria(Categoria categoria);
    Categoria buscarCategoriaPorNome(String nome);
    boolean excluirCategoria(int id);

}

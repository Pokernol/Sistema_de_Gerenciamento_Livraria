package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();

    public void adicionarCategoria(Categoria categoria) {
            categorias.add(categoria);
            System.out.println("Categoria " + categoria.getNome() + " adicionada com sucesso!");
    }
    public List<Categoria> findAllCategorias() {
        return categorias;
    }


}

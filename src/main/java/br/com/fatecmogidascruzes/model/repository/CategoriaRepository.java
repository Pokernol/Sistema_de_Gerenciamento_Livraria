package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();

    public void adicionarCategoria(Categoria categoria) {
            categorias.add(categoria);
    }

    public void atualizarCategoria(long id, Categoria categoria) {
        int index = findIndexPorId(id);
        if (index != -1) {
            categorias.set(index, categoria);
        } else
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações da categoria. Por favor, informe um ID Valido e tente novamente.");
    }

    public void removerCategoria(int id) {
        Categoria categoria = findById(id);
        if (categoria != null) {
            categorias.remove(categoria);
        } else
            throw new IllegalArgumentException("Categoria não encontrada.");
    }

    public List<Categoria> findAllCategorias() {
        return categorias;
    }

    private int findIndexPorId(long id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst()
                .map(categorias::indexOf)
                .orElse(-1);
    }

    public Categoria findById(long id) {
        return categorias.stream()
                .filter(categoria -> categoria.getId() == id)
                .findFirst().orElse(null);
    }

    public Categoria findByName(String nome) {
        return categorias.stream()
                .filter(categoria -> categoria.getNome().toUpperCase().contains(nome.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}

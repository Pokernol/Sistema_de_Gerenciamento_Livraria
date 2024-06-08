package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();

    public void adicionarCategoria(Categoria categoria) {
        
        if (categoria.isValid()) {
            categorias.add(categoria);
            System.out.println("Categoria " + categoria.getNome() + " adicionada com sucesso!");
        } else {
            System.out.println("Categoria inválida, digite os campos corretamente. ");
        }

    }
    public List<Categoria> findAllCategorias() {
        return categorias;
    }

    public Categoria findById(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }
    
    public Categoria findByName(String nome) {
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nome)) {
                return categoria;
            }
        }
        return null;
    }

    public boolean removerCategoria(int id) {
        Categoria categoria = findById(id);
        if (categoria != null) {
            return categorias.remove(categoria);
        }
        return false;
    }

}

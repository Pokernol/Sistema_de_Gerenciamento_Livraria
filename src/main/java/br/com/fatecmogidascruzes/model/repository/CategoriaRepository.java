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

    public int findIndexPorId(long id) {
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getId() == id) {
                return i;
            }
        } 
        return -1; 
    }

    public void atualizarCategoria(long id, Categoria categoria) {
        int index = findIndexPorId(id);
        if (index != -1) {
            categorias.set(index, categoria);
        }
        else{
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações da categoria, por favor verifique e tente novamente");
        }
    }

    public Categoria findById(long id) {
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

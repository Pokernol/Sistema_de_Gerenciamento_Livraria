package br.com.fatecmogidascruzes.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria {
    private int id;
    private String nome;
    private String descricao;


    @Override
    public String toString() {
        return "\n Categoria {" +
                "\n  Id = " + id +
                "\n  Nome = " + nome +
                "\n  Descricao = " + descricao +
                "\n }\n";
    }


    public Categoria(int id, String nome, String descricao) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
    }


    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição da categoria não pode ser nula ou vazia");
        }
        this.descricao = descricao;
    }

    public boolean isValid() {
        return this.nome != null && !this.nome.isEmpty() &&
               this.descricao != null && !this.descricao.isEmpty();
    }

}
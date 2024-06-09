package br.com.fatecmogidascruzes.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria {
    private int id;
    private String nome;
    private String descricao;

    public Categoria(int id, String nome, String descricao) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
    }

    public void setNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome da categoria não pode ser vazio.");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println(e + " Por favor insira um nome válido.");
        }
    }

    public void setDescricao(String descricao) {
        try {
            if (descricao == null || descricao.isEmpty()) {
                throw new IllegalArgumentException("Descrição da categoria não pode ser vazio.");
            }
            this.descricao = descricao;
        } catch (IllegalArgumentException e) {
            System.out.println(e + " Por favor insira uma descrição válida.");
        }
    }

    @Override
    public String toString() {
        return "\n Categoria {" +
                "\n  Id = " + id +
                "\n  Nome = " + nome +
                "\n  Descricao = " + descricao +
                "\n }\n";
    }

}
package br.com.fatecmogidascruzes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

}

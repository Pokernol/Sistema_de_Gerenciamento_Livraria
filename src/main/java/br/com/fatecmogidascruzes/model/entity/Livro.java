package br.com.fatecmogidascruzes.model.entity;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class Livro {
    private long id;
    private String isbn10;
    private String isbn13;
    private String titulo;
    private String idioma;
    private String autor;
    private int estoque;
    private String editora;
    private int numeroDePaginas;
    private LocalDate dataDePublicacao;
    private double preco;
    private String categoria;

    @Override
    public String toString() {
        return "\n Livro {" +
                "\n  id = " + id +
                "\n  isbn-10 = " + isbn10 +
                "\n  isbn-13 = " + isbn13 +
                "\n  titulo = " + titulo  +
                "\n  idioma = " + idioma +
                "\n  autor = " + autor +
                "\n  estoque = " + estoque +
                "\n  editora = " + editora +
                "\n  numeroDePaginas = " + numeroDePaginas +
                "\n  dataDePublicacao = " + dataDePublicacao +
                "\n  preço = " + preco +
                "\n  categoria = " + categoria +
                "\n }\n";
    }
}
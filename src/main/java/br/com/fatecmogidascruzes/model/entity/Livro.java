package br.com.fatecmogidascruzes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
}
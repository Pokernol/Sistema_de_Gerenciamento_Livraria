package br.com.fatecmogidascruzes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private long id;
    private String titulo;
    private String sinopse;
    private String autor;
    private String editora;
    private String genero;
    private String idioma;
    private BigDecimal preco;
    private LocalDate anoDePublicacao;
}
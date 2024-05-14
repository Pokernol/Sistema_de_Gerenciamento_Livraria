package br.com.fatecmogidascruzes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private long id;
    private String nome;
    private String Email;
    private String telefone;
    private LocalDate dataNascimento;
}
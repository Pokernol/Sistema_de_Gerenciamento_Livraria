package br.com.fatecmogidascruzes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private boolean isFuncionario; // true se o usuário é um funcionário, false se é um cliente
}
package br.com.fatecmogidascruzes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Usuario {
    private String cargo;
    private LocalDate dataContratacao;

    @Override
    public String toString() {
        return "\n Funcionario {" +
                "\n  Id = " + getId() +
                "\n  Nome = " + getNome() +
                "\n  Endereco = " + getEndereco() +
                "\n  Email = " + getEmail() +
                "\n  Telefone = " + getTelefone() +
                "\n  Cargo = " + cargo +
                "\n  Data de Contratação = " + dataContratacao +
                "\n }\n";
    }
}
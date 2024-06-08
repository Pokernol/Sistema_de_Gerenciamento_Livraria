package br.com.fatecmogidascruzes.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Funcionario extends Usuario {
    private String cargo;
    private LocalDate dataContratacao;

    public Funcionario(Integer id, String nome, String endereco, String email, String telefone, String cargo, LocalDate dataContratacao) {
        super(id, nome, endereco, email, telefone);
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

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
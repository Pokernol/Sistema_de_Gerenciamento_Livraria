package br.com.fatecmogidascruzes.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Cliente extends Usuario {
    private String metodoPagamento;
    private LocalDate dataCadastro;

    public Cliente(Integer id, String nome, String endereco, String email, String telefone, String metodoPagamento, LocalDate dataCadastro) {
        super(id, nome, endereco, email, telefone);
        this.metodoPagamento = metodoPagamento;
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "\n Cliente {" +
                "\n  Id = " + getId() +
                "\n  Nome = " + getNome() +
                "\n  Endereco = " + getEndereco() +
                "\n  Email = " + getEmail() +
                "\n  Telefone = " + getTelefone() +
                "\n  Metodo de Pagamento = " + metodoPagamento +
                "\n  Data de Cadastro = " + dataCadastro +
                "\n }\n";
    }
}
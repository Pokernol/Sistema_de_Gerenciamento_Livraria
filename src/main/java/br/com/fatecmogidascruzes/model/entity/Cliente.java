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
public class Cliente extends Usuario {
    private String metodoPagamento;
    private LocalDate dataCadastro;

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
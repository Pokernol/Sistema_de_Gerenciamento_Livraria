package br.com.fatecmogidascruzes.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import br.com.fatecmogidascruzes.validator.UsuarioValidator;

@Getter
@Setter
public class Cliente extends Usuario {
    private String metodoPagamento;
    private LocalDate dataCadastro;

<<<<<<< HEAD
    public Cliente(int id, String nome, String endereco, String email, String telefone,String metodoPagamento, LocalDate dataCadastro, UsuarioValidator usuarioValidator ) {
        
        super(id, nome, endereco, email, telefone, usuarioValidator);
        setMetodoPagamento(metodoPagamento);
        setDataCadastro(dataCadastro);
    }

    public void setMetodoPagamento(String metodoPagamento) {
        try {
            if (metodoPagamento == null || metodoPagamento.isEmpty()) {
                throw new IllegalArgumentException("Metodo de pagamento do cliente não pode ser vazio.");
            }
            this.metodoPagamento = metodoPagamento;
        } catch (IllegalArgumentException e) {
            System.out.println(e + " Por favor insira um metodo de pagamento válido.");
        }
    }

    public void setDataCadastro(LocalDate dataCadastro) {

            if (dataCadastro == null) {
                throw new IllegalArgumentException("Data de cadastro do cliente não pode ser vazio.");
            }
            this.dataCadastro = dataCadastro;
       
=======
    public Cliente(Integer id, String nome, String endereco, String email, String telefone, String metodoPagamento, LocalDate dataCadastro) {
        super(id, nome, endereco, email, telefone);
        this.metodoPagamento = metodoPagamento;
        this.dataCadastro = dataCadastro;
>>>>>>> d68bdd98c972348d8d1e5d1fbbc3c3c1d9387f84
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
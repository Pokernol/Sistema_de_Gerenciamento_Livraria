package br.com.fatecmogidascruzes.model.entity;

import br.com.fatecmogidascruzes.validator.UsuarioValidator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private long id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private UsuarioValidator validatorUsuario;

    public Usuario(long id, String nome, String endereco, String email, String telefone) {
        setId(id);
        setNome(nome);
        setEmail(this, email);
        setEndereco(endereco);
        setTelefone(telefone);
    }
    
    public void setNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome do usuário não pode ser vazio.");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println(e + " Por favor insira um nome válido.");
        }
    }

    public void setEmail(Usuario usuario, String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio.");
        } 
       this.email = email;
    }

    public void setEndereco(String endereco) {
        try {
            if (endereco == null || endereco.isEmpty()) {
                throw new IllegalArgumentException("Endereco não pode ser vazio.");
            }
            this.endereco = endereco;
        } catch (IllegalArgumentException e) {
            System.out.println(e + " Por favor insira um endereço válido.");
        }
    }

    public void setTelefone(String telefone) {
        try {
            if (telefone == null || telefone.isEmpty()) {
                throw new IllegalArgumentException("Telefone não pode ser vazio.");
            }
            if (telefone.length() != 11) {
                throw new IllegalArgumentException("Telefone inválido.");
            }
            this.telefone = telefone;
        } catch (IllegalArgumentException e) {
            System.out.println(e + " Por favor insira um telefone válido.");
        }
    }
}
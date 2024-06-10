package br.com.fatecmogidascruzes.view;

import java.util.Scanner;

import br.com.fatecmogidascruzes.validator.UsuarioValidator;

public class LoginView {

    UsuarioValidator usuarioValidator;
    Scanner scanner = new Scanner(System.in);
    
    public Boolean login() {

       StringBuilder mensagemOpçoes = new StringBuilder("---- LOGIN ----");
       mensagemOpçoes.append("1 - Login cliente");
       mensagemOpçoes.append("2 - Login funcionário");
       mensagemOpçoes.append("3 - Voltar");
       mensagemOpçoes.append("Escolha uma opção: ");

        int opcao = 0;

        do {
            System.out.println(mensagemOpçoes.toString());
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("---- LOGIN CLIENTE ----");
                    return loginCliente();//verdadeiro
                    
                case 2:
                    System.out.println("---- LOGIN FUNCIONÁRIO ----");
                    return loginFuncionario();//falso
                case 3:
                    return null;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(opcao < 1 || opcao > 3);

        return null;
    }

    public Boolean loginCliente() {
        System.out.println("Digite Email de usuário:");
        String nomeUsuario = scanner.next();
        System.out.println("Digite senha:");
        String senha = scanner.next();

        if(usuarioValidator.validarLogin(nomeUsuario, senha, 1)){
            return false;
        }
        return null;
    }

    public Boolean loginFuncionario() {
        System.out.println("Digite Email de funcionário:");
        String nomeUsuario = scanner.next();
        System.out.println("Digite senha:");
        String senha = scanner.next();

        if(usuarioValidator.validarLogin(nomeUsuario, senha, 2)){
            return true;
        }
        return null;
    }
    
}

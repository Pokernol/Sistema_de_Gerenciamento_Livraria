package br.com.fatecmogidascruzes.view;

import java.util.Scanner;

import br.com.fatecmogidascruzes.validator.UsuarioValidator;

public class LoginView {

    UsuarioValidator usuarioValidator;
    Scanner scanner = new Scanner(System.in);
    
    public Boolean login() {

        int opcao;

        do {
            System.out.println(stringMenuLogin());
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n---- LOGIN CLIENTE ----");
                    return loginCliente();//verdadeiro
                    
                case 2:
                    System.out.println("\n---- LOGIN FUNCIONÁRIO ----");
                    return loginFuncionario();//falso
                case 3:
                    System.out.println("\nVoltando ao menu inicial...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(opcao < 1 || opcao > 3);

        return null;
    }

    public Boolean loginCliente() {
        System.out.println("\nDigite seu Email:");
        String nomeUsuario = scanner.next();
        System.out.println("\nDigite sua senha:");
        String senha = scanner.next();

        if(Boolean.TRUE.equals(UsuarioValidator.validarLogin(nomeUsuario, senha, 1))){
            return false;
        }
        return null;
    }

    public Boolean loginFuncionario() {
        System.out.println("\nDigite o Email de funcionário:");
        String nomeUsuario = scanner.next();
        System.out.println("\nDigite a senha:");
        String senha = scanner.next();

        if(Boolean.TRUE.equals(UsuarioValidator.validarLogin(nomeUsuario, senha, 2))){
            return true;
        }
        return null;
    }

    public StringBuilder stringMenuLogin() {
        StringBuilder mensagemOpcoes = new StringBuilder();
            mensagemOpcoes.append("\n\n\n");
            mensagemOpcoes.append("\n---- LOGIN ----");
            mensagemOpcoes.append("\n1 - Login cliente");
            mensagemOpcoes.append("\n2 - Login funcionário");
            mensagemOpcoes.append("\n3 - Voltar");
            mensagemOpcoes.append("\nEscolha uma opção: ");
        return mensagemOpcoes;
    }
    
}
package br.com.fatecmogidascruzes.view;

import java.util.Scanner;

public class MenuView {
    
    Scanner scanner = new Scanner(System.in);

    public void menuLogin() {
        
        System.out.println("Bem-vindo ao Sistema de Livraria!");
        StringBuilder mensagemOpcoes = new StringBuilder("\nPara continuar, faça login ou cadastre-se.");
        mensagemOpcoes.append("\n---- SISTEMA DE LIVRARIA ----");
        mensagemOpcoes.append("1 - Login");
        mensagemOpcoes.append("2 - Cadastro");
        mensagemOpcoes.append("3 - Sair");
        mensagemOpcoes.append("Escolha uma opção:");
        
        int opcao = 0;
        Boolean isFuncionario;

        do {
            System.out.println(mensagemOpcoes.toString());
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    isFuncionario = new LoginView().login();
                    if(isFuncionario){
                        menuFuncionario();
                    }else{
                        menuCliente();
                    }
                    opcao = 0;
                    break;
                case 2:
                    new CadastroUsuarioView().cadastro();
                    opcao = 0;
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar o sistema de livraria! :)");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        } while (opcao < 1 || opcao > 3);
    }

    public void menuFuncionario() {
        int opcao = 0;
        
        StringBuilder mensagemOpçoes = new StringBuilder("---- MENU FUNCIONARIO ----");
        mensagemOpçoes.append("1 - Cadastrar livro");
        mensagemOpçoes.append("2 - Buscar Livro");
        mensagemOpçoes.append("3 - Listar Pedidos");
        mensagemOpçoes.append("4 - Listar Todos Livros");
        mensagemOpçoes.append("5 - Alterar Livro");
        mensagemOpçoes.append("6 - Excluir Livro");
        mensagemOpçoes.append("7 - Sair");
        mensagemOpçoes.append("Escolha uma opção: ");

        do{
            System.out.println(mensagemOpçoes.toString());
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente.");
                    break;
            }
        }while(opcao < 1 || opcao > 7);
    }

    public void menuCliente() {
        int opcao = 0;
        
        StringBuilder mensagemOpçoes = new StringBuilder("---- MENU CLIENTE ----");
        mensagemOpçoes.append("1 - Buscar Livro");
        mensagemOpçoes.append("2 - Listar Pedidos");
        mensagemOpçoes.append("4 - Listar Todos Livros");
        mensagemOpçoes.append("5 - Comprar Livro");
        mensagemOpçoes.append("6 - Acompanhar Pedido");
        mensagemOpçoes.append("7 - Sair");
        mensagemOpçoes.append("Escolha uma opção: ");

        do{
            System.out.println(mensagemOpçoes.toString());
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente.");
                    break;
            }
        }while(opcao < 1 || opcao > 7);
    }
    
}
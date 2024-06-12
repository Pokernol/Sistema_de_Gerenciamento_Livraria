package br.com.fatecmogidascruzes.view;

import java.util.Scanner;


public class MenuView {
    
    Scanner scanner = new Scanner(System.in);

    public void menuInicial() {
        
        System.out.println("Bem-vindo ao Sistema de Livraria!");
        StringBuilder mensagemOpcoes = stringMenuInicial();
        Boolean isFuncionario;
        int opcao;

        do {
            System.out.println(mensagemOpcoes);
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
                    System.out.println("\nObrigado por utilizar o sistema de livraria! :)");
                    break;
                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        } while (opcao < 1 || opcao > 3);
    }

    public void menuCliente() {

        StringBuilder mensagemOpcoes = stringMenuCliente();
        int opcao;

        do{
            System.out.println(mensagemOpcoes);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    new ClienteView().buscarLivro();
                    opcao = 0;
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
                default:
                    System.out.println("Opção inválida, digite novamente.");
                    break;
            }
        }while(opcao < 1 || opcao > 7);
    }

    public void menuFuncionario() {

        int opcao = 0;
        StringBuilder mensagemOpcoes = stringMenuFuncionario();

        do{
            System.out.println(mensagemOpcoes);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    
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

    private static StringBuilder stringMenuInicial() {
        StringBuilder mensagemOpcoes = new StringBuilder("\nPara continuar, faça login ou cadastre-se.");
        mensagemOpcoes.append("\n---- SISTEMA DE LIVRARIA ----");
        mensagemOpcoes.append("\n1 - Login");
        mensagemOpcoes.append("\n2 - Cadastro");
        mensagemOpcoes.append("\n3 - Sair");
        mensagemOpcoes.append("\nEscolha uma opção:");
        return mensagemOpcoes;
    }

    private static StringBuilder stringMenuCliente() {
        StringBuilder mensagemOpcoes = new StringBuilder("\n---- MENU CLIENTE ----");
        mensagemOpcoes.append("\n1 - Buscar Livro");
        mensagemOpcoes.append("\n2 - Listar Todos Pedidos");
        mensagemOpcoes.append("\n3 - Comprar Livro");
        mensagemOpcoes.append("\n4 - Acompanhar Pedido");
        mensagemOpcoes.append("\n5 - Sair");
        mensagemOpcoes.append("\nEscolha uma opção: ");
        return mensagemOpcoes;
    }

    private static StringBuilder stringMenuFuncionario() {
        StringBuilder mensagemOpcoes = new StringBuilder("\n---- MENU FUNCIONARIO ----");
        mensagemOpcoes.append("\n1 - Cadastrar livro");
        mensagemOpcoes.append("\n2 - Buscar Livro");
        mensagemOpcoes.append("\n3 - Listar Pedidos");
        mensagemOpcoes.append("\n4 - Listar Todos Livros");
        mensagemOpcoes.append("\n5 - Alterar Livro");
        mensagemOpcoes.append("\n6 - Excluir Livro");
        mensagemOpcoes.append("\n7 - Sair");
        mensagemOpcoes.append("\nEscolha uma opção: ");
        return mensagemOpcoes;
    }
}
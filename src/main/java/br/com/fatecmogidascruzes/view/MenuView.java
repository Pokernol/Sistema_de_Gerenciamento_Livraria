package br.com.fatecmogidascruzes.view;

import java.util.Scanner;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.entity.Usuario;
import br.com.fatecmogidascruzes.service.impl.ClienteServiceImpl;
import br.com.fatecmogidascruzes.service.impl.PedidoServiceImpl;

public class MenuView {
    
	PedidoServiceImpl pedidoService;	
	ClienteServiceImpl clienteService;
    Scanner scanner = new Scanner(System.in);

    public void menuInicial() {
        
        System.out.println("Bem-vindo ao Sistema de Livraria!");
        Usuario usuario;
        int opcao;

        do {
            System.out.print(stringMenuInicial());
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                	usuario = new LoginView().login();
                    if(usuario instanceof Funcionario){
                        menuFuncionario((Funcionario)usuario);
                    }else{
                        menuCliente((Cliente)usuario);
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

    public void menuCliente(Cliente cliente) {
    	
        int opcao;
        do{
            System.out.println(stringMenuCliente());
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                	//listar todos os pedidos                	
                	System.out.println(pedidoService.buscarPedido(2, cliente.getEmail()));
                    break;
                case 4:
                    break;
                case 5:
                	System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida, digite novamente.");
                    break;
            }
        }while(opcao < 1 || opcao > 5);
    }

    public void menuFuncionario(Funcionario funcionario) {

        int opcao;
        StringBuilder mensagemOpcoes = stringMenuFuncionario();

        do{
            System.out.println(mensagemOpcoes);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    comprarLivro();
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
        StringBuilder mensagemOpcoes = new StringBuilder("\n---- MENU SISTEMA DE LIVRARIA ----");
        mensagemOpcoes.append("\n1 - Buscar Livro");
        mensagemOpcoes.append("\n2 - Listar Todos Livros");
        mensagemOpcoes.append("\n3 - Listar Todos Pedidos");
        mensagemOpcoes.append("\n4 - Comprar Livro");
        mensagemOpcoes.append("\n5 - Sair");
        mensagemOpcoes.append("\nEscolha uma opção: ");
        return mensagemOpcoes;
    }

    private static StringBuilder stringMenuFuncionario() {
        StringBuilder mensagemOpcoes = new StringBuilder("\n---- MENU SISTEMA DE LIVRARIA (FUNCIONÁRIO) ----");
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

    public void comprarLivro() {
        System.out.println("\n---- COMPRAR LIVRO ----");



    }

}
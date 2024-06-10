package br.com.fatecmogidascruzes.view;

import br.com.fatecmogidascruzes.service.impl.ClienteServiceImpl;
import br.com.fatecmogidascruzes.service.impl.FuncionarioServiceImpl;
import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import java.util.Scanner;
import java.time.LocalDate;

public class CadastroUsuarioView {
    ClienteServiceImpl clienteService;
    FuncionarioServiceImpl funcionarioService;
    Scanner scanner = new Scanner(System.in);
    
    public void cadastro() {   
        
        StringBuilder mensagemOpçoes = new StringBuilder("---- Cadastro ----");
        mensagemOpçoes.append("1 - Cadastrar cliente");
        mensagemOpçoes.append("2 - Cadastrar funcionário");
        mensagemOpçoes.append("3 - Voltar");
        mensagemOpçoes.append("Escolha uma opção: ");

        int opcao = 0;

        do {
            System.out.println(mensagemOpçoes.toString());
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("---- CADASTRO CLIENTE ----");
                    if(!cadastroCliente()){
                        opcao = 0;
                    }
                    break;
                case 2:
                    System.out.println("---- CADASTRO FUNCIONÁRIO ----");
                    if(!cadastroFuncionario()){
                        opcao = 0;
                    }
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        } while (opcao < 1 || opcao > 3);
    }

    public Boolean cadastroCliente() {

        StringBuilder mensagemOpçoes = new StringBuilder("---- Método de Pagamento ----");
            mensagemOpçoes.append("1 - Dinheiro");
            mensagemOpçoes.append("2 - Cartão de Crédito");
            mensagemOpçoes.append("3 - Cartão de Débito");
            mensagemOpçoes.append("4 - Pix");
            mensagemOpçoes.append("Escolha uma opção: ");
        int opcao = 0;
        int confirmarCadastro = 0;
        boolean repetir;

        System.out.printf("Digite o seu e-mail: ");
        String email = scanner.next();
        System.out.printf("Digite o seu nome: ");
        String nome = scanner.next();
        System.out.printf("Digite uma Senha: ");
        String senha = scanner.next();
        System.out.printf("Repetir a Senha: ");
        String senhaRepetida = scanner.next();
        System.out.printf("Digite seu endereço (Onde vamos entregar seus pedidos): ");
        String endereco = scanner.next();
        System.out.printf("Digite seu telefone: ");
        String telefone = scanner.next();
        System.out.printf("Escolha um método de pagamento padrão (Pode ser alterado posteriormente): ");
        String metodoPagamento = "";
        do{
            System.out.println(mensagemOpçoes.toString());
            opcao = scanner.nextInt();            
            switch(opcao){
                case 1:
                    metodoPagamento = "Dinheiro";
                    break;
                case 2:
                    metodoPagamento = "Cartão de Crédito";
                    break;
                case 3:
                    metodoPagamento = "Cartão de Débito";
                    break;
                case 4:
                    metodoPagamento = "Pix";
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(opcao < 1 || opcao > 4);

        do{
            if(senha.equals(senhaRepetida) ){
                repetir = false;
            }else{
                System.out.println("As senhas não coincidem. Tente novamente.");
                System.out.printf("Digite uma Senha: ");
                senha = scanner.next();
                System.out.printf("Repetir a Senha: ");
                senhaRepetida = scanner.next();
                repetir = true;
            }
        }while(repetir);

        StringBuilder mensagemConfirmacao = new StringBuilder("Confirme o cadastro:");
            mensagemConfirmacao.append("Nome: " + nome);
            mensagemConfirmacao.append("E-mail: " + email);
            mensagemConfirmacao.append("Endereço: " + endereco);
            mensagemConfirmacao.append("Telefone: " + telefone);
            mensagemConfirmacao.append("Método de Pagamento: " + metodoPagamento);
            mensagemConfirmacao.append("\n Deseja confirmar o cadastro?");
            mensagemConfirmacao.append("1 - Confirmar");
            mensagemConfirmacao.append("2 - Cancelar");
            mensagemConfirmacao.append("Escolha uma opção: ");
        do{
            System.out.println(mensagemConfirmacao.toString());
            confirmarCadastro = scanner.nextInt();
            switch (confirmarCadastro) {
                case 1:
                    clienteService.adicionarCliente(new Cliente(nome, email, senha, endereco, telefone, metodoPagamento, LocalDate.now()));
                    return true;
                case 2:
                    System.out.println("Cadastro cancelado.");
                    return false;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(confirmarCadastro < 1 || confirmarCadastro > 2);
        return false;
    }

    public boolean cadastroFuncionario() {
        
        boolean repetir;
        int confirmarCadastro = 0;

        System.out.printf("Digite o e-mail do funcionário: ");
        String email = scanner.next();
        System.out.printf("Digite o nome do funcionário: ");
        String nome = scanner.next();
        System.out.printf("Digite a Senha: ");
        String senha = scanner.next();
        System.out.printf("Repetir Senha: ");
        String senhaRepetida = scanner.next();
        System.out.printf("Digite o endereço do funcionário: ");
        String endereco = scanner.next();
        System.out.printf("Digite o telefone do funcionário: ");
        String telefone = scanner.next();
        System.out.printf("Digite o cargo do funcionário: ");
        String cargo = scanner.next();

        do{
            if(senha.equals(senhaRepetida)){
                repetir = false;
            }else{
                System.out.println("As senhas não coincidem. Tente novamente.");
                System.out.printf("Digite a Senha: ");
                senha = scanner.next();
                System.out.printf("Repetir a Senha: ");
                senhaRepetida = scanner.next();
                repetir = true;    
            }
        }while(repetir);

        StringBuilder mensagemConfirmacao = new StringBuilder("Confirme o cadastro:");
            mensagemConfirmacao.append("Nome: " + nome);
            mensagemConfirmacao.append("E-mail: " + email);
            mensagemConfirmacao.append("Endereço: " + endereco);
            mensagemConfirmacao.append("Telefone: " + telefone);
            mensagemConfirmacao.append("Cargo: " + cargo);
            mensagemConfirmacao.append("\n Deseja confirmar o cadastro?");
            mensagemConfirmacao.append("1 - Confirmar");
            mensagemConfirmacao.append("2 - Cancelar");
            mensagemConfirmacao.append("Escolha uma opção: ");
            
        do{
            System.out.println(mensagemConfirmacao.toString());
            confirmarCadastro = scanner.nextInt();
            switch (confirmarCadastro) {
                case 1:
                    funcionarioService.adicionarFuncionario(new Funcionario(email, nome, senha, endereco, telefone, cargo, LocalDate.now()));
                    return true;
                case 2:
                    System.out.println("Cadastro cancelado.");
                    return false;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }while(confirmarCadastro < 1 || confirmarCadastro > 2);
        return false;
    }
}
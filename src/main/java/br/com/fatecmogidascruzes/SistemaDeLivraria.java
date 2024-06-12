package br.com.fatecmogidascruzes;

import java.time.LocalDate;
import java.util.List;
import br.com.fatecmogidascruzes.model.entity.*;
import br.com.fatecmogidascruzes.model.repository.*;
import br.com.fatecmogidascruzes.service.impl.*;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;
import br.com.fatecmogidascruzes.view.ClienteView;
import br.com.fatecmogidascruzes.view.MenuView;

public class SistemaDeLivraria {
    public static void main(String[] args) {

        // Repositories
        LivroRepository livroRepository = new LivroRepository();
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        ClienteRepository clienteRepository = new ClienteRepository();
        CategoriaRepository categoriaRepository = new CategoriaRepository();
        PedidoRepository pedidoRepository = new PedidoRepository();        

        // Validator
        UsuarioValidator usuarioValidator = new UsuarioValidator(clienteRepository, funcionarioRepository);

        // Services
        LivroServiceImpl livroService = new LivroServiceImpl(livroRepository);
        FuncionarioServiceImpl funcionarioService = new FuncionarioServiceImpl(funcionarioRepository, usuarioValidator);
        ClienteServiceImpl clienteService = new ClienteServiceImpl(clienteRepository, usuarioValidator);
        CategoriaServiceImpl categoriaService = new CategoriaServiceImpl(categoriaRepository);
        PedidoServiceImpl pedidoService = new PedidoServiceImpl(pedidoRepository);

        /******************************************/

        //TESTES DE ADICIONAR ENTIDADES
        System.out.println("\n**---- ADICIONAR ---**");

        //data de publicacao
        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);
        LocalDate dataDePublicacao1 = LocalDate.of(2020, 7, 20);
        LocalDate dataDePublicacao2 = LocalDate.of(2018, 5, 15);
        LocalDate dataDePublicacao3 = LocalDate.of(2016, 3, 10);

        //Testando adicionar livros
        System.out.println("\n---- ADICIONAR LIVROS ---");
        livroService.adicionarLivro(new Livro("0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao"));
        livroService.adicionarLivro(new Livro("0306406152", "", "O Alquimista", "Portugues", "Paulo Coelho", 10, "HarperCollins", 200, dataDePublicacao1, 150.00, "Romance"));
        livroService.adicionarLivro(new Livro("0060930314", "", "1984", "Ingles", "George Orwell", 5, "Secker & Warburg", 300, dataDePublicacao2, 200.00, "Ficção Científica"));
        livroService.adicionarLivro(new Livro("0451524934", "", "Dom Quixote", "Espanhol", "Miguel de Cervantes", 7, "Francisco de Robles", 1000, dataDePublicacao3, 250.00, "Romance"));

        // Testando adicionar funcionarios
        System.out.println("\n---- ADICIONANDO FUNCIONARIOS ---");
        funcionarioService.adicionarFuncionario(new Funcionario("Ana","Endereço da Ana","ana@email.com", "Senha123", "12934567890", "Cargo da Ana", LocalDate.now()));
        funcionarioService.adicionarFuncionario(new Funcionario("Antony", "Endereço do Antony", "ana@email.com", "Senha321", "12934567890", "Cargo do Antony", LocalDate.now()));
        System.out.println(funcionarioRepository.findAll());

        // Testando adicionar clientes
        System.out.println("\n---- ADICIONANDO CLIENTES ---");
        clienteService.adicionarCliente(new Cliente("Romulo", "Romulandia", "antony@email.com", "RolaBotas123", "11988521035", "moedinhas de 1 centavo", LocalDate.now()));
        clienteService.adicionarCliente(new Cliente("Caio", "dwieifds", "antony@email.com", "Palavraonao", "1198844555", "moedinhas de 1 centavo", LocalDate.now()));
        System.out.println(clienteRepository.findAll());

        // Testando adicionar categorias
        System.out.println("\n---- ADICIONAR CATEGORIA ---" );
        categoriaService.adicionarCategoria(new Categoria("Romance" , "Livros de Romance e Fanfics."));
        System.out.println(categoriaRepository.findAllCategorias());

        //teste de adicionar de pedido
        System.out.println("\n---- ADICIONAR PEDIDO ---" );
        List<Livro> livrosComprados = livroRepository.findByTitulo("1984");
        livrosComprados.addAll(livroRepository.findByTitulo("Dom Quixote"));
        pedidoService.adicionarPedido(new Pedido("leo123@gmail.com", "A culpa é das Estrelas", LocalDate.now(), 1, 50.0, "fatec"));
        pedidoService.adicionarPedido(new Pedido("leo123@gmail.com", "Harry Potter", LocalDate.now(), 1, 50.0, "fatec"));
        System.out.println(pedidoRepository.findAll());
        
        //TESTES MENUS1
        System.out.println(livroRepository.findAllWhereExistEstoque());
        System.out.println("\n\n\n**---- MENUS ---**");

        MenuView menuView = new MenuView();
        menuView.menuCliente();

    }
}
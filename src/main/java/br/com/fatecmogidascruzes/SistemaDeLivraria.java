package br.com.fatecmogidascruzes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fatecmogidascruzes.model.entity.*;
import br.com.fatecmogidascruzes.model.repository.*;
import br.com.fatecmogidascruzes.service.impl.ClienteServiceImpl;
import br.com.fatecmogidascruzes.service.impl.FuncionarioServiceImpl;
import br.com.fatecmogidascruzes.service.impl.CategoriaServiceImpl;
import br.com.fatecmogidascruzes.service.impl.LivroServiceImpl;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

public class SistemaDeLivraria {
    public static void main(String[] args) {

        LivroRepository livroRepository = new LivroRepository();
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        ClienteRepository clienteRepository = new ClienteRepository();
        PedidoRepository pedidoRepository = new PedidoRepository();

        UsuarioValidator usuarioValidator = new UsuarioValidator(clienteRepository, funcionarioRepository);

        LivroServiceImpl service = new LivroServiceImpl(livroRepository);
        ClienteServiceImpl clienteService = new ClienteServiceImpl(clienteRepository, usuarioValidator);
        FuncionarioServiceImpl funcionarioService = new FuncionarioServiceImpl(funcionarioRepository, usuarioValidator);


        //Criação de livros
        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);
        LocalDate dataDePublicacao1 = LocalDate.of(2020, 7, 20);
        LocalDate dataDePublicacao2 = LocalDate.of(2018, 5, 15);
        LocalDate dataDePublicacao3 = LocalDate.of(2016, 3, 10);

        //Adicionando livros
        System.out.println("\n---- ADICIONANDO LIVROS ---");
        service.adicionarLivro(new Livro(1, "0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao"));
        service.adicionarLivro(new Livro(2, "0306406152", "", "O Alquimista", "Portugues", "Paulo Coelho", 10, "HarperCollins", 200, dataDePublicacao1, 150.00, "Romance"));
        service.adicionarLivro(new Livro(3, "0060930314", "", "1984", "Ingles", "George Orwell", 5, "Secker & Warburg", 300, dataDePublicacao2, 200.00, "Ficção Científica"));
        service.adicionarLivro(new Livro(11, "0451524934", "", "Dom Quixote", "Espanhol", "Miguel de Cervantes", 7, "Francisco de Robles", 1000, dataDePublicacao3, 250.00, "Romance"));

        //testando atualizar livros
        System.out.println("\n---- ATUALIZANDO LIVROS ---" );
        System.out.println(livroRepository.findById(1));

        //atualizando livro erro
        service.atualizarLivro(new Livro(1, "0123456789", "", "Biblia", "Portugues", "profeta", 1, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao"));
        System.out.println(livroRepository.findById(1));
        System.out.println(livroRepository.findAllWhereExistEstoque());

        //atualizando livro correto
        service.atualizarLivro(new Livro(1, "0123456789", "", "Biblia", "Portugues", "profeta", 0, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao"));

        System.out.println("\n---- BUSCAR LIVROS ---" );
        System.out.println(service.buscarLivro(7,"Romance"));
        System.out.println(livroRepository.findAllWhereExistEstoque());
        System.out.println(service.buscarLivro(8, "150.00"));
        System.out.println(service.buscarLivro(9, "5"));

        //testando excluir livros
        System.out.println("\n---- EXCLUIR LIVROS ---" );
        LocalDate dataDePublicacao4 = LocalDate.of(2023, 8, 15);
        service.adicionarLivro(new Livro(5, "6584956245", "9786584956247", "O Pequeno Principe", "Portugues", "Antoine de Saint-Exupery", 5, "Editora Garnier", 96, dataDePublicacao4, 19.90, "Acao e Aventura"));

        System.out.println("Tentando excluir livro com ID 1:");
        service.excluirLivroPorId(1);

        System.out.println("Tentando excluir livro com ISBN-10 0306406152:");
        service.excluirLivroPorIsbn10("0306406152");

        System.out.println("Tentando excluir livro com ISBN-13 9786584956247:");
        service.excluirLivroPorIsbn13("9786584956247");

        System.out.println("Tentando excluir livro com ID 6 (inexistente):");
        service.excluirLivroPorId(6);

        System.out.println(livroRepository.findAllWhereExistEstoque());

        //data para string
        String data = LocalDate.now().toString();

        // Testando a criação de Funcionario
        System.out.println("\n---- ADICIONANDO FUNCIONARIOS ---");
        Funcionario ana = new Funcionario(1, "Ana","Endereço da Ana", "ana@email.com", "12934567890", "Cargo da Ana", LocalDate.now());

        funcionarioService.adicionarFuncionario(ana);
        System.out.println(funcionarioRepository.findAll());

        // Testando a criação de cliente
        System.out.println("\n---- ADICIONANDO CLIENTES ---");
        Cliente cliente = new Cliente(1, "Romulo", "Romulandia", "romulo@romail.com", "11988521035", "moedinhas de 1 centavo", LocalDate.now());
        clienteService.adicionarCliente(cliente);
        System.out.println(clienteRepository.findAll());

        // Testando a busca de funcionario
        System.out.println("\n---- BUSCAR FUNCIONARIOS ---" );
        System.out.println(funcionarioService.buscarFuncionario(3, "Ana"));
        System.out.println(funcionarioService.buscarFuncionario(4, "ana@email.com"));
        System.out.println(funcionarioService.buscarFuncionario(3, "Antonythony"));
        System.out.println(funcionarioService.buscarFuncionario(5, "Cargo da Ana"));
        System.out.println(funcionarioService.buscarFuncionario(6, data));

        // Testando a busca de cliente
        System.out.println("\n---- BUSCAR CLIENTES ---" );
        System.out.println(clienteService.buscarCliente(3, "Romulo"));
        System.out.println(clienteService.buscarCliente(4, "romulo@romail.com"));
        System.out.println(funcionarioService.buscarFuncionario(3, "Romulandia"));
        System.out.println(clienteService.buscarCliente(5, "moedinhas de 1 centavo"));
        System.out.println(clienteService.buscarCliente(6, data));

        //testando excluir funcionario
        System.out.println("Tentando excluir a funcionaria Ana com ID 1");
        funcionarioService.excluirFuncionario(1);

        System.out.println("Tentando excluir funcionario com ID 2 (inexistente)");
        funcionarioService.excluirFuncionario(2);

        System.out.println(funcionarioRepository.findAll());

        //testando excluir cliente
        System.out.println("Tentando excluir o cliente Romulo com ID 1");
        clienteService.excluirCliente(1);

        System.out.println("Tentando excluir o cliente com ID 2(inexistente)");
        clienteService.excluirCliente(2);

        System.out.println(clienteRepository.findAll());


        System.out.println("\n---- CATEGORIA ADICIONAR ---" );

        CategoriaRepository categoriaRepository = new CategoriaRepository();
        CategoriaServiceImpl categoriaService = new CategoriaServiceImpl(categoriaRepository);

        categoriaService.adicionarCategoria(new Categoria(1,"Romance" , "Livros de Romance e Fanfics."));
        System.out.println(categoriaRepository.findAllCategorias());
        
        System.out.println("\n---- BUSCAR CATEGORIA PELO NOME ---");
        System.out.println("\nbuscando cateogira romance...");
        System.out.println(categoriaService.buscarCategoriaPorNome("Romance"));
        
        System.out.println("\n\nbuscando cateogira ficcao (inexistente)...");
        System.out.println(categoriaService.buscarCategoriaPorNome("Ficção"));
        
        System.out.println("\n---- CATEGORIA DESTRUIR ---" );
        System.out.println("\n tentando excluir categoria com ID 1");
        categoriaService.excluirCategoria(1);
        System.out.println(categoriaRepository.findAllCategorias());
        
        System.out.println("\n tentando excluir categoria com ID 2 (inexistente)");
        categoriaService.excluirCategoria(2);

        //teste de cadastro de pedido
        List<Livro> livrosComprados = livroRepository.findByTitulo("1984");
        livrosComprados.addAll(livroRepository.findByTitulo("Dom Quixote"));
        pedidoRepository.adicionarPedido(new Pedido("leo123@gmail.com", livrosComprados, LocalDate.now(), 1, 50.0, "fatec"));
        pedidoRepository.adicionarPedido(new Pedido("leo123@gmail.com", livrosComprados, LocalDate.now(), 1, 50.0, "fatec"));
        System.out.println(pedidoRepository.findAll());





    }
}

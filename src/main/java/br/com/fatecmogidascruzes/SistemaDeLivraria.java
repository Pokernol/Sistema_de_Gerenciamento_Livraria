package br.com.fatecmogidascruzes;

import java.time.LocalDate;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.impl.LivroServiceImpl;
import br.com.fatecmogidascruzes.validator.LivroValidator;

public class SistemaDeLivraria {
    public static void main(String[] args) {

        LivroRepository livroRepository = new LivroRepository();
        LivroValidator livroValidator = new LivroValidator();
        LivroServiceImpl service = new LivroServiceImpl(livroRepository, livroValidator);

        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);
        Livro livro = new Livro(1, "0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");

        LocalDate dataDePublicacao1 = LocalDate.of(2020, 7, 20);
        Livro livro1 = new Livro(2, "0306406152", "", "O Alquimista", "Portugues", "Paulo Coelho", 10, "HarperCollins", 200, dataDePublicacao1, 150.00, "Romance");

        LocalDate dataDePublicacao2 = LocalDate.of(2018, 5, 15);
        Livro livro2 = new Livro(3, "0060930314", "", "1984", "Ingles", "George Orwell", 5, "Secker & Warburg", 300, dataDePublicacao2, 200.00, "Ficção Científica");

        LocalDate dataDePublicacao3 = LocalDate.of(2016, 3, 10);
        Livro livro3 = new Livro(4, "0451524934", "", "Dom Quixote", "Espanhol", "Miguel de Cervantes", 7, "Francisco de Robles", 1000, dataDePublicacao3, 250.00, "Romance");

        service.adicionarLivro(livro);
        service.adicionarLivro(livro1);
        service.adicionarLivro(livro2);
        service.adicionarLivro(livro3);

        System.out.println("ID: " + livro.getId() + "\n Título: " + livro.getTitulo() + "\n Autores: " + livro.getAutor() + "\n Estoque: " + livro.getEstoque() + "\n Categoria: " + livro.getCategoria());

        livro = new Livro(1, "0123456789", "", "Biblia", "Portugues", "profeta", -1, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");
        service.atualizarLivro(livro);
        System.out.println(livroRepository.findAllWhereExistEstoque());
        livro = new Livro(1, "0123456789", "", "Biblia", "Portugues", "profeta", 0, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");
        service.atualizarLivro(livro);

        System.out.println(livroRepository.findAllWhereExistEstoque());
    }
}

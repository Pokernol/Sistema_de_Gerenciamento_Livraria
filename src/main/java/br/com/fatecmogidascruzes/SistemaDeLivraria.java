package br.com.fatecmogidascruzes;

import java.time.LocalDate;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.impl.LivroServiceImpl;
import br.com.fatecmogidascruzes.validator.LivroValidator;

public class SistemaDeLivraria {
    public static void main(String[] args) {

        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);

        LivroRepository livroRepository = new LivroRepository();
        LivroValidator livroValidator = new LivroValidator();
        LivroServiceImpl service = new LivroServiceImpl(livroRepository, livroValidator);

        Livro livro = new Livro(1, "0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");

        service.adicionarLivro(livro);
        
        System.out.println(" ID: " + livro.getId() + "\n Título: " + livro.getTitulo() + "\n Autores: " + livro.getAutor() + "\n Estoque: " + livro.getEstoque() + "\n Categoria: " + livro.getCategoria());

        livro = new Livro(1, "0123456789", "", "Biblia", "Portugues", "profeta", -1, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");

        service.alterarLivro(livro);

        System.out.println(" ID: " + livro.getId() + "\n Título: " + livro.getTitulo() + "\n Autores: " + livro.getAutor() + "\n Estoque: " + livro.getEstoque() + "\n Categoria: " + livro.getCategoria());
    }
}

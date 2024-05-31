package br.com.fatecmogidascruzes;

import java.time.LocalDate;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.impl.LivroServiceImpl;

public class SistemaDeLivraria {
    public static void main(String[] args) {
    	LivroRepository livroRepository = new LivroRepository();
    	LivroServiceImpl service = new LivroServiceImpl(livroRepository);
        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1); // Ano 0000, Janeiro 1
    	
        Livro livro = new Livro(1, "0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");
    	
        service.adicionarLivro(livro);
        
        System.out.println("ID: " + livro.getId());
        System.out.println("ISBN-10: " + livro.getIsbn10());
        System.out.println("ISBN-13: " + livro.getIsbn13());
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Idioma: " + livro.getIdioma());
        System.out.println("Autores: " + livro.getAutores());
        System.out.println("Estoque: " + livro.getEstoque());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("Número de Páginas: " + livro.getNumeroDePaginas());
        System.out.println("Data de Publicação: " + livro.getDataDePublicacao());
        System.out.println("Preço: " + livro.getPreco());
        System.out.println("Categoria: " + livro.getCategoria());
    	
    }
}

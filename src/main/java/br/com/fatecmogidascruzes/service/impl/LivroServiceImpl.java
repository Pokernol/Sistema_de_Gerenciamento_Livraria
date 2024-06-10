package br.com.fatecmogidascruzes.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.LivroService;

public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;

    public LivroServiceImpl(LivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void adicionarLivro(Livro livro) {
        repository.save(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    @Override
    public void atualizarLivro(long id, Livro livro) {
        try {
            repository.atualizarLivro(id, livro);
            System.out.println("Livro " + livro.getTitulo() + " atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void excluirLivroPorId(long id) {
        try {
            Livro livro = repository.findById(id);
            repository.removerLivro(livro);
            System.out.println("Livro removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ID informado.");
        }
    }

    @Override
    public void excluirLivroPorIsbn10(String isbn10) {
        try {
            Livro livro = repository.findByIsbn10(isbn10);
            repository.removerLivro(livro);
            System.out.println("Livro removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ISBN10 informado.");
        }
    }

    @Override
    public void excluirLivroPorIsbn13(String isbn13) {
        try {
            Livro livro = repository.findByIsbn13(isbn13);
            repository.removerLivro(livro);
            System.out.println("Livro removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()  + " Por favor, verifique o ISBN13 informado.");
        }
    }

	@Override
	public List<Livro> buscarLivro(int opcao, String valorBuscar) {	
	    List<Livro> livrosEncontrados = new ArrayList<Livro>();

		switch(opcao){
			case 1:
				livrosEncontrados = repository.findAllWhereExistEstoque();
				break;
			case 2:
				livrosEncontrados.add(repository.findById(Long.parseLong(valorBuscar)));
				break;
			case 3:
				livrosEncontrados = repository.findByTitulo(valorBuscar);
				break;
			case 4:
				livrosEncontrados = repository.findByAutor(valorBuscar);
				break;			
			case 5:
				livrosEncontrados = repository.findByIdioma(valorBuscar);
				break;
			case 6:
				livrosEncontrados = repository.findByEditora(valorBuscar);
				break;
			case 7:
				livrosEncontrados = repository.findByCategoria(valorBuscar);
				break;
			case 8:
				livrosEncontrados = repository.findByPreco(Double.parseDouble(valorBuscar));
				break;
			case 9:
				livrosEncontrados = repository.findByEstoque(Integer.parseInt(valorBuscar));
				break;
			default:
				System.out.println("Opção invalida.");
				break;
		}
		
	    if (livrosEncontrados == null || livrosEncontrados.isEmpty()) {
			System.out.println("Livro não encontrado.");
	    }
	    
		return livrosEncontrados;
	}
}
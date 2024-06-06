package br.com.fatecmogidascruzes.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.LivroService;
import br.com.fatecmogidascruzes.validator.LivroValidator;

public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;

    public LivroServiceImpl(LivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void adicionarLivro(Livro livro) {
        repository.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    @Override
    public void atualizarLivro(Livro livro) {
        try {
            int index = repository.findIndexPorId(livro.getId());
            if (index != -1) {
                repository.alterarLivro(index, livro);
                System.out.println("Livro atualizado com sucesso!");
            } else {
                System.out.println("Ocorreu algo de errado ao atualizar informações do livro, por favor verifique as informações e tente novamente");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public boolean excluirLivroPorId(long id) {
        int index = repository.findIndexPorId(id);
        if (index != -1) {
            repository.delete(index);
            System.out.println("Livro excluído com sucesso!");
            return true;
        } else {
            System.out.println("Livro não encontrado com ID: " + id);
            return false;
        }
    }

    @Override
    public boolean excluirLivroPorIsbn10(String isbn10) {
        Livro livro = repository.findByIsbn10(isbn10);
        if (livro != null) {
            int index = repository.findIndexPorId(livro.getId());
            repository.delete(index);
            System.out.println("Livro excluído com sucesso!");
            return true;
        } else {
            System.out.println("Livro não encontrado com ISBN-10: " + isbn10);
            return false;
        }
    }

    @Override
    public boolean excluirLivroPorIsbn13(String isbn13) {
        Livro livro = repository.findByIsbn13(isbn13);
        if (livro != null) {
            int index = repository.findIndexPorId(livro.getId());
            repository.delete(index);
            System.out.println("Livro excluído com sucesso!");
            return true;
        } else {
            System.out.println("Livro não encontrado com ISBN-13: " + isbn13);
            return false;
        }
    }

	@Override
	public List<Livro> buscarLivro(int opcao, String valorBuscar) {	
	    List<Livro> livrosEncontrados = new ArrayList<Livro>();

		switch(opcao){
			case 1:
				livrosEncontrados = repository.findAllLivros();
				break;
			case 2:
				livrosEncontrados =  repository.findById(Integer.parseInt(valorBuscar));
				break;
			case 3:
				livrosEncontrados =  repository.findByTitulo(valorBuscar);
				break;
			case 4:
				livrosEncontrados = repository.findByAutor(valorBuscar);
				break;			
			case 5:
				livrosEncontrados = repository.findByIdioma(valorBuscar);
				break;
			case 6:
				livrosEncontrados =  repository.findByEditora(valorBuscar);
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
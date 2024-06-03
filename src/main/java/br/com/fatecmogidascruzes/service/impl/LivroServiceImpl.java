package br.com.fatecmogidascruzes.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.LivroService;
import br.com.fatecmogidascruzes.validator.LivroValidator;

public class LivroServiceImpl implements LivroService {

    private final LivroRepository repository;
    private final LivroValidator validator;

    public LivroServiceImpl(LivroRepository repository, LivroValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void adicionarLivro(Livro livro) {
        if (validator.validarAdicionar(livro)){
            repository.adicionarLivro(livro);
            System.out.println("Livro cadastrado com sucesso!");
        }
    }

    @Override
    public void atualizarLivro(Livro livro) {
        int index = repository.findIndexPorId(livro.getId());
        if (index != -1) {
            if (validator.validarAlterar(livro)){
                repository.alterarLivro(index, livro);
                System.out.println("Livro atualizado com sucesso!");
            }
        } else {
            System.out.println("Ocorreu algo de errado ao atualizar informações do livro, por favor verifique as informações e tente novamente");
        }
    }

	@Override
	public List<Livro> buscarLivro(int opcao, String valorBuscar) {	
	    List<Livro> livrosEncontrados = new ArrayList<Livro>();

		switch(opcao) {
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
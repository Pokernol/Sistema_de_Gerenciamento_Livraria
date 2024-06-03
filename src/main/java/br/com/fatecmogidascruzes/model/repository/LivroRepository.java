package br.com.fatecmogidascruzes.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fatecmogidascruzes.model.entity.Livro;

public class LivroRepository {
	
	private final List<Livro> livros = new ArrayList<>();
	
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}

	public void alterarLivro(int index, Livro livro) {
		livros.set(index, livro);
	}

	public int findIndexPorId(long id) {
		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public Livro findByIsbn10(String isbn10) {
		for (Livro livro : livros) {
			if (livro.getIsbn10().equals(isbn10)) {
				return livro;
			}
		}
		return null;
	}

	public Livro findByIsbn13(String isbn13) {
		for (Livro livro : livros) {
			if (livro.getIsbn13().equals(isbn13)) {
				return livro;
			}
		}
		return null;
	}
	
	public void delete(int index) {
		livros.remove(index);
	}

	public List<Livro> findAllWhereExistEstoque() {
		List<Livro> livrosComEstoque = new ArrayList<>();
		for (Livro livro : livros) {
			if (livro.getEstoque() > 0) {
				livrosComEstoque.add(livro);
			}
		}
		return livrosComEstoque;
	}
	
	public List<Livro> findAllLivros() {
		List<Livro> todosLivros = new ArrayList<>();
		for (Livro livro : livros) {
			todosLivros.add(livro);
		}
		return todosLivros;
	}
	
	public List<Livro> findById(Integer id) {
		List<Livro> listaLivros = new ArrayList<>();
		for (Livro livro : livros) {
			if(livro.getId() == id) {
				listaLivros.add(livro);
			}
		}
		return listaLivros;
	}
	
	public List<Livro> findByPreco(Double preco) {
		List<Livro> listaLivros = new ArrayList<>();
		for (Livro livro : livros) {
			if(livro.getPreco() == preco) {
				listaLivros.add(livro);
			}
		}
		return listaLivros;
	}
	
	public List<Livro> findByEstoque(Integer qtd) {
		List<Livro> listaLivros = new ArrayList<>();
		for (Livro livro : livros) {
			if(livro.getEstoque() == qtd) {
				listaLivros.add(livro);
			}
		}
		return listaLivros;
	}
	
	public List<Livro> findByTitulo(String titulo) {
		return livros.stream()
				.filter(livro -> livro.getTitulo().toUpperCase().contains(titulo.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	public List<Livro> findByAutor(String autor) {
		return livros.stream()
				.filter(livro -> livro.getAutor().toUpperCase().contains(autor.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	public List<Livro> findByIdioma(String idioma) {
		return livros.stream()
				.filter(livro -> livro.getIdioma().toUpperCase().contains(idioma.toUpperCase()))
				.collect(Collectors.toList());
	}

	public List<Livro> findByEditora(String editora) {
		return livros.stream()
				.filter(livro -> livro.getEditora().toUpperCase().contains(editora.toUpperCase()))
				.collect(Collectors.toList());
	}	

	public List<Livro> findByCategoria(String categoria) {
		return livros.stream()
				.filter(livro -> livro.getCategoria().toUpperCase().contains(categoria.toUpperCase()))
				.collect(Collectors.toList());
	}
	
}



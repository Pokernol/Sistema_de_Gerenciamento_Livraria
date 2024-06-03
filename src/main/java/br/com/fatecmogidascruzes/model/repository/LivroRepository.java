package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Livro;

import java.util.ArrayList;
import java.util.List;

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

}



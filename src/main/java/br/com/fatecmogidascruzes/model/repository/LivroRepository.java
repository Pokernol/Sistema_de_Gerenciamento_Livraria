package br.com.fatecmogidascruzes.model.repository;

import java.util.ArrayList;
import java.util.List;
import br.com.fatecmogidascruzes.model.entity.Livro;

public class LivroRepository {
	
	private final List<Livro> livros = new ArrayList<>();
	
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}

	public int findIndexPorId(long id) {
		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

}



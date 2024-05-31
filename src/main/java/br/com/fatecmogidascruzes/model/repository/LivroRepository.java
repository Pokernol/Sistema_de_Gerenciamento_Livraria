package br.com.fatecmogidascruzes.model.repository;

import java.util.ArrayList;
import java.util.List;
import br.com.fatecmogidascruzes.model.entity.Livro;

public class LivroRepository {
	
	private List<Livro> livros = new ArrayList<>();
	
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}
}



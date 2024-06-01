package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Livro;

public interface LivroService {
	
	void adicionarLivro(Livro livro);
	void alterarLivro(Livro livro);
}

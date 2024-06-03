package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Livro;

public interface LivroService {
	
	void adicionarLivro(Livro livro);
	void atualizarLivro(Livro livro);
    boolean excluirLivroPorId(long id);
    boolean excluirLivroPorIsbn10(String isbn10);
    boolean excluirLivroPorIsbn13(String isbn13);
}

package br.com.fatecmogidascruzes.service;

import java.util.List;

import br.com.fatecmogidascruzes.model.entity.Livro;

public interface LivroService {
	
	void adicionarLivro(Livro livro);
	void atualizarLivro(Livro livro);
    boolean excluirLivroPorId(long id);
    boolean excluirLivroPorIsbn10(String isbn10);
    boolean excluirLivroPorIsbn13(String isbn13);
	List<Livro> buscarLivro(int opcao, String valorBuscar);
}

package br.com.fatecmogidascruzes.service;

import java.util.List;

import br.com.fatecmogidascruzes.model.entity.Livro;

public interface LivroService {
	
	void adicionarLivro(Livro livro);
	void atualizarLivro(Livro livro);
	List<Livro> buscarLivro(int opcao, String valorBuscar);
}

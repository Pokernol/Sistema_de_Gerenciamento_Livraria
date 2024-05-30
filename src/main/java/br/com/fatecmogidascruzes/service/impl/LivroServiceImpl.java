package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.LivroService;

public class LivroServiceImpl implements LivroService {

	private LivroRepository repository;

	public LivroServiceImpl(LivroRepository repository) {

		super();
		this.repository = repository;

	}

	@Override
	public void adicionarLivro(Livro livro) {
		
		boolean valido = validarAdicionar(livro);

		if (valido) {
			repository.adicionarLivro(livro);
		}

	}

	@Override
	public boolean validarAdicionar(Livro livro) {

		if (livro.getIsbn10() != null && !livro.getIsbn10().isEmpty()) {
			if (livro.getIsbn10().length() != 10 || !livro.getIsbn10().matches("[0-9]{9}[0-9X]")) {
				return false;
			} else {

				int soma = 0;
				for (int i = 0; i < 9; i++) {
					soma += (10 - i) * Character.getNumericValue(livro.getIsbn10().charAt(i));
				}

				soma = (11 - (soma % 11)) % 11;
				char ultimoDigito = soma == 10 ? 'X' : Character.forDigit(soma, 10);
				return livro.getIsbn10().charAt(9) == ultimoDigito;
			}
		}

		if (livro.getIsbn13() != null && !livro.getIsbn13().isEmpty()) {
			if (livro.getIsbn13().length() != 13 || !livro.getIsbn13().matches("[0-9]{13}")) {
				return false;
			} else {

				int soma = 0;
				for (int i = 0; i < 12; i++) {
					soma += ((i % 2 == 0) ? 1 : 3) * Character.getNumericValue(livro.getIsbn13().charAt(i));
				}

				soma = (10 - (soma % 10)) % 10;
				char ultimoDigito = Character.forDigit(soma, 10);

				return livro.getIsbn13().charAt(12) == ultimoDigito;
				
			}
		}
		
		if (livro.getTitulo() == null) {
			return false;
		}

		if (livro.getIdioma() == null) {
			return false;
		}

		if (livro.getAutores() == null) {
			return false;
		}

		if (livro.getEstoque() <= 0) {
			return false;
		}

		if (livro.getEditora() == null) {
			return false;
		}

		if (livro.getDataDePublicacao() == null) {
			return false;
		}

		if (livro.getNumeroDePaginas() <= 0) {
			return false;
		}
		
		if (livro.getCategoria() == null) {
			return false;
		}
		
		return true;
	}
}
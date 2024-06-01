package br.com.fatecmogidascruzes.validator;

import br.com.fatecmogidascruzes.model.entity.Livro;

public class LivroValidator {

    public boolean validarAdicionar(Livro livro) {
        if (livro.getIsbn10() != null && !livro.getIsbn10().isEmpty()) {
            if (!validarIsbn10(livro)) {
                System.out.println("ISBN-10 inválido.");
                return false;
            }
        }

        if (livro.getIsbn13() != null && !livro.getIsbn13().isEmpty()) {
            if (!validarIsbn13(livro)) {
                System.out.println("ISBN-13 inválido.");
                return false;
            }
        }

        if (livro.getEstoque() <= 0) {
            System.out.println("Por favor preencha a quantidade para adicionar no estoque corretamente.");
            return false;
        }

        return validarvazio(livro);
    }

    public boolean validarAlterar(Livro livro) {
        if (livro.getIsbn10() != null && !livro.getIsbn10().isEmpty()) {
            if (!validarIsbn10(livro)) {
                System.out.println("ISBN-10 inválido.");
                return false;
            }
        }

        if (livro.getIsbn13() != null && !livro.getIsbn13().isEmpty()) {
            if (!validarIsbn13(livro)) {
                System.out.println("ISBN-13 inválido.");
                return false;
            }
        }

        if (livro.getEstoque() < 0) {
            System.out.println("Não pode adicionar estoque negativo.");
            return false;
        }

        return validarvazio(livro);
    }

    public boolean validarvazio(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            System.out.println("Por favor preencha o título corretamente.");
            return false;
        }

        if (livro.getIdioma() == null || livro.getIdioma().isEmpty()) {
            System.out.println("Por favor preencha o idioma corretamente.");
            return false;
        }

        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            System.out.println("Por favor preencha os autores corretamente.");
            return false;
        }

        if (livro.getEditora() == null || livro.getEditora().isEmpty()) {
            System.out.println("Por favor preencha a editora corretamente.");
            return false;
        }

        if (livro.getDataDePublicacao() == null) {
            System.out.println("Por favor preencha a data de publicação corretamente.");
            return false;
        }

        if (livro.getNumeroDePaginas() <= 0) {
            System.out.println("Por favor preencha o número de páginas corretamente.");
            return false;
        }

        if (livro.getCategoria() == null || livro.getCategoria().isEmpty()) {
            System.out.println("Por favor preencha a categoria corretamente.");
            return false;
        }
        return true;
    }

    public boolean validarIsbn10(Livro livro) {
        if (livro.getIsbn10().length() != 10 || !livro.getIsbn10().matches("[0-9]{9}[0-9X]")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * Character.getNumericValue(livro.getIsbn10().charAt(i));
        }

        soma = (11 - (soma % 11)) % 11;
        char ultimoDigito = (soma == 10) ? 'X' : Character.forDigit(soma, 10);
        return livro.getIsbn10().charAt(9) == ultimoDigito;
    }

    public boolean validarIsbn13(Livro livro) {
        if (livro.getIsbn13().length() != 13 || !livro.getIsbn13().matches("[0-9]{13}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += ((i % 2 == 0) ? 1 : 3) * Character.getNumericValue(livro.getIsbn13().charAt(i));
        }

        soma = (10 - (soma % 10)) % 10;
        char ultimoDigito = Character.forDigit(soma, 10);
        return livro.getIsbn13().charAt(12) == ultimoDigito;
    }

}

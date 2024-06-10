package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.LivroRepository;
import br.com.fatecmogidascruzes.service.impl.LivroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LivroServiceTest {

    private LivroRepository livroRepository;
    private LivroServiceImpl service;

    @BeforeEach
    public void setUp() {
        livroRepository = mock(LivroRepository.class);
        service = new LivroServiceImpl(livroRepository);
    }

    @Test
    public void testAdicionarLivro() {
        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);
        Livro livro = new Livro("0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");

        service.adicionarLivro(livro);

        verify(livroRepository, times(1)).adicionarLivro(livro);
    }

    @Test
    public void testAtualizarLivro() {
        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);
        Livro livro = new Livro("0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");

        livro = new Livro(livro.getIsbn10(), livro.getIsbn13(), livro.getTitulo(), livro.getIdioma(), "profeta", 0, livro.getEditora(), livro.getNumeroDePaginas(), livro.getDataDePublicacao(), livro.getPreco(), livro.getCategoria());

        service.atualizarLivro(livro.getId(), livro);

        verify(livroRepository, times(1)).atualizarLivro(0, livro);
    }

    @Test
    public void testFindAllWhereExistEstoque() {
        LocalDate dataDePublicacao = LocalDate.of(0, 1, 1);
        Livro livro = new Livro("0123456789", "", "Biblia", "Portugues", "Jesus", 7, "Reino do Ceus", 1000, dataDePublicacao, 300.00, "Religiao");
        Livro livro1 = new Livro("0306406152", "", "O Alquimista", "Portugues", "Paulo Coelho", 10, "HarperCollins", 200, LocalDate.of(2020, 7, 20), 150.00, "Romance");

        List<Livro> livros = Arrays.asList(livro, livro1);

        when(livroRepository.findAllWhereExistEstoque()).thenReturn(livros);

        List<Livro> result = livroRepository.findAllWhereExistEstoque();

        assertEquals(2, result.size());
        verify(livroRepository, times(1)).findAllWhereExistEstoque();
    }
}

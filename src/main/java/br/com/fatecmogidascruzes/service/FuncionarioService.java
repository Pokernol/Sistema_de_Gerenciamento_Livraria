package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.entity.Livro;

import java.util.List;

public interface FuncionarioService {

    void adicionarFuncionario(Funcionario funcionario);
    List<Funcionario> buscarFuncionario(int opcao, String valorBuscar);


}

package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.service.FuncionarioService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository repository;
    private final UsuarioValidator validator;

    public FuncionarioServiceImpl(FuncionarioRepository repository, UsuarioValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        if(validator.validarFuncionario(funcionario)){
            repository.adicionarFuncionario(funcionario);
            System.out.println("Funcionario " + funcionario.getNome() + " adicionado com sucesso!");
        }
    }
    
    @Override
    public boolean excluirFuncionario(int id) {
        if (repository.removerFuncionario(id)) {
            System.out.println("Funcionaria(o) com ID " + id + " excluído com sucesso!");
            return true;
        } else {
            System.out.println("Funcionaria(o) com ID " + id + " não encontrado.");
            return false;
        }
    }

}

package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.service.FuncionarioService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository repository;
    private final UsuarioValidator validator;

    public FuncionarioServiceImpl(FuncionarioRepository repository, UsuarioValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) throws IllegalArgumentException{
        try {
            if(validator.validarEmail(funcionario, funcionario.getEmail())){
                repository.adicionarFuncionario(funcionario);
                System.out.println("Funcionario " + funcionario.getNome() + " adicionado com sucesso!");
            } else{ 
                throw new IllegalArgumentException("Funcionario não pode ser adicionado, email já cadastrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
    
    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        try { 
            repository.alterarFuncionario(funcionario);
            System.out.println("Funcionario " + funcionario.getNome() + " atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    
    }

    @Override
    public boolean excluirFuncionario(int id) {
        try {
            repository.removerFuncionario(id);
            System.out.println("Funcionario removido com sucesso!");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Funcionario> buscarFuncionario(int opcao, String valorBuscar) {
        List<Funcionario> funcionariosEncontrados = new ArrayList<Funcionario>();

        switch(opcao){
            case 1:
                funcionariosEncontrados = repository.findAll();
                break;
            case 2:
                funcionariosEncontrados.add(repository.findById(Integer.parseInt(valorBuscar)));
                break;
            case 3:
                funcionariosEncontrados = repository.findByNome(valorBuscar);
                break;
            case 4:
                funcionariosEncontrados.add(repository.findByEmail(valorBuscar));
                break;
            case 5:
                funcionariosEncontrados = repository.findByCargo(valorBuscar);
                break;
            case 6:
                funcionariosEncontrados = repository.findByDataContratacao(LocalDate.parse(valorBuscar));
                break;
            default:
                System.out.println("Opção invalida.");
                break;
        }

        if (funcionariosEncontrados == null || funcionariosEncontrados.isEmpty()) {
            System.out.println("Funcionario buscado por '" + valorBuscar + "' não encontrado.");
        }

        return funcionariosEncontrados;
    }
}

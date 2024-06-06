package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;
import br.com.fatecmogidascruzes.service.FuncionarioService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

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
    public void adicionarFuncionario(Funcionario funcionario) {
        if(validator.validarFuncionario(funcionario)){
            repository.adicionarFuncionario(funcionario);
            System.out.println("Funcionario " + funcionario.getNome() + " adicionado com sucesso!");
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
                funcionariosEncontrados =  repository.findById(Integer.parseInt(valorBuscar));
                break;
            case 3:
                funcionariosEncontrados =  repository.findByNome(valorBuscar);
                break;
            case 4:
                funcionariosEncontrados = repository.findByEmail(valorBuscar);
                break;
            case 5:
                funcionariosEncontrados = repository.findByCargo(valorBuscar);
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

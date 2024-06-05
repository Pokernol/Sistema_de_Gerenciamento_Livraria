package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> findAll() {
        return funcionarios;
    }
    
    public Funcionario findById(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public boolean removerFuncionario(int id) {
        Funcionario funcionario = findById(id);
        if (funcionario != null) {
            return funcionarios.remove(funcionario);
        }
        return false;
    }

}

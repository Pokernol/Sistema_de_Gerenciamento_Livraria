package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioRepository {

    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario) {
            funcionarios.add(funcionario);
    }
    
    public List<Funcionario> findAll() {
        return funcionarios;
    }
    
    public int findIndexPorId(long id) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == id) {
                return i;
            }
        } 
        return -1; 
    }

    public void alterarFuncionario(Funcionario funcionario) {
        int index = findIndexPorId(funcionario.getId());
        if (index != -1) {
            funcionarios.set(index, funcionario);
        }
        else{
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações do funcionario, por favor verifique as informações e tente novamente");
        }
    }

    public void removerFuncionario(int id) {
        int index = findIndexPorId(id);
        if (index != -1) {
             funcionarios.remove(index);
        }
    }
    
    public Funcionario findById(Integer id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Funcionario findByEmail(String email) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getEmail().toUpperCase().contains(email.toUpperCase()))
                .findFirst().orElse(null);
    }

    public List<Funcionario> findByCargo(String cargo) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getCargo().toUpperCase().contains(cargo.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Funcionario> findByDataContratacao(LocalDate dataContratacao) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getDataContratacao().equals(dataContratacao))
                .collect(Collectors.toList());
    }

}

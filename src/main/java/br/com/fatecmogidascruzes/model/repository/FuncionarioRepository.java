package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;
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

    public List<Funcionario> findById(int id) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getId() == id)
                .collect(Collectors.toList());
    }

    public List<Funcionario> findByNome(String nome) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Funcionario> findByEmail(String email) {
        return funcionarios.stream()
                .filter(cliente -> cliente.getEmail().toUpperCase().contains(email.toUpperCase()))
                .collect(Collectors.toList());
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

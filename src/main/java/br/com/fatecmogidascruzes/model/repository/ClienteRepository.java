package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public int findIndexPorId(long id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                return i;
            }
        } 
        return -1; 
    }
   
    public void atualizarCliente(long id, Cliente cliente) {
        int index = findIndexPorId(id);
        if (index != -1) {
            clientes.set(index, cliente);
        }
        else{
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações do cliente, por favor verifique as informações e tente novamente");
        }
    }

    public boolean removerCliente(int id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            return clientes.remove(cliente);
        }
        return false;
    }

    public List<Cliente> findAll() {
        return clientes;
    }

    public Cliente findById(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Cliente> findByNome(String nome) {
        return clientes.stream()
                .filter(cliente -> cliente.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public Cliente findByEmail(String email) {
        return clientes.stream()
                .filter(cliente -> cliente.getEmail().toUpperCase().contains(email.toUpperCase()))
                .findFirst().orElse(null);
    }

    public List<Cliente> findByMetodoPagamento(String metodoPagamento) {
        return clientes.stream()
                .filter(cliente -> cliente.getMetodoPagamento().toUpperCase().contains(metodoPagamento.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Cliente> findByDataCadastro(LocalDate dataCadastro) {
        return clientes.stream()
                .filter(cliente -> cliente.getDataCadastro().equals(dataCadastro))
                .collect(Collectors.toList());
    }

}

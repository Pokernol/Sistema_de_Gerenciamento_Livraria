package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> findAll() {
        return clientes;
    }

    public Cliente findById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> findByNome(String nome) {
        return clientes.stream()
                .filter(cliente -> cliente.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Cliente> findByEmail(String email) {
        return clientes.stream()
                .filter(cliente -> cliente.getEmail().toUpperCase().contains(email.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Cliente> findByMetodoPagamento(String metodoPagamento) {
        return clientes.stream()
                .filter(cliente -> cliente.getMetodoPagamento().toUpperCase().contains(metodoPagamento.toUpperCase()))
                .collect(Collectors.toList());
    }
    
    public boolean removerCliente(int id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            return clientes.remove(cliente);
        }
        return false;
    }

}

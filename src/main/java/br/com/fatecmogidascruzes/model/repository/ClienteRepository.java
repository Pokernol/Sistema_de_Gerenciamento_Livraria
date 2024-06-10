package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();
    private long ultimoId = 0;

    public void save(Cliente cliente) {
        cliente.setId(++ultimoId);
        clientes.add(cliente);
    }
   
    public void atualizarCliente(long id, Cliente cliente) {
        int index = findIndexPorId(id);
        if (index != -1) {
            cliente.setId(id);
            clientes.set(index, cliente);
        }
        else{
            throw new IllegalArgumentException("Ocorreu algo de errado ao atualizar informações do cliente, por favor verifique as informações e tente novamente");
        }
    }

    public void removerCliente(long id) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            clientes.remove(cliente);
        } else 
            throw new IllegalArgumentException("Cliente não encontrado.");
    }

    public List<Cliente> findAll() {
        return clientes;
    }

    private int findIndexPorId(long id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .map(clientes::indexOf)
                .orElse(-1);
    }

    public Cliente findById(long id) {
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

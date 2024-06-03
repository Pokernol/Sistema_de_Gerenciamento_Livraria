package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> findAll() {
        return clientes;
    }
}

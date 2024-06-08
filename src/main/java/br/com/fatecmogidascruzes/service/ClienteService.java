package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import java.util.List;

public interface ClienteService {

    void adicionarCliente(Cliente cliente);
    List<Cliente> buscarCliente(int opcao, String valorBuscar);
    boolean excluirCliente(int id);

}

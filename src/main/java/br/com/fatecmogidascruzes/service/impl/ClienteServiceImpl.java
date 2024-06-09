package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.service.ClienteService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final UsuarioValidator validator;

    public ClienteServiceImpl(ClienteRepository repository, UsuarioValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        repository.adicionarCliente(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso!");
    
    }

    @Override
    public List<Cliente> buscarCliente(int opcao, String valorBuscar) {
        List<Cliente> clientesEncontrados = new ArrayList<Cliente>();

        switch(opcao){
            case 1:
                clientesEncontrados = repository.findAll();
                break;
            case 2:
                clientesEncontrados.add(repository.findById(Integer.parseInt(valorBuscar)));
                break;
            case 3:
                clientesEncontrados =  repository.findByNome(valorBuscar);
                break;
            case 4:
                clientesEncontrados.add(repository.findByEmail(valorBuscar));
                break;
            case 5:
                clientesEncontrados = repository.findByMetodoPagamento(valorBuscar);
                break;
            case 6:
                clientesEncontrados = repository.findByDataCadastro(LocalDate.parse(valorBuscar));
                break;
            default:
                System.out.println("Opção invalida.");
                break;
        }

        if (clientesEncontrados == null || clientesEncontrados.isEmpty()) {
            System.out.println("Cliente buscado por '" + valorBuscar + "' não encontrado.");
        }

        return clientesEncontrados;
    }
   
    @Override
    public boolean excluirCliente(int id) {
        if (repository.removerCliente(id)) {
            System.out.println("Cliente com ID " + id + " excluído com sucesso!");
            return true;
        } else {
            System.out.println("Cliente com ID " + id + " não encontrado.");
            return false;
        }
    }
}

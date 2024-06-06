package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.service.ClienteService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

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
        if(validator.validarUsuario(cliente)){
            repository.adicionarCliente(cliente);
            System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso!");
        }
    }

    @Override
    public List<Cliente> buscarCliente(int opcao, String valorBuscar) {
        List<Cliente> clientesEncontrados = new ArrayList<Cliente>();

        switch(opcao){
            case 1:
                clientesEncontrados = repository.findAll();
                break;
            case 2:
                clientesEncontrados =  repository.findById(Integer.parseInt(valorBuscar));
                break;
            case 3:
                clientesEncontrados =  repository.findByNome(valorBuscar);
                break;
            case 4:
                clientesEncontrados = repository.findByEmail(valorBuscar);
                break;
            case 5:
                clientesEncontrados = repository.findByMetodoPagamento(valorBuscar);
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
}

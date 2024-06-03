package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.service.ClienteService;
import br.com.fatecmogidascruzes.validator.UsuarioValidator;

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
}

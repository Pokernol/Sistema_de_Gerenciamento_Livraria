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
        try {
            if(validator.validarEmail(cliente)){
                repository.adicionarCliente(cliente);
                System.out.println("Funcionario " + cliente.getNome() + " adicionado com sucesso!");

            } else{ 
                throw new IllegalArgumentException("Funcionario não pode ser adicionado, email já cadastrado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    

    @Override
    public void atualizarCliente(long id, Cliente cliente) {
        try {
            repository.atualizarCliente(id, cliente);
            System.out.println("Funcionario " + cliente.getNome() + " atualizado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
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
                clientesEncontrados.add(repository.findById(Integer.parseInt(valorBuscar)));
                break;
            case 3:
                clientesEncontrados = repository.findByNome(valorBuscar);
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
    public void excluirCliente(int id) {
        try {
            repository.removerCliente(id);
            System.out.println("Funcionario removido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor, verifique o ID informado.");
        }
    }
}

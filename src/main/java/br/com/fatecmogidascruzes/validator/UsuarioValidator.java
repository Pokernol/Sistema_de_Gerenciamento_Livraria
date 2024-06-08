package br.com.fatecmogidascruzes.validator;

import br.com.fatecmogidascruzes.model.entity.Usuario;
import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;

import java.util.List;

public class UsuarioValidator {

    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;


    public UsuarioValidator(ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository) {
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public boolean validarEmail(Usuario usuario, String email) {
        if (usuario instanceof Funcionario) {
            List<Funcionario> listaDeFuncionarios = funcionarioRepository.findAll();
            for (Funcionario funcionario : listaDeFuncionarios) {
        
                if (funcionario.getEmail().equals(email)) {
                    return false;
                }
            }
        } else if (usuario instanceof Cliente){
            List<Cliente> listaDeClientes = clienteRepository.findAll();
            for (Cliente cliente : listaDeClientes) {
                if (cliente.getEmail().equals(email)) {
                    System.out.println("Cliente já cadastrado com este email.");
                    return false;
                }
            }
        }

        return true;
    }
}

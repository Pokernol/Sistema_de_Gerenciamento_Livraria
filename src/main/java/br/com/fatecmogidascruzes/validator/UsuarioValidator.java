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

    public boolean validarUsuario(Usuario usuario) {

        if (!validarTelefone(usuario))
            return false;

        if (!validarvazio(usuario))
            return false;

        return validarEmail(usuario);
    }

    public boolean validarFuncionario(Funcionario funcionario) {

        if (!validarUsuario(funcionario))
            return false;

        return validarCargo(funcionario);

    }

    public boolean validarvazio(Usuario usuario) {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            System.out.println("Por favor preencha o Nome corretamente.");
            return false;
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            System.out.println("Por favor preencha o Email corretamente.");
            return false;
        }

        if (usuario.getEndereco() == null || usuario.getEndereco().isEmpty()) {
            System.out.println("Por favor preencha o Endereco corretamente.");
            return false;
        }

        return true;
    }

    public boolean validarTelefone(Usuario usuario) {
        if(usuario.getTelefone() != null && !usuario.getTelefone().isEmpty()){
            if (usuario.getTelefone().length() != 11) {
                System.out.println("Por favor preencha o Telefone corretamente.");
                return false;
            }
        }

        return true;
    }

    public boolean validarEmail(Usuario usuario) {
        if (usuario instanceof Funcionario) {
            List<Funcionario> listaDeFuncionarios = funcionarioRepository.findAll();
            for (Funcionario funcionario : listaDeFuncionarios) {
                if (funcionario.getEmail().equals(usuario.getEmail())) {
                    System.out.println("Funcionario já cadastrado com este email.");
                    return false;
                }
            }
        } else if (usuario instanceof Cliente){
            List<Cliente> listaDeClientes = clienteRepository.findAll();
            for (Cliente cliente : listaDeClientes) {
                if (cliente.getEmail().equals(usuario.getEmail())) {
                    System.out.println("Cliente já cadastrado com este email.");
                    return false;
                }
            }
        }

        return true;
    }

    public boolean validarCargo(Funcionario funcionario) {
        if (funcionario.getCargo() == null || funcionario.getCargo().isEmpty()) {
            System.out.println("Por favor preencha o Cargo corretamente.");
            return false;
        }
        return true;
    }

}

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

    public boolean validarEmail(Usuario usuario) {
        if (usuario instanceof Funcionario) {
            List<Funcionario> listaDeFuncionarios = funcionarioRepository.findAll();
            for (Funcionario funcionario : listaDeFuncionarios) {
                if (funcionario.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        } else if (usuario instanceof Cliente){
            List<Cliente> listaDeClientes = clienteRepository.findAll();
            for (Cliente cliente : listaDeClientes) {
                if (cliente.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarSenha(Usuario usuario) {
        if (usuario.getSenha().length() < 8) {
            return false;
        }
        return true;
    }

    public Boolean validarLogin(String email, String senha, int tipoUsuario) {
        if(tipoUsuario == 1){    
            if(clienteRepository.findByEmail(email) != null){
                Cliente cliente = clienteRepository.findByEmail(email);
                if(cliente.getSenha().equals(senha)){
                    System.out.println("Login efetuado com sucesso!");
                    return true;
                } else {
                    System.out.println("Usuario ou senha incorreta.");
                    return false;
                }
            } else {
                System.out.println("Usuário ou senha incorreta.");
                return false;
            }
        }
        if(tipoUsuario == 2){
            if(funcionarioRepository.findByEmail(email) != null){
                Funcionario funcionario = funcionarioRepository.findByEmail(email);
                if(funcionario.getSenha().equals(senha)){
                    System.out.println("Login efetuado com sucesso!");
                    return true;
                } else {
                    System.out.println("Usuario ou senha incorreta.");
                    return false;
                }
            } else {
                System.out.println("Usuário ou senha incorreta.");
                return false;
            }   
        }
        return null;
    }
    

}

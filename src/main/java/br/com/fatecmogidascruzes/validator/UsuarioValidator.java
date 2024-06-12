package br.com.fatecmogidascruzes.validator;

import br.com.fatecmogidascruzes.model.entity.Usuario;
import br.com.fatecmogidascruzes.model.entity.Cliente;
import br.com.fatecmogidascruzes.model.entity.Funcionario;
import br.com.fatecmogidascruzes.model.repository.ClienteRepository;
import br.com.fatecmogidascruzes.model.repository.FuncionarioRepository;

import java.util.List;

public class UsuarioValidator {

    public static boolean validarEmail(Usuario usuario) {
        if (usuario instanceof Funcionario) {
            List<Funcionario> listaDeFuncionarios = FuncionarioRepository.findAll();
            for (Funcionario funcionario : listaDeFuncionarios) {
                if (funcionario.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        } else if (usuario instanceof Cliente){
            List<Cliente> listaDeClientes = ClienteRepository.findAll();
            for (Cliente cliente : listaDeClientes) {
                if (cliente.getEmail().equals(usuario.getEmail())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validarSenha(Usuario usuario) {
        return usuario.getSenha().length() >= 8;
    }

    public static Boolean validarLogin(String email, String senha, int tipoUsuario) {
        if(tipoUsuario == 1){    
            if(ClienteRepository.findByEmail(email) != null){
                Cliente cliente = ClienteRepository.findByEmail(email);
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
            if(FuncionarioRepository.findByEmail(email) != null){
                Funcionario funcionario = FuncionarioRepository.findByEmail(email);
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

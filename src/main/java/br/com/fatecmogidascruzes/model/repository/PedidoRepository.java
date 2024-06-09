package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(Pedido pedido){
            pedidos.add(pedido);
    }
    
    public List<Pedido> findAll(){
        return pedidos;
    }

    public int findIndexById(long id){
        for (int i = 0; i < pedidos.size(); i++){
            if (pedidos.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public Pedido findById(Integer id) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == id)
                .findFirst().orElse(null);
    };
    
    public List<Pedido> findByEmailCliente(String emailCliente) {
        return pedidos.stream()
                .filter(pedido -> pedido.getEmailCliente().toUpperCase().contains(emailCliente.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Pedido> findByTituloLivro(String tituloLivro){
        return pedidos.stream()
                .filter(pedido -> pedido.getTituloLivro().toUpperCase().contains(tituloLivro.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Pedido> findByStatus(int statusPedido) {
        return pedidos.stream()
                .filter(pedido -> pedido.getStatusPedido() == statusPedido)
                .collect(Collectors.toList());
    }

    public void excluirPedido(long id){
        int index = findIndexById(id);
        if (index != -1){
            pedidos.remove(index);
        } else {
            throw new IllegalArgumentException("Pedido não encontrado.");
        }
    }

}

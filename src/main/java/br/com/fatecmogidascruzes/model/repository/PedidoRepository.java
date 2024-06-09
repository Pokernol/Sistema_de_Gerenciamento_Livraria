package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoRepository {
    private final List<Pedido> pedidos = new ArrayList<>();
    private long ultimoId = 0;

    public void adicionarPedido(Pedido pedido){
            pedido.setId(++ultimoId);
            pedidos.add(pedido);
    }
    
    public List<Pedido> findAll(){
        return pedidos;
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




}


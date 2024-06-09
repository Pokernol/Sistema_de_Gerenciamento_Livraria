package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PedidoRepository {
    static List<Pedido> pedidos = new ArrayList<>();
    private LocalDate dataPedido;

    public void adicionarPedido(Pedido pedido){
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


    public List<Pedido> pesquisarEmailCliente(String emailCliente) {
        return pedidos.stream()
                .filter(pedido -> pedido.getEmailCliente().toUpperCase().contains(emailCliente.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Pedido> pesquisarTituloLivro (String tituloLivro){
        return pedidos.stream()
                .filter(pedido -> pedido.getTituloLivro().toUpperCase().contains(tituloLivro.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Pedido> pesquisarPorStatus(int statusPedido) {
        return pedidos.stream()
                .filter(pedido -> pedido.getStatusPedido() == statusPedido)
                .collect(Collectors.toList());
    }




}


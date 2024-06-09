package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    List<Pedido> pedidos = new ArrayList<>();

        public void adicionarPedido(Pedido pedido){
            pedidos.add(pedido);

        }
        public List<Pedido> findAll(){
            return pedidos;
        }
}

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

        public void excluirPedido(long id){
            int index = findIndexById(id);
            if (index != -1){
                pedidos.remove(index);
            } else {
                throw new IllegalArgumentException("Pedido não encontrado.");
            }
        }

        public int findIndexById(long id){
            for (int i = 0; i < pedidos.size(); i++){
                if (pedidos.get(i).getId() == id){
                    return i;
                }
            }
            return -1;
        }
}

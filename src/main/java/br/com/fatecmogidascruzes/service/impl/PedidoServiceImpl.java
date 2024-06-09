package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Pedido;
import br.com.fatecmogidascruzes.model.repository.PedidoRepository;
import br.com.fatecmogidascruzes.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

    private PedidoRepository pedidoRepository;
    
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        pedidoRepository.adicionarPedido(pedido);
        System.out.println("Pedido efetivado com sucesso!");
    }

    @Override
    public void excluirPedido(long id) {
        try {
            pedidoRepository.excluirPedido(id);
            System.out.println("Pedido excluído com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}


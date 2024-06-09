package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Pedido;
import br.com.fatecmogidascruzes.model.repository.PedidoRepository;
import br.com.fatecmogidascruzes.service.PedidoService;
import java.util.List;

public class PedidoServiceImpl implements PedidoService {

    private static PedidoRepository pedidoRepository;

    //inicia o pedidoRepository, eviatar nullpointer
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        pedidoRepository.adicionarPedido(pedido);
        System.out.println("Pedido efetivado com sucesso!");
    }

    @Override
    public Pedido pesquisarID(int id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> pesquisarEmailCliente(String emailCliente) {
        return pedidoRepository.pesquisarEmailCliente(emailCliente);
    }

    @Override
    public List<Pedido> pesquisarTituloLivro(String tituloLivro) {
        return pedidoRepository.pesquisarTituloLivro(tituloLivro);
    }

    @Override
    public List<Pedido> pesquisarPorStatus(int statusPedido) {
        return pedidoRepository.pesquisarPorStatus(statusPedido);
    }

}


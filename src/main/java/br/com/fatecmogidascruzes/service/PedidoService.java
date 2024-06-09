package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Livro;
import br.com.fatecmogidascruzes.model.entity.Pedido;

import java.util.List;

public interface PedidoService {

    void adicionarPedido(Pedido pedido);

    Pedido pesquisarID(int id);

    List<Pedido> pesquisarEmailCliente(String emailCliente);
    List<Pedido> pesquisarTituloLivro(String tituloLivro);
    List<Pedido> pesquisarPorStatus(int statusPedido);



}

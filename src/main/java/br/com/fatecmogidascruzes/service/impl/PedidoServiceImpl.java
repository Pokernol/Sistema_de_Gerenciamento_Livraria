package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Pedido;
import br.com.fatecmogidascruzes.model.repository.PedidoRepository;
import br.com.fatecmogidascruzes.service.PedidoService;

import java.util.ArrayList;
import java.util.List;

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
    
	public List<Pedido> buscarPedido(int opcao, String valorBuscar) {	
	    List<Pedido> pedidosEncontrados = new ArrayList<>();

		switch(opcao){
			case 1:
                pedidosEncontrados.add(pedidoRepository.findById(Integer.parseInt(valorBuscar)));
                break;
			case 2:
				pedidosEncontrados = pedidoRepository.findByEmailCliente(valorBuscar);
				break;
			case 3:
				pedidosEncontrados = pedidoRepository.findByTituloLivro(valorBuscar);
				break;			
			case 4:
				pedidosEncontrados = pedidoRepository.findByStatus(Integer.parseInt(valorBuscar));
				break;
			default:
				System.out.println("Opção invalida.");
				break;
		}
		
	    if (pedidosEncontrados == null || pedidosEncontrados.isEmpty()) {
			System.out.println("Pedido não encontrado por " + valorBuscar + " informado.");
	    }
	    
		return pedidosEncontrados;
	}

}


package br.com.fatecmogidascruzes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private long id;
    private Cliente idCliente;
    private List<Livro> livros;
    private LocalDate dataPedido;
    private int statusPedido = 1;
    private double precoTotal;
    private String enderecoEntrega;
}
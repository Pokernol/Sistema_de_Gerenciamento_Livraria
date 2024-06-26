package br.com.fatecmogidascruzes.model.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pedido {

    private long id;
    private String emailCliente;
    private String tituloLivro;
    private LocalDate dataPedido;
    private int statusPedido = 1;
    private double precoTotal;
    private String enderecoEntrega;

    public Pedido(String emailCliente, String tituloLivro, LocalDate dataPedido, int statusPedido, double precoTotal, String endrecoEntrega){
        setemailCliente(emailCliente);
        setLivros(tituloLivro);
        setDataPedido(dataPedido);
        setStatusPedido(statusPedido);
        setPrecoTotal(precoTotal);
        setEnderecoEntrega(endrecoEntrega);
    }

    public void setId(long id) {
        try {
            if (id < 0) {
                throw new IllegalArgumentException("ID do pedido não pode ser negativo.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um ID válido.");
        }
    }

    public void setemailCliente(String emailCliente) {
        try {
            if ((emailCliente == null) || emailCliente.isEmpty()){
                throw new IllegalArgumentException("Email do Cliente não pode ser vazio.");
            }
            this.emailCliente = emailCliente;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um email válido.");
        }
    }

    public void setLivros(String tituloLivro) {
        try {
            if ((tituloLivro == null) || tituloLivro.isEmpty()){
                throw new IllegalArgumentException("Você precisa de um livro para fazer um pedido.");
            }
            this.tituloLivro = tituloLivro;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor selecione um livro.");
        }
    }

    public void setDataPedido(LocalDate dataPedido) {
        try {
            if ((dataPedido == null)) {
                throw new IllegalArgumentException("A data do pedido não pode ser nula.");
            }
            this.dataPedido = dataPedido;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira a data correta.");
        }
    }

    public void setStatusPedido(int statusPedido) {
        try {
            if (statusPedido < 1 || statusPedido > 3) {
                throw new IllegalArgumentException("Status do pedido deve ser 1, 2 ou 3.");
            }
            this.statusPedido = statusPedido;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um status válido.");
        }
    }

    public void setPrecoTotal(double precoTotal) {
        try {
            if (precoTotal < 0) {
                throw new IllegalArgumentException("Preço total não pode ser negativo.");
            }
            this.precoTotal = precoTotal;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um preço válido.");
        }
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        try {
            if (enderecoEntrega == null || enderecoEntrega.isEmpty()) {
                throw new IllegalArgumentException("Endereço de entrega não pode ser vazio.");
            }
            this.enderecoEntrega = enderecoEntrega;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um endereço válido.");
        }
    }

    @Override
    public String toString() {
        return "\n Pedido {" +
            "\n  id = " + id +
            "\n  email = " + emailCliente +
            "\n  data compra = " + dataPedido +
            "\n  status = " + statusPedido  +
            "\n  preço total = " + precoTotal +
            "\n  endereço entrega = " + enderecoEntrega+
            "\n }\n";
    }

}
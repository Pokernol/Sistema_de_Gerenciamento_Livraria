package br.com.fatecmogidascruzes.model.entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter

public class Pedido {
    private long id;
    private String emailCliente;
    private List<Livro> livros;
    private LocalDate dataPedido;
    private int statusPedido = 1;
    private double precoTotal;
    private String enderecoEntrega;

    public Pedido(long id, String emailCliente, List<Livro> livros, LocalDate dataPedido, int statusPedido, double precoTotal, String endrecoEntrega){
        this.id = id;
        setemailCliente(emailCliente);
        setLivros(livros);
        setDataPedido(dataPedido);
        setStatusPedido(statusPedido);
        setPrecoTotal(precoTotal);
        setEnderecoEntrega(endrecoEntrega);
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

    public void setLivros(List<Livro> livros) {
        try {
            if ((livros == null) || livros.isEmpty()){
                throw new IllegalArgumentException("Você precisa de um livro para fazer um pedido.");
            }
            this.livros = livros;
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
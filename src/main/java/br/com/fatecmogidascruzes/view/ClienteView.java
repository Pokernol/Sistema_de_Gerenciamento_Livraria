package br.com.fatecmogidascruzes.view;

import java.util.Scanner;

import br.com.fatecmogidascruzes.model.repository.*;
import br.com.fatecmogidascruzes.service.impl.*;
import br.com.fatecmogidascruzes.view.ClienteView;


public class ClienteView {
     Scanner scanner = new Scanner(System.in);

    public void buscarLivro() {
        int opcao;
    
        LivroRepository livroRepository = new LivroRepository();
        LivroServiceImpl livroService = new LivroServiceImpl(livroRepository);

        String valorBuscar = "";
        do {
            System.out.println(mensagemBuscar());
            opcao = scanner.nextInt();
            scanner.nextLine();    
            

            switch (opcao) {
                case 1:
                    System.out.print(livroService.buscarLivro(1,""));
                    break;
                case 2:
                    System.out.print("Digite o titulo do livro: ");
                    valorBuscar = scanner.nextLine();
                    System.out.print(livroService.buscarLivro(3,valorBuscar));
                    break;
                case 3:
                    System.out.print("Digite o autor do livro: ");
                    valorBuscar = scanner.nextLine();
                    System.out.print(livroService.buscarLivro(4,valorBuscar));
                    break;
                case 4:
                    System.out.print("Digite o idioma do livro: ");
                  
                    break;
                case 5:
                    System.out.print("Digite a editora do livro: ");
                
                    break;
                case 6:
                    System.out.print("Digite a categoria do livro: ");
                 
                    break;
                case 7:
                    System.out.print("Digite o preço do livro: ");
                  
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao < 1 || opcao > 7);
    }

    public StringBuilder mensagemBuscar (){
        return new StringBuilder("---- BUSCAR LIVRO ----\n")
            .append("1 - Todos os Livros\n")
            .append("2 - Buscar por Titulo\n")
            .append("3 - Buscar por Autor\n")
            .append("4 - Buscar por Idioma\n")
            .append("5 - Buscar por Editora\n")
            .append("6 - Buscar por Categoria\n")
            .append("7 - Voltar\n")
            .append("Escolha uma opção: ");
    }

}

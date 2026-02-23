package br.com.alura.literalura.principal;

import java.util.Scanner;

public class Principal {
    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                    1 - Buscar livro
                    2 - Listar livros
                    3 - Listar autores
                    0 - Sair
                    """);

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> buscarLivro();
                case 2 -> listarLivros();
                case 3 -> listarAutores();
            }
        }
    }
}

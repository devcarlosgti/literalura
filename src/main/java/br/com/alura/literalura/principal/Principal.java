package br.com.alura.literalura.principal;

import br.com.alura.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    @Autowired
    private LivroService livroService;

    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("""
            1 - Buscar livro pelo título (API + salvar)
            2 - Listar livros registrados (banco)
            3 - Listar autores registrados (banco)
            4 - Listar autores vivos em determinado ano
            5 - Listar livros por idioma
            0 - Sair
            """);

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.println("Digite o nome do livro:");
                    String nomeLivro = sc.nextLine();
                    livroService.buscarLivro(nomeLivro);
                }

                case 2 -> livroService.listarLivros();

                case 3 -> livroService.listarAutores();

                case 4 -> {
                    System.out.println("Digite o ano:");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    livroService.listarAutoresVivosNoAno(ano);
                }

                case 5 -> {
                    System.out.println("Digite o idioma (PT, EN, ES, FR):");
                    String idioma = sc.nextLine().toUpperCase();
                    livroService.listarLivrosPorIdioma(idioma);
                }
            }
        }
    }
}

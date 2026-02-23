package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.AutorDTO;
import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.dto.RespostaApi;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;
//    @Autowired
//    private ConsumoApi consumoApi;

    private ConsumoApi consumoApi = new ConsumoApi();

//    @Autowired
//    private ConverteDados conversor;

    private ConverteDados conversor = new ConverteDados();

    @Transactional
    public void buscarLivro(String nomeLivro) {

        nomeLivro = nomeLivro.replace(" ", "+");

        String url = "https://gutendex.com/books/?search=" + nomeLivro;

        String json = consumoApi.obterDados(url);

        RespostaApi resposta =
                conversor.obterDados(json, RespostaApi.class);

        if (resposta.results().isEmpty()) {
            System.out.println("Livro não encontrado.");
            return;
        }

        LivroDTO livroDTO = resposta.results().get(0);

        // evita duplicar livro
        if (livroRepository.findByTituloIgnoreCase(livroDTO.title()).isPresent()) {
            System.out.println("Livro já cadastrado.");
            return;
        }

        AutorDTO autorDTO = livroDTO.authors().get(0);

        // verifica se autor já existe
        Autor autor = autorRepository
                .findByNomeIgnoreCase(autorDTO.name())
                .orElseGet(() -> {

                    Autor novoAutor = new Autor();
                    novoAutor.setNome(autorDTO.name());
                    novoAutor.setAnoNascimento(autorDTO.birth_year());
                    novoAutor.setAnoFalecimento(autorDTO.death_year());

                    return autorRepository.save(novoAutor);
                });

        Livro livro = new Livro();
        livro.setTitulo(livroDTO.title());
        livro.setIdioma(livroDTO.languages().get(0));
        livro.setDownloads(livroDTO.download_count());
        livro.setAutor(autor);

        livroRepository.save(livro);

        System.out.println("Livro salvo com sucesso!");
    }

    @Transactional
    public void listarLivros() {
        livroRepository.findAll()
                .forEach(System.out::println);
    }

    public void listarAutores() {
        autorRepository.findAll()
                .forEach(System.out::println);
    }

    public void listarAutoresVivosNoAno(int ano) {

        List<Autor> autores = autorRepository.autoresVivosNoAno(ano);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor vivo nesse ano.");
            return;
        }

        autores.forEach(System.out::println);
    }
    public void listarLivrosPorIdioma(String idioma) {

        List<Livro> livros = livroRepository.findByIdiomaIgnoreCase(idioma);

        if (livros.isEmpty()) {
            System.out.println("Não existem livros nesse idioma.");
            return;
        }

        livros.forEach(System.out::println);
    }
}

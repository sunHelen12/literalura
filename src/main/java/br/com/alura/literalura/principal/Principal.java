package br.com.alura.literalura.principal;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.resposta.RespostaAPI;
import br.com.alura.literalura.services.ConsumoAPI;
import br.com.alura.literalura.services.ConverteDados;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private final String ENDERECO = "http://gutendex.com/books/?search=";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private LivroRepository repositorio;
    private List<Livro> livros;
    Optional<Livro> livroBusca;

    public Principal(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
            =====================================
                Escolha uma opção:
                1 - Buscar Livro pelo Título
                2 - Listar Livros Registrados
                3 - Listar Autores Registrados
                4 - Listar Autores Vivos em Determinado Ano
                5 - Listar Livros em Determinado Idioma
                0 - Sair
            """;

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivrosTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosAno();
                    break;
                case 5:
                    listarLivrosIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    
}
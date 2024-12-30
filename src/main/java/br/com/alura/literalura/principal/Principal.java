package br.com.alura.literalura.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import java.util.stream.Collectors;

import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Dados;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.model.records.DadosLivro;
import br.com.alura.literalura.repository.IAutorRepository;
import br.com.alura.literalura.services.ConsumoAPI;
import br.com.alura.literalura.services.ConverteDados;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private final String ENDERECO = "http://gutendex.com/books/";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private IAutorRepository repositorio;

    public Principal(IAutorRepository repositorio){
        this.repositorio = repositorio;
    }   

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
            =================================================
                             LITERALURA MENU
            =================================================
                Escolha uma opção:
                1 - Buscar Livro pelo Título
                2 - Listar Livros Registrados
                3 - Listar Autores Registrados
                4 - Listar Autores Vivos em Determinado Ano
                5 - Listar Livros em Determinado Idioma
            =================================================
                0 - SAIR DO PROGRAMA
            =================================================
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
                    //listarAutoresRegistrados();
                    break;
                case 4:
                    //listarAutoresVivosAno();
                    break;
                case 5:
                   //listarLivrosIdioma();
                    break;
                case 0:
                    System.out.println("SAINDO DO LITERALURA...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public void buscarLivrosTitulo(){
        System.out.println("""
                ===========================================================
                          VOCÊ SELECIONOU BUSCAR LIVRO POR TÍTULO  
                ============================================================
                """);
                
        System.out.print("Inisra o título do livro: ");
        var nome = sc.nextLine();
        var json = consumo.obterDados(ENDERECO + "?search=" + nome.replace(" ", "+").toLowerCase());
                
        // Check if JSON is empty
        if (json.isEmpty() || !json.contains("\"count\":0,\"next\":null,\"previous\":null,\"results\":[]")) {
            var datos = conversor.obterDados(json, Dados.class);
                    
            // Process valid data
            Optional<DadosLivro> livroBuscado = datos.livros().stream()
                                .findFirst();

            if (livroBuscado.isPresent()) {
                System.out.println(
                "\n=========== LIVRO ===========" +
                "\nTítulo: " + livroBuscado.get().titulo() +
                "\nAutor: " + livroBuscado.get().autores().stream()
                .map(a -> a.nome()).limit(1).collect(Collectors.joining()) +
                "\nIdioma: " + livroBuscado.get().idiomas().stream().collect(Collectors.joining()) +
                "\nNúmero de Downloads: " + livroBuscado.get().numeroDeDownloads() +
                "\n==============================\n"
                );
                    
                try {
                List<Livro> livroEncontrado = livroBuscado.stream().map(a -> new Livro(a)).collect(Collectors.toList());
                Autor autorNaAPI = livroBuscado.stream().
                flatMap(l -> l.autores().stream()
                .map(a -> new Autor(a)))
                .collect(Collectors.toList()).stream().findFirst().get();
                                    Optional<Autor> autorNoBD = repositorio.buscarPorNome(livroBuscado.get().autores().stream()
                                            .map(a -> a.nome())
                                            .collect(Collectors.joining()));
                                    Optional<Livro> livroOptional = repositorio.buscarLivroPorTitulo(nome);
                                    if (livroOptional.isPresent()) {
                                        System.out.println("O livro está guardado no banco de dados.");
                                    } else {
                                        Autor autor;
                                        if (autorNoBD.isPresent()) {
                                            autor = autorNoBD.get();
                                            System.out.println("O autor está guardado no banco de dados");
                                        } else {
                                            autor = autorNaAPI;
                                            repositorio.save(autor);
                                        }
                                        autor.setLivros(livroEncontrado);
                                        repositorio.save(autor);
                                    }
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                            } else {
                                System.out.println("Livro não encontrado!");
                            }
        }            
                
                
    }

    public void listarLivrosRegistrados(){
        System.out.println("""
            ===========================================================
                          LISTANDO LIVROS REGISTRADOS...
            ============================================================
            """);
        
        List<Livro> livros = repositorio.buscarTodosOsLivros();
        livros.forEach(l -> System.out.println(
                    "\n=========== LIVRO ===========" +
                            "\nTítulo: " + l.getTitulo() +
                            "\nAutor: " + l.getAutor().getNome() +
                            "\nIdioma: " + l.getIdioma().getIdioma() +
                            "\nNúmero de Downloads: " + l.getNumeroDeDownloads() +
                     "\n==============================\n"
        ));


    }

    
}
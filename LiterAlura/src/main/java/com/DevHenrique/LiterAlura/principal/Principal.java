package com.DevHenrique.LiterAlura.principal;

import com.DevHenrique.LiterAlura.model.DadosBusca;
import com.DevHenrique.LiterAlura.model.DadosLivro;
import com.DevHenrique.LiterAlura.model.Livro;
import com.DevHenrique.LiterAlura.repository.AutorRepository;
import com.DevHenrique.LiterAlura.repository.LivroRepository;
import com.DevHenrique.LiterAlura.service.ConsumoApi;
import com.DevHenrique.LiterAlura.service.ConverteDados;
import com.DevHenrique.LiterAlura.service.LivroService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    
    private Scanner leitura = new Scanner(System.in);
    ConsumoApi consumo = new ConsumoApi();
    ConverteDados conversor = new ConverteDados();
    private  final String ENDERECO = "https://gutendex.com/books/";
    private AutorRepository autorRepository;
    private LivroRepository livroRepository;
    private LivroService service;

    public Principal(AutorRepository autorRepository, LivroRepository livroRepository, LivroService livroService) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
        this.service = livroService;
    }

    public void exibeMenu() {
        int opcao = -1;
        while (opcao != 0) {
            var menu = """
                    ****** Menu *****
                    
                    1- Buscar livro pelo titulo
                    2- Listar livros  Registrados
                    3- Listar autores Registrados
                    4- Listar autores vivo em um determinado ano
                    5- Listar livros em um determinado idioma
                    
                    0- sair
                    
                    """;
            System.out.println(menu);
            System.out.println("Escolha sua opção: ");
            try {
                opcao = leitura.nextInt();
                leitura.nextLine();
            }catch (NumberFormatException e){
                System.out.println("Digite um numero valido");
                continue;
            }
            switch (opcao) {
                case 1:
                    buscarLivroTitulo();
                    break;
                case 2:
                    listarLivroRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarlivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo ....");
                    break;
                default:
                    System.out.println("Opção inválida");


            }
        }
    }

    private void listarlivrosPorIdioma() {

            var menuIdiomas = """
            Escolha o idioma:

            1 - Inglês
            2 - Português
            3 - Espanhol
            4 - Francês
            """;

            System.out.println(menuIdiomas);
            System.out.print("Opção: ");
            int opcao = leitura.nextInt();
            leitura.nextLine();

            String idioma = "";

            switch (opcao) {
                case 1 -> idioma = "en";
                case 2 -> idioma = "pt";
                case 3 -> idioma = "es";
                case 4 -> idioma = "fr";
                default -> {
                    System.out.println("Opção inválida!");
                    return;
                }
            }

            var livros = service.listarPorIdioma(idioma);

            if (livros.isEmpty()) {
                System.out.println("Nenhum livro encontrado nesse idioma.");
                return;
            }

            livros.forEach(System.out::println);


    }

    private void listarAutoresVivos() {
        System.out.println("Ano dos Autores: ");
        try {
        var ano = leitura.nextInt();
        leitura.nextLine();

            var autores = service.listaAutoresVivos(ano);
            if (autores.isEmpty()) {
                System.out.println("Nenhum autor encontrado pelo ano de busca");
                return;
            }
            autores.forEach(a ->
                    System.out.println("Autor: " + a.getNome() + " Ano de Nascimento:" + a.getAnoNascimento()));
        }catch (InputMismatchException e){
            System.out.println("Tenta inserir ano em numero");
            leitura.nextLine();
        }
    }

    private void listarAutoresRegistrados() {
     var autores = service.listarAutor();
     if(autores.isEmpty()){
         System.out.println("Nenhum autor registrado");
         return;
     }
        System.out.println("\n===== AUTORES REGISTRADOS =====\n");

        autores.forEach(a ->
                System.out.printf(
                        "Autor: %-25s | Nascimento: %-6s | Falecimento: %-6s%n",
                        a.nome(),
                        a.anoNascimento() != null ? a.anoNascimento() : "—",
                        a.anoMorte() != null ? a.anoMorte() : "Vivo"
                )
        );

        System.out.println("\n===============================\n");
    }

    private void listarLivroRegistrados() {
       var livros = service.listarLivro();
       if(livros.isEmpty()){
           System.out.println("Nenhum livro registrado.");
           return;
       }
        System.out.println("\n📚 Livros registrados:\n");

        livros.forEach(l -> {
            System.out.println("Título: " + l.titulo());
            System.out.println("Idioma: " + l.linguagem());
            System.out.println("Downloads: " + l.downloadCount());
            System.out.println("Autor: " + l.autor());
            System.out.println("----------------------------");
        });
    }

    private DadosBusca getDadosLivros() {
        System.out.println("Digite o nome do Livro:");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(
                ENDERECO + "?search=" + nomeLivro.replace(" ", "+")
        );
        return conversor.obterDados(json,DadosBusca.class);
    }

    private void buscarLivroTitulo() {
        DadosBusca dadosBusca = getDadosLivros();
       if(dadosBusca.results() == null || dadosBusca.results().isEmpty()){
           System.out.println("Livro nao encontrado!");
           System.out.println("Tente buscar em inglês ou sem acentos.");
           return;
       }
       DadosLivro dadosLivro = dadosBusca.results().get(0);
        service.salvarLivroDaApi(dadosLivro);
        System.out.println("\n📘 Livro encontrado e salvo:\n");

        System.out.println("Título: " + dadosLivro.titulo());
        System.out.println("Idioma: " + dadosLivro.linguagem().get(0));
        System.out.println("Downloads: " + dadosLivro.downloadCount());
        System.out.println("Autor: " + dadosLivro.autor().get(0).nome());

        System.out.println("\nLivro salvo no banco com sucesso!");

    }
}

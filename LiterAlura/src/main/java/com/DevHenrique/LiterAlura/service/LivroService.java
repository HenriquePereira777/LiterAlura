package com.DevHenrique.LiterAlura.service;

import com.DevHenrique.LiterAlura.dto.AutorDTO;
import com.DevHenrique.LiterAlura.dto.LivroDTO;
import com.DevHenrique.LiterAlura.model.Autor;
import com.DevHenrique.LiterAlura.model.DadosAutor;
import com.DevHenrique.LiterAlura.model.DadosLivro;
import com.DevHenrique.LiterAlura.model.Livro;
import com.DevHenrique.LiterAlura.repository.AutorRepository;
import com.DevHenrique.LiterAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;



    public void salvarLivroDaApi(DadosLivro dadosLivro) {

        DadosAutor dadosAutor = dadosLivro.autor().isEmpty() ? null : dadosLivro.autor().get(0);
        if (dadosAutor == null) {
            System.out.println("Livro sem autor válido.");
            return;
        }


        Autor autor = autorRepository
                .findByNomeContainingIgnoreCase(dadosAutor.nome())
                .orElseGet(() -> {

                    Autor novoAutor = new Autor();
                    novoAutor.setNome(dadosAutor.nome());
                    novoAutor.setAnoNascimento(dadosAutor.anoNascimento());
                    novoAutor.setAnoMorte(dadosAutor.anoMorto());

                    return autorRepository.save(novoAutor);
                });

        Livro livro = new Livro();
        livro.setTitulo(dadosLivro.titulo());
        livro.setIdioma(dadosLivro.linguagem().get(0));
        livro.setDownloadCount(dadosLivro.downloadCount());
        livro.setAutor(autor);

        livroRepository.save(livro);
    }

   public List<Autor> listaAutoresVivos(Integer ano){
        return autorRepository.autorVivo(ano);

   }
   public  List<LivroDTO>  listarPorIdioma(String idioma){
        return livroRepository.findByIdioma(idioma);
   }
   public List<LivroDTO> listarLivro(){
        List<Livro> livros = livroRepository.findAll();
        return  livros.stream()
                .map(l-> new LivroDTO(
                        l.getTitulo(),
                        l.getIdioma(),
                        l.getDownloadCount(),
                        l.getAutor() != null ? l.getAutor().getNome() : "Desconhecido"))
                .toList();
   }
   public List<AutorDTO> listarAutor(){
        List<Autor> autor = autorRepository.findAll();
        return autor.stream()
                .map(a-> new AutorDTO(
                        a.getNome(),
                        a.getAnoNascimento(),
                        a.getAnoMorte()
                ))
                .toList();

   }
}

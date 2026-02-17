package com.DevHenrique.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosLivro (
   @JsonAlias("title") String titulo,
   @JsonAlias("authors") List<DadosAutor> autor,
   @JsonAlias("languages") List<String> linguagem,
   @JsonAlias("download_count")  Integer  downloadCount){
    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public List<DadosAutor> autor() {
        return autor;
    }

    @Override
    public List<String> linguagem() {
        return linguagem;
    }

    @Override
    public Integer downloadCount() {
        return downloadCount;
    }

    @Override
    public String toString() {
        return "DadosLivro{" +
                "titulo='" + titulo + '\'' +
                ", autores='" + autor + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", download_count=" + downloadCount +
                '}';
    }
}


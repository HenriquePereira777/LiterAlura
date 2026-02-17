package com.DevHenrique.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosBusca (
   List<DadosLivro> results){

    @Override
    public List<DadosLivro> results() {
        return results;
    }

    @Override
    public String toString() {
        return "DadosBusca{" +
                "results=" + results +
                '}';
    }
}

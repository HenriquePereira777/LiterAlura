package com.DevHenrique.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosAutor(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") Integer anoNascimento,
        @JsonAlias("death_year") Integer anoMorto) {

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public Integer anoNascimento() {
        return anoNascimento;
    }

    @Override
    public Integer anoMorto() {
        return anoMorto;
    }

    @Override
    public String toString() {
        return "DadosAutor{" +
                "nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoMorto=" + anoMorto +
                '}';
    }
}




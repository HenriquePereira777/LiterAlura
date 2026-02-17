package com.DevHenrique.LiterAlura.repository;

import com.DevHenrique.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    Optional<Autor> findByNomeContainingIgnoreCase(String nome);

    @Query("select a from Autor a where a.anoNascimento <= :ano and (a.anoMorte >= :ano or a.anoMorte is null) ")
    List<Autor> autorVivo(@Param("ano") Integer ano);

}

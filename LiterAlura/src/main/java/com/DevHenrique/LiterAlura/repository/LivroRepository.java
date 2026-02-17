package com.DevHenrique.LiterAlura.repository;

import com.DevHenrique.LiterAlura.dto.LivroDTO;
import com.DevHenrique.LiterAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
  List<LivroDTO> findByIdioma(String idioma);
}

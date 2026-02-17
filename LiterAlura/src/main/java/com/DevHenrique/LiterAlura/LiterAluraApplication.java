package com.DevHenrique.LiterAlura;

import com.DevHenrique.LiterAlura.principal.Principal;
import com.DevHenrique.LiterAlura.repository.AutorRepository;
import com.DevHenrique.LiterAlura.repository.LivroRepository;
import com.DevHenrique.LiterAlura.service.ConsumoApi;
import com.DevHenrique.LiterAlura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private LivroService livroService;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(autorRepository, livroRepository, livroService);
		principal.exibeMenu();



	}
}

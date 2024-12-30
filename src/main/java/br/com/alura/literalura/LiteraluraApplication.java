package br.com.alura.literalura;

import br.com.alura.literalura.principal.Principal;
import br.com.alura.literalura.repository.IAutorRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private IAutorRepository repositorio; // Injeção de dependência explícita

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(repositorio);
        principal.exibeMenu();
    }
}

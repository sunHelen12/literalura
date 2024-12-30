package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.model.Idiomas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro>findByTituloContainingIgnoreCase(String titulo);


    List<Livro> findByIdiomas(Idiomas idioma);

   
    @Query("SELECT l.autores FROM Livro l JOIN l.autores a WHERE a.dataNascimento <= :ano AND (a.dataFalecimento IS NULL OR a.dataFalecimento > :ano)")
    List<Object[]> findAutoresVivosNoAno(@Param("ano") int ano);    
    
}

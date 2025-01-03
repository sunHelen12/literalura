package br.com.alura.literalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Idioma;
import br.com.alura.literalura.model.Livro;

public interface IAutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Livro l JOIN l.autor a WHERE a.nome LIKE %:nome%")
    Optional<Autor> buscarPorNome(@Param("nome") String nome);

    @Query("SELECT l FROM Livro l WHERE l.titulo LIKE %:titulo%")
    Optional<Livro> buscarLivroPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT l FROM Autor a JOIN a.livros l")
    List<Livro> buscarTodosOsLivros();

    @Query("SELECT a FROM Autor a WHERE a.dataFalecimento >:ano")
    List<Autor> buscarAutoresVivos(@Param("ano")Integer ano);

    @Query("SELECT l FROM Autor a JOIN a.livros l WHERE l.idioma = :idioma")
    List<Livro> buscarLivrosPorIdioma(@Param("idioma") Idioma idioma);
    
}

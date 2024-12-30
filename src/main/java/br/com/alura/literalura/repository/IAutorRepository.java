package br.com.alura.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.literalura.model.Autor;

public interface IAutorRepository extends JpaRepository<Autor, Long>  {
    
}

package br.com.alura.literalura.model;


import java.util.stream.Collectors;

import br.com.alura.literalura.model.records.DadosLivro;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {   
    @Id
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer numeroDeDownloads;
    @ManyToOne
    private Autor autor;

    public Livro(){}

    public Livro(DadosLivro livro){
        this.id = livro.id();
        this.titulo = livro.titulo();
        this.idioma = Idioma.fromString(livro.idiomas().stream()
                        .limit(1).collect(Collectors.joining()));
        this.numeroDeDownloads = livro.numeroDeDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }  

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Integer numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\n======================LIVRO======================\n" +
                    	"Id: " + id +
                    	", Título: '" + titulo + '\'' +
                    	", Idioma: " + idioma +
                    	", Número de Downloads: " + numeroDeDownloads +
                    	", Autor: " + autor +
            	"\n=================================================\n";

    }
    

}

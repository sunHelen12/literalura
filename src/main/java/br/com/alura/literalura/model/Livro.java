package br.com.alura.literalura.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;
    @Enumerated(EnumType.STRING)
    private Idiomas idiomas;
    private Double numeroDeDownloads;

    public Livro(){}

    public Livro (List<DadosLivro> resultados){}

    public Livro ( String titulo, List<String> idiomas, Double numeroDeDownloads, List<DadosAutor> autores) {
        this.titulo = titulo;
        this.idiomas = Idiomas.fromString(idiomas.get(0));
        this.numeroDeDownloads = numeroDeDownloads;
        this.autores = new ArrayList<>();
        for (DadosAutor autorInformacao : autores ) {
            Autor autor = new Autor (autorInformacao.nome(), autorInformacao.dataNascimento(), autorInformacao.dataFalecimento(), this);
            this.autores.add(autor);
        }
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

    public Idiomas getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idiomas idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Double numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }


    @Override
    public String toString() {
        return "Livro - ID: " + id 
            + ", Título: " + titulo 
            + ", Autores: " + autores 
            + ", Idiomas: " + idiomas
            + ", Número de Downloads: " + numeroDeDownloads;
    }

    
    
}

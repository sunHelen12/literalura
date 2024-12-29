package br.com.alura.literalura.model;

import java.util.List;

import br.com.alura.literalura.util.ControleUtil;

public class Livro {
    private Long id;
    private String titulo;
    private String idioma;
    private Integer numeroDeDownloads;
    private Autor autor;

    public Livro(){}

    public Livro (DadosLivro livro){
        this.titulo = ControleUtil.limitarCaracteres(livro.titulo(), 255);
        this.numeroDeDownloads = livro.numeroDeDownloads();
        if(!livro.idioma().isEmpty()){
            this.idioma = livro.idioma().get(0);
        }if(!livro.autores().isEmpty()){
            for(DadosAutor autor : livro.autores()){
                this.autor = new Autor(autor);
                break;
            }
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
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
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
        return "Livro - ID: " + id 
                + ", Título: " + titulo 
                + ", Idioma: " + idioma 
                + ", Número de Downloads: " + numeroDeDownloads 
                + ", Autor: " + autor;
    }

    
}

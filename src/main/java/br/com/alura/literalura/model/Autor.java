package br.com.alura.literalura.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "autores")
public class Autor {
    private Long id;
    private String nome;
    private Integer dataNascimento;
    private Integer dataFalecimento;
    @ManyToOne
    private Livro livro;
    
    public Autor(String nome, Integer dataNascimento, Integer dataFalecimento, Livro livro) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataFalecimento = dataFalecimento;
        this.livro = livro;
    }

    public Autor(){}

    public Autor (Autor autor){}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Integer getDataFalecimento() {
        return dataFalecimento;
    }
    public void setDataFalecimento(Integer dataFalecimento) {
        this.dataFalecimento = dataFalecimento;
    }

    @Override
    public String toString() {
        return "Autor - ID: " + id 
               + ", Nome: " + nome 
               + ", Data de Nascimento: " + dataNascimento 
               + ", Data de Falecimento: "+ dataFalecimento;
    }

    
}

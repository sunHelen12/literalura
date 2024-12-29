package br.com.alura.literalura.model;

public class Autor {
    private Long id;
    private String nome;
    private Integer dataNascimento;
    private Integer dataFalecimento;

    
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

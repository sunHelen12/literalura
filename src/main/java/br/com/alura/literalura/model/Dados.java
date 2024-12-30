package br.com.alura.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.alura.literalura.model.records.DadosLivro;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(@JsonAlias ("count") Integer conta,
                    @JsonAlias ("results") List<DadosLivro> livros) {

}

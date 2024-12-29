package br.com.alura.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("title") String titulo,
                        @JsonAlias("authors") List<Autor> autores,
                        @JsonAlias("languages") List<String> idioma,
                        @JsonAlias("download_count") Integer numeroDeDownloads){

}

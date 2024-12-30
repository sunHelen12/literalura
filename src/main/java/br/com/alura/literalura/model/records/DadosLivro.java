package br.com.alura.literalura.model.records;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("id") Long id,
                        @JsonAlias("title") String titulo,
                        @JsonAlias("authors") List<DadosAutor> autores,
                        @JsonAlias("languages") List<String> idiomas,
                        @JsonAlias("download_count") Integer numeroDeDownloads){

}

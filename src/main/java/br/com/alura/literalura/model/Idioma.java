package br.com.alura.literalura.model;

public enum Idioma {
    ENGLISH ("en"),
    SPANHISH("es"),
    FRENCH ("fr"),
    ITALIAN("it"),
    PORTUGUESE("pt");

    private String idioma;

    Idioma (String idioma){
        this.idioma = idioma;
    }

    public String getIdioma(){
        return this.idioma;
    }

    public static Idioma fromString(String text){
        for (Idioma categoria : Idioma.values())
            if (categoria.idioma.equalsIgnoreCase(text)) {
                return categoria;
            }

        throw new IllegalArgumentException("Nenhuma categoria encontrada para: " + text);
    }
}

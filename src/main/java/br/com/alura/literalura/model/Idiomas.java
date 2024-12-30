package br.com.alura.literalura.model;

public enum Idiomas {
    ENGLISH,
    SPANHISH,
    FRENCH,
    ITALIAN,
    PORTUGUESE;

    private String idiomasEnum;

    public Idiomas (String idiomasUsuario){
        this.idiomasEnum = idiomasEnum;
    }

    public static Idiomas fromString(String text){
        for (Idiomas categoria : Idiomas.values())
            if (categoria.idiomasUsuario.equalsIgnoreCase(text)) {
                return categoria;
            }

        throw new IllegalArgumentException("Nenhuma categoria encontrada: "+ text)
    }
}

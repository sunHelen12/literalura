package br.com.alura.literalura.util;

public class ControleUtil {

    public static String limitarCaracteres(String controle, int limitarLimite){
        if(controle.length() <= limitarLimite){
            return controle;
        } else{
            return controle.substring(0, limitarLimite);
        }
    }
}

package br.com.cartao.transacao.utils;

public class OfuscaDadosSensiveis {

    public static String executa(String valor){
        int tamanhoDoValor = valor.length();
        StringBuilder stringBuilder = new StringBuilder();
        return  stringBuilder.append("*****************")
                .append(valor.substring(tamanhoDoValor-4,tamanhoDoValor)).toString();
    }
}

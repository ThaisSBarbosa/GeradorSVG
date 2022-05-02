/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geradorsvg.utils;

import java.util.List;
import com.mycompany.geradorsvg.entidades.RegraProducao;
import java.util.ArrayList;

/**
 *
 * @author thais
 */
public class GramaticaNegocio {

    public static String aplicaRegrasProducao(int numeroExecucoes, List<RegraProducao> regrasProducao) {
        String textoGerado = "";
        for (int i = 0; i < numeroExecucoes; i++) {
            int posPrimeiroA = textoGerado.indexOf("A");
            int posUltimoA;
            if (i == 0) {
                textoGerado = regrasProducao.get(Constantes.REGRA_DE_PROD_INICIO).getTextoGerado();
            } else if (i == numeroExecucoes - 1) {
                textoGerado = textoGerado.substring(0, posPrimeiroA) + regrasProducao.get(Constantes.REGRA_DE_PROD_FINAL).getTextoGerado() + textoGerado.substring(posPrimeiroA + 1);

                posUltimoA = textoGerado.lastIndexOf("A");
                textoGerado = textoGerado.substring(0, posUltimoA) + regrasProducao.get(Constantes.REGRA_DE_PROD_FINAL).getTextoGerado() + textoGerado.substring(posUltimoA + 1);
            } else {
                textoGerado = textoGerado.substring(0, posPrimeiroA) + regrasProducao.get(Constantes.REGRA_DE_PROD_CONSTROI_A_ESQUERDA).getTextoGerado() + textoGerado.substring(posPrimeiroA + 1);

                posUltimoA = textoGerado.lastIndexOf("A");
                textoGerado = textoGerado.substring(0, posUltimoA) + regrasProducao.get(Constantes.REGRA_DE_PROD_CONSTROI_A_DIREITA).getTextoGerado() + textoGerado.substring(posUltimoA + 1);
            }
        }
        return textoGerado;
    }

    public static String retornaInfoAposDoisPontos(String linha) {
        return linha.substring(linha.indexOf(": ") + 2);
    }

    public static String retornaInfoEntreDoisPontosESeta(String linha) {
        return linha.substring(linha.indexOf(": ") + 2, linha.indexOf(" ->"));
    }

    public static String retornaInfoAposSeta(String linha) {
        String retorno = linha.substring(linha.indexOf(" ->") + 4);
        retorno = retorno.replace(Constantes.VAZIO, "");
        return retorno;
    }

    public static List<RegraProducao> retornaRegrasProducao(List<String> linhasArquivo) {
        var regrasProd = new ArrayList<RegraProducao>();
        regrasProd.add(new RegraProducao(linhasArquivo.get(20)));
        regrasProd.add(new RegraProducao(linhasArquivo.get(21)));
        regrasProd.add(new RegraProducao(linhasArquivo.get(22)));
        regrasProd.add(new RegraProducao(linhasArquivo.get(23)));
        return regrasProd;
    }

}

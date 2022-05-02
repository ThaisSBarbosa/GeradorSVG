/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geradorsvg.utils;

import com.mycompany.geradorsvg.entidades.Linha;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thais
 */
public class ConstrutorLinhas {

    public static List<Linha> constroi(String textoGeradoGramatica) {
        
        var caracteresTextoGeradoGramatica = textoGeradoGramatica.toCharArray();            
        int posCentral = caracteresTextoGeradoGramatica.length / 2;      
        
        List<Linha> linhas = new ArrayList<Linha>();
        linhas = constroiLinhaInicial(linhas);
        constroiLinhasVerticaisEsquerda(posCentral, caracteresTextoGeradoGramatica, linhas);
        constroiLinhasHorizontaisEsquerda(posCentral, caracteresTextoGeradoGramatica, linhas);
        constroiLinhasVerticaisDireita(caracteresTextoGeradoGramatica, posCentral, linhas);
        constroiLinhasHorizontaisDireita(caracteresTextoGeradoGramatica, posCentral, linhas);
        return linhas;
    }

    private static List<Linha> constroiLinhaInicial(List<Linha> linhas) {
        int x1 = Constantes.X_INICIAL;
        int x2 = Constantes.X_INICIAL;
        int y1 = Constantes.Y_INICIAL;
        int y2 = Constantes.TAMANHO_LINHA + Constantes.Y_INICIAL;

        var linhaInicial = new Linha(x1, x2, y1, y2);
        linhas.add(linhaInicial);  //sempre inicia com v
        return linhas;
    }

    private static void constroiLinhasVerticaisDireita(char[] caracteresTextoGeradoGramatica, int posCentral, List<Linha> linhas) {
        int x1 = Constantes.X_INICIAL;
        int x2 = Constantes.X_INICIAL;
        int y1 = Constantes.Y_INICIAL;
        int y2 = Constantes.TAMANHO_LINHA;

        for (int i = caracteresTextoGeradoGramatica.length - 1; i > posCentral; i--) {
            if (caracteresTextoGeradoGramatica[i] == 'v') {
                x1 -= Constantes.TAMANHO_LINHA;
                x2 -= Constantes.TAMANHO_LINHA;
                y1 += Constantes.TAMANHO_LINHA;
                y2 += Constantes.TAMANHO_LINHA;
                linhas.add(new Linha(x1, x2, y1, y2));
            }
        }
    }

    private static void constroiLinhasHorizontaisDireita(char[] caracteresTextoGeradoGramatica, int posCentral, List<Linha> linhas) {
        int x1 = Constantes.X_INICIAL - Constantes.TAMANHO_LINHA;
        int x2 = Constantes.X_INICIAL;
        int y1 = Constantes.Y_INICIAL;
        int y2 = Constantes.Y_INICIAL;

        for (int i = caracteresTextoGeradoGramatica.length - 1; i > posCentral; i--) {
            if (caracteresTextoGeradoGramatica[i] == 'h') {
                x1 += Constantes.TAMANHO_LINHA;
                x2 += Constantes.TAMANHO_LINHA;
                y1 += Constantes.TAMANHO_LINHA;
                y2 += Constantes.TAMANHO_LINHA;
                linhas.add(new Linha(x1, x2, y1, y2));
            }
        }
    }

    private static void constroiLinhasVerticaisEsquerda(int posCentral, char[] caracteresTextoGeradoGramatica, List<Linha> linhas) {
        int x1 = Constantes.X_INICIAL;
        int x2 = Constantes.X_INICIAL;
        int y1 = Constantes.Y_INICIAL;
        int y2 = Constantes.TAMANHO_LINHA + Constantes.Y_INICIAL;

        for (int i = 0; i < posCentral; i++) {
            if (caracteresTextoGeradoGramatica[i] == 'v') {
                x1 += Constantes.TAMANHO_LINHA;
                x2 += Constantes.TAMANHO_LINHA;
                y1 += Constantes.TAMANHO_LINHA;
                y2 += Constantes.TAMANHO_LINHA;
                linhas.add(new Linha(x1, x2, y1, y2));
            }
        }
    }

    private static void constroiLinhasHorizontaisEsquerda(int posCentral, char[] caracteresTextoGeradoGramatica, List<Linha> linhas) {
        int x1 = Constantes.X_INICIAL + Constantes.TAMANHO_LINHA;
        int x2 = Constantes.X_INICIAL;
        int y1 = Constantes.Y_INICIAL;
        int y2 = Constantes.Y_INICIAL;

        for (int i = 0; i < posCentral; i++) {
            if (caracteresTextoGeradoGramatica[i] == 'L') {
                x1 -= Constantes.TAMANHO_LINHA;
                x2 -= Constantes.TAMANHO_LINHA;
                y1 += Constantes.TAMANHO_LINHA;
                y2 += Constantes.TAMANHO_LINHA;
                linhas.add(new Linha(x1, x2, y1, y2));
            }
        }
    }
}

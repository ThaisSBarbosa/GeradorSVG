/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geradorsvg.utils;

import com.mycompany.geradorsvg.entidades.Linha;
import java.io.FileOutputStream;
import java.util.List;

/**
 *
 * @author thais
 */
public class ConstrutorArquivoHtml {

    public static void montaSaidaHtml(List<Linha> linhas) throws Exception {
        String conteudoLinesHtml = "";
        for (Linha linha : linhas) {
            conteudoLinesHtml += "\n<line x1=\"" + linha.getX1() + "\" x2=\"" + linha.getX2() + "\" y1=\"" + linha.getY1() + "\" y2=\"" + linha.getY2() + "\"></line>";
        }

        String conteudoSaidaHtml = Constantes.CORPO_HTML;
        int posInicio = conteudoSaidaHtml.indexOf(Constantes.MARCA_INICIO_LINES_HTML);

        conteudoSaidaHtml = conteudoSaidaHtml.substring(0, posInicio) + conteudoLinesHtml + conteudoSaidaHtml.substring(posInicio);

        FileOutputStream fos = new FileOutputStream("saidaGerada.html");
        fos.write(conteudoSaidaHtml.getBytes());
        fos.flush();
        fos.close();
    }
}

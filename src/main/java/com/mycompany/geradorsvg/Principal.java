/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geradorsvg;

import com.mycompany.geradorsvg.entidades.Linha;
import com.mycompany.geradorsvg.utils.ConstrutorArquivoHtml;
import com.mycompany.geradorsvg.utils.ConstrutorLinhas;
import com.mycompany.geradorsvg.utils.InformacoesGramatica;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author thais
 */
public class Principal {

    public static void main(String args[]) throws Exception {

        try {                        
            //Lê a gramática, preenche um objeto com as informações e gera sequência.
            List<String> linhasArquivo = Files.readAllLines(Paths.get("gramatica.txt"));
            InformacoesGramatica informacoesGramatica = new InformacoesGramatica(linhasArquivo);   
            
            //Constrói informações de linhas com o texto gerado pela gramática.
            List<Linha> linhas = ConstrutorLinhas.constroi(informacoesGramatica.getTextoGerado());
            
            //Monta o arquivo html.
            ConstrutorArquivoHtml.montaSaidaHtml(linhas);
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro. Verifique se a gramática enviada está correta.");
            e.printStackTrace();
        }
    }
}

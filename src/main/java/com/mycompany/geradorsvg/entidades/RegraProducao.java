/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geradorsvg.entidades;

import com.mycompany.geradorsvg.utils.GramaticaNegocio;

/**
 *
 * @author thais
 */
public class RegraProducao {
    private String textoOriginal;
    private String textoGerado;

    public RegraProducao(String linha) {
        Preenche(linha);
    }

    private void Preenche(String linha){
        this.setTextoOriginal(GramaticaNegocio.retornaInfoEntreDoisPontosESeta(linha));
        this.setTextoGerado(GramaticaNegocio.retornaInfoAposSeta(linha));
    }
    
    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String getTextoGerado() {
        return textoGerado;
    }

    public void setTextoGerado(String textoGerado) {
        this.textoGerado = textoGerado;
    }
}

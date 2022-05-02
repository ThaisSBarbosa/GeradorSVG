/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geradorsvg.utils;

import com.mycompany.geradorsvg.entidades.RegraProducao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thais
 */
public class InformacoesGramatica {

    private String alfabeto;
    private int numeroExecucoes;
    private String condicaoInicial;
    private String textoGerado;
    private Float angulo;
    private List<RegraProducao> regrasProducao = new ArrayList<RegraProducao>();

    public InformacoesGramatica(List<String> linhasArquivo) {
        Preenche(linhasArquivo);
    }

    private void Preenche(List<String> linhasArquivo) {
        this.setAlfabeto(GramaticaNegocio.retornaInfoAposDoisPontos(linhasArquivo.get(16)));
        this.setNumeroExecucoes(Integer.valueOf(GramaticaNegocio.retornaInfoAposDoisPontos(linhasArquivo.get(17))));
        this.setCondicaoInicial(GramaticaNegocio.retornaInfoAposDoisPontos(linhasArquivo.get(18)));
        this.setAngulo(Float.valueOf(GramaticaNegocio.retornaInfoAposDoisPontos(linhasArquivo.get(19))));        
        this.setRegrasProducao(GramaticaNegocio.retornaRegrasProducao(linhasArquivo));
        this.setTextoGerado();
    }

    public void setTextoGerado() {
        this.textoGerado = GramaticaNegocio.aplicaRegrasProducao(this.numeroExecucoes, this.getRegrasProducao());
    }
    
    public String getTextoGerado(){
        return this.textoGerado;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public int getNumeroExecucoes() {
        return numeroExecucoes;
    }

    public void setNumeroExecucoes(int numeroExecucoes) {
        this.numeroExecucoes = numeroExecucoes;
    }

    public String getCondicaoInicial() {
        return condicaoInicial;
    }

    public void setCondicaoInicial(String condicaoInicial) {
        this.condicaoInicial = condicaoInicial;
    }

    public Float getAngulo() {
        return angulo;
    }

    public void setAngulo(Float angulo) {
        this.angulo = angulo;
    }

    public List<RegraProducao> getRegrasProducao() {
        return regrasProducao;
    }

    public void setRegrasProducao(List<RegraProducao> regrasProducao) {
        this.regrasProducao = regrasProducao;
    }

}

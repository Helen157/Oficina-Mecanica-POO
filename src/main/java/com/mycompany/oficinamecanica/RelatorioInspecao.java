/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author Helen Gonçalves
 */

import java.util.Date;

/**
 * Classe que representa um relatório de inspeção de veículo
 */
public class RelatorioInspecao {
    private Veiculo veiculo;
    private String problema;
    private String recomendacao;
    private Mecanico mecanico;
    private Date data;

    public RelatorioInspecao (Veiculo veiculo, String problema, Mecanico mecanico) {
        this.veiculo = veiculo;
        this.problema = problema;
        this.mecanico = mecanico;
        this.data = new Date();
    }

    // Getters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public String getProblema() {
        return problema;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "veiculo=" + veiculo + ", problema=" + problema + ", recomendacao=" + recomendacao + 
               ", mecanico=" + mecanico + ", data=" + data + '}';
    }
}
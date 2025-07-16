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
import java.util.List;

/**
 * Classe que representa o relatório de vendas da oficina
 */
public class RelatorioVendas {
    private Date dataInicio;
    private Date dataFim;
    private List<OrdemServico> ordensServico;
    private double totalVendas;

    public RelatorioVendas(Date dataInicio, Date dataFim, List<OrdemServico> ordensServico) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ordensServico = ordensServico;
        calcularTotalVendas();
    }

    private void calcularTotalVendas() {
        totalVendas = ordensServico.stream().mapToDouble(OrdemServico::getValorTotal).sum();
    }

    // Getters
    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public List<OrdemServico> getOrdensServico() {
        return ordensServico;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    @Override
    public String toString() {
        return "RelatorioVendas{" + "dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", totalVendas=" + totalVendas + '}';
    }
}

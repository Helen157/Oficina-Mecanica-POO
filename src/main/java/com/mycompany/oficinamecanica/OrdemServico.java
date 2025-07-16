/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author Helen Gonçalves
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma ordem de serviço na oficina
 */
public class OrdemServico {
    private String numero;
    private Agendamento agendamento;
    private Mecanico mecanicoResponsavel;
    private List<Servico> servicos;
    private EnumStatusOrdemServico status;
    private double valorTotal;

    public OrdemServico(String numero, Agendamento agendamento, Mecanico mecanicoResponsavel) {
        this.numero = numero;
        this.agendamento = agendamento;
        this.mecanicoResponsavel = mecanicoResponsavel;
        this.servicos = new ArrayList<>();
        this.status = EnumStatusOrdemServico.ABERTA;
        this.valorTotal = 0.0;
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public Mecanico getMecanicoResponsavel() {
        return mecanicoResponsavel;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public EnumStatusOrdemServico getStatus() {
        return status;
    }

    public void setStatus(EnumStatusOrdemServico status) {
        this.status = status;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    // Métodos de negócio
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
        calcularValorTotal();
    }

    private void calcularValorTotal() {
        valorTotal = servicos.stream().mapToDouble(Servico::calcularCustoTotal).sum();
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "numero=" + numero + ", agendamento=" + agendamento + ", mecanicoResponsavel=" + mecanicoResponsavel + ", servicos=" + servicos + ", status=" + status + ", valorTotal=" + valorTotal + '}';
    }
}
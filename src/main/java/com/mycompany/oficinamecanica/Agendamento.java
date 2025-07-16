/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author Helen Gonçalves
 */
import java.util.Comparator;
import java.util.Date;

/**
 * Classe que representa um agendamento na oficina
 */
public class Agendamento implements Comparator<Agendamento> {
    private String id;
    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataHora;
    private String descricaoProblema;
    private EnumStatusAgendamento status;

    public Agendamento(String id, Cliente cliente, Veiculo veiculo, Date dataHora, String descricaoProblema) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataHora = dataHora;
        this.descricaoProblema = descricaoProblema;
        this.status = EnumStatusAgendamento.AGENDADO;
    }
    
    public double cancelar() {
    this.status = EnumStatusAgendamento.CANCELADO;
    return 0.20; // Valor fixo de retenção
}

    public Agendamento() {
    // Construtor vazio necessário para o funcionamento do GSON
}

    // Getters e Setters para os agendamentos
    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public EnumStatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(EnumStatusAgendamento status) {
        this.status = status;
    }

    // Implementação do Comparator para ordenar por data e hora

    /**
     *
     * @param novo
     * @return
     */
    public int compareTo(Agendamento novo) {
        return this.dataHora.compareTo(novo.getDataHora());
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", cliente=" + cliente + ", veiculo=" + veiculo + ", dataHora=" + dataHora + ", descricaoProblema=" + descricaoProblema + ", status=" + status + '}';
    }

    @Override
    public int compare(Agendamento o1, Agendamento o2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
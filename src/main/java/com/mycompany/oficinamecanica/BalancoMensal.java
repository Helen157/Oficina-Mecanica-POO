/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author Helen Gonçalves
 */

import java.util.List;

/**
 * Classe que representa o balanço mensal da oficina
 */
public class BalancoMensal {
    private int mes;
    private int ano;
    private double totalReceitas;
    private double totalDespesas;
    private double saldo;

    public BalancoMensal(int mes, int ano, List<Servico> servicos, List<Despesa> despesas) {
        this.mes = mes;
        this.ano = ano;
        calcularTotais(servicos, despesas);
    }

    BalancoMensal(List<Servico> servicos, List<Despesa> despesas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void calcularTotais(List<Servico> servicos, List<Despesa> despesas) {
        totalReceitas = servicos.stream().mapToDouble(Servico::calcularCustoTotal).sum();
        totalDespesas = despesas.stream().mapToDouble(Despesa::getValor).sum();
        saldo = totalReceitas - totalDespesas;
    }

    // Getters
    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public double getTotalReceitas() {
        return totalReceitas;
    }

    public double getTotalDespesas() {
        return totalDespesas;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "BalancoMensal{" + "mes=" + mes + ", ano=" + ano + ", totalReceitas=" + totalReceitas + ", totalDespesas=" + totalDespesas + ", saldo=" + saldo + '}';
    }
}

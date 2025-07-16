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
 * Classe que representa um serviço realizado na oficina
 */
public class Servico {
    private String codigo;
    private String nome;
    private String tipo;
    private double preco;
    private int tempoEstimado;
    private List<Peca> pecasUtilizadas;

    public Servico(String codigo, String nome, String tipo, double preco, int tempoEstimado) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.tempoEstimado = tempoEstimado;
        this.pecasUtilizadas = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public List<Peca> getPecasUtilizadas() {
        return pecasUtilizadas;
    }

    public void adicionarPeca(Peca peca) {
        pecasUtilizadas.add(peca);
    }

    public double calcularCustoTotal() {
        double custoPecas = pecasUtilizadas.stream().mapToDouble(Peca::getPreco).sum();
        return preco + custoPecas;
    }

    @Override
    public String toString() {
        return "Servico{" + "codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + ", preco=" + preco + ", tempoEstimado=" + tempoEstimado + ", pecasUtilizadas=" + pecasUtilizadas + '}';
    }
}

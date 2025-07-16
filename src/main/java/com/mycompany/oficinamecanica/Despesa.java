/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

import java.util.Date;

/**
 *
 * @author Helen Gonçalves
 */

/**
 * Classe que representa uma despesa da oficina
 */
public class Despesa {
    private String id;
    private String descricao;
    private double valor;
    private Date data;
    private EnumTipoDespesa tipo;

    public Despesa(String id, String descricao, double valor, Date data, EnumTipoDespesa tipo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public EnumTipoDespesa getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoDespesa tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Despesa{" + "id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", data=" + data + ", tipo=" + tipo + '}';
    }
}

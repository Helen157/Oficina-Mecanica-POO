/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author Helen Gonçalves
 */

/**
 * Classe que representa os elevadores da oficina
 */
public class Elevador {
    private int numero;
    private EnumTipoElevador tipo;
    private EnumStatusElevador status;
    
    // Array estático para os 3 elevadores da oficina
    private static Elevador[] elevadores = new Elevador[3];
    
    static {
        // Inicializa os elevadores no array estático
        elevadores[0] = new Elevador(1, EnumTipoElevador.ALINHAMENTO_BALANCEAMENTO);
        elevadores[1] = new Elevador(2, EnumTipoElevador.CORRENTE);
        elevadores[2] = new Elevador(3, EnumTipoElevador.CORRENTE);
    }

    public Elevador(int numero, EnumTipoElevador tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.status = EnumStatusElevador.DISPONIVEL;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public EnumTipoElevador getTipo() {
        return tipo;
    }

    public EnumStatusElevador getStatus() {
        return status;
    }

    public void setStatus(EnumStatusElevador status) {
        this.status = status;
    }

    // Método estático para acessar os elevadores
    public static Elevador[] getElevadores() {
        return elevadores;
    }

    @Override
    public String toString() {
        return "Elevador{" + "numero=" + numero + ", tipo=" + tipo + ", status=" + status + '}';
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author Helen Gonçalves
 */
import com.mycompany.oficinamecanica.EnumStatusVeículo;
/**
 * Classe que representa um veículo na oficina mecânica
 */
public class Veiculo {
    private String modelo;
    private String placa;
    private int ano;
    private String marca;
    private Cliente cliente; 
    private static int totalVeiculos = 0;
    protected static int totalVeiculosProtected = 0;

    /**
     * Construtor padrão necessário para o GSON.
     */
    public Veiculo() {
        // Construtor vazio para uso do GSON
    }

    /**
     * Construtor de veículo sem cliente (Para testes).
     * @param modelo
     * @param placa
     * @param ano
     * @param marca
     */
    public Veiculo(String modelo, String placa, int ano, String marca) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.marca = marca;
        totalVeiculos++;
        totalVeiculosProtected++;
    }

    /**
     * Construtor de veículo com cliente associado.
     * @param modelo
     * @param placa
     * @param ano
     * @param marca
     * @param cliente
     */
    public Veiculo(String modelo, String placa, int ano, String marca, Cliente cliente) {
        this(modelo, placa, ano, marca);
        this.cliente = cliente;
    }

    // Getters e Setters

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static int getTotalVeiculos() {
        return totalVeiculos;
    }

    public static int getTotalVeiculosProtected() {
        return totalVeiculosProtected;
    }
    
    private EnumStatusVeículo status = EnumStatusVeículo.RECEBIDO;

    public void setStatus(EnumStatusVeículo status) {
    this.status = status;
}

    public EnumStatusVeículo getStatus() {
    return status;
}
    
    @Override
    public String toString() {
        String nomeCliente = (cliente != null) ? cliente.getNome() : "Sem cliente";
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", ano=" + ano +
                ", marca='" + marca + '\'' +
                ", cliente=" + nomeCliente +
                '}';
    }

}
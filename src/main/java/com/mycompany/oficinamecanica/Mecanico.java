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
 * Classe que representa um mecânico especialista na oficina
 */
public class Mecanico extends Funcionario {
    private String especialidade;

    public Mecanico(String nome, String cargo, String identificacao, String usuario, String senha, String especialidade) {
        super(nome, cargo, identificacao, usuario, senha);
        this.especialidade = especialidade;
    }

    // Getter e Setter
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public RelatorioInspecao inspecionarVeiculo(Veiculo veiculo, String problema) {
        // Implementação da inspeção
        return new RelatorioInspecao(veiculo, problema, this);
    }

    public boolean solicitarPecas(Estoque estoque, Peca peca, int quantidade) {
        return estoque.reservarPeca(peca, quantidade);
    }

    @Override
    public String toString() {
        return super.toString() + " Mecanico{" + "especialidade=" + especialidade + '}';
    }
}
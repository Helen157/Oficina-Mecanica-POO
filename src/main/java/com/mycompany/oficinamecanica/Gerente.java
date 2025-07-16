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
 * Classe que representa o gerente da oficina com privilégios administrativos
 */
public class Gerente extends Funcionario {
    public Gerente(String nome, String cargo, String identificacao, String usuario, String senha) {
        super(nome, cargo, identificacao, usuario, senha);
    }

    public boolean registrarDespesa(Despesa despesa) {
        // Implementação do registro de despesa
        return true;
    }

    public BalancoMensal gerarRelatorioMensal(List<Servico> servicos, List<Despesa> despesas) {
        // Implementação do relatório mensal
        return new BalancoMensal(servicos, despesas);
    }

    @Override
    public String toString() {
        return super.toString() + " Gerente{}";
    }
}

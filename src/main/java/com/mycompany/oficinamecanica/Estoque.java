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
 * Classe que gerencia o estoque de peças da oficina
 */
public class Estoque {
    private List<Peca> pecas;

    public Estoque() {
        this.pecas = new ArrayList<>();
    }

    public void adicionarPeca(Peca peca) {
        pecas.add(peca);
    }

    public boolean removerPeca(String codigoPeca, int quantidade) {
        for (Peca p : pecas) {
            if (p.getCodigo().equals(codigoPeca)) {
                if (p.getQuantidadeEstoque() >= quantidade) {
                    p.setQuantidadeEstoque(p.getQuantidadeEstoque() - quantidade);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean reservarPeca(Peca peca, int quantidade) {
        return removerPeca(peca.getCodigo(), quantidade);
    }

    public Peca buscarPeca(String codigo) {
        for (Peca p : pecas) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Peca> listarPecas() {
        return new ArrayList<>(pecas);
    }

    @Override
    public String toString() {
        return "Estoque{" + "pecas=" + pecas + '}';
    }
}
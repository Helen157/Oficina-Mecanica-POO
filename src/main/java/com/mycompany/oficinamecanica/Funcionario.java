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
 * Classe base para funcionários da oficina
 */
public class Funcionario {
    private String nome;
    private String cargo;
    private String identificacao;
    private final Login login;

    public Funcionario(String nome, String cargo, String identificacao, String usuario, String senha) {
        this.nome = nome;
        this.cargo = cargo;
        this.identificacao = identificacao;
        this.login = new Login(usuario, senha);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Login getLogin() {
        return login;
    }

    public boolean realizarServico(Servico servico) {
        // Implementação do serviço
        return true;
    }

    /**
     *
     * @param veiculo
     * @param status
     */
    public void atualizarStatus(Veiculo veiculo, EnumStatusVeículo status) {
        veiculo.setStatus(status);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cargo=" + cargo + ", identificacao=" + identificacao + '}';
    }
}
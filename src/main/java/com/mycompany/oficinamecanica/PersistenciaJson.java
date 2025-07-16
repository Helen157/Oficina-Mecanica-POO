/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author Helen Gonçalves
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;

/**
 * Classe responsável por salvar e carregar dados em JSON
 */
public class PersistenciaJson {

    private static final Gson gson = new Gson();

    // ---------------- CLIENTES ----------------
    public static void salvarClientes(List<Cliente> clientes, String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(clientes, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public static List<Cliente> carregarClientes(String caminho) {
        try (Reader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, new TypeToken<List<Cliente>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // ---------------- FUNCIONÁRIOS ----------------
    public static void salvarFuncionarios(List<Funcionario> funcionarios, String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(funcionarios, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar funcionários: " + e.getMessage());
        }
    }

    public static List<Funcionario> carregarFuncionarios(String caminho) {
        try (Reader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, new TypeToken<List<Funcionario>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Erro ao carregar funcionários: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // ---------------- VEÍCULOS ----------------
    public static void salvarVeiculos(List<Veiculo> veiculos, String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(veiculos, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar veículos: " + e.getMessage());
        }
    }

    public static List<Veiculo> carregarVeiculos(String caminho) {
        try (Reader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, new TypeToken<List<Veiculo>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Erro ao carregar veículos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // ---------------- AGENDAMENTOS ----------------
    public static void salvarAgendamentos(List<Agendamento> agendamentos, String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(agendamentos, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar agendamentos: " + e.getMessage());
        }
    }

    public static List<Agendamento> carregarAgendamentos(String caminho) {
        try (Reader reader = new FileReader(caminho)) {
            return gson.fromJson(reader, new TypeToken<List<Agendamento>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Erro ao carregar agendamentos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

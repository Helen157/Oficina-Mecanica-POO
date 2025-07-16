/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Helen Gonçalves
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mycompany.oficinamecanica.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * Classe controladora principal do sistema da Oficina Mecânica
 */
public class OficinaController {
    private final List<Cliente> clientes;
    private final List<Veiculo> veiculos;
    private final List<Agendamento> agendamentos;
    private final List<OrdemServico> ordensServico;
    private final List<Servico> servicos;
    private final List<Funcionario> funcionarios;
    private final Estoque estoque;
    private final List<Despesa> despesas;

public OficinaController() {
        this.clientes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.agendamentos = new ArrayList<>();
        this.ordensServico = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.estoque = new Estoque();
        this.despesas = new ArrayList<>();
    }

    // Métodos para Clientes
    // Método para adicionar novo cliente ao sistema
    public boolean adicionarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }
    // Método para remover algum cliente do sistema
    public boolean removerCliente(String cpf) {
        return clientes.removeIf(c -> c.getCpf().equals(cpf));
    }
    // Método de busca de clientes no sistema
    public Cliente buscarCliente(String cpf) {
        return clientes.stream().filter(c -> c.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    // Métodos para Veículos
    public boolean adicionarVeiculo(Veiculo veiculo) {
        return veiculos.add(veiculo);
    }
    // Método de busca de veículos no sistema
    public Veiculo buscarVeiculo(String placa) {
        return veiculos.stream().filter(v -> v.getPlaca().equals(placa)).findFirst().orElse(null);
    }

    // Métodos para Agendamentos
    public boolean agendarServico(Cliente cliente, Veiculo veiculo, Date dataHora, String descricaoProblema) {
        String id = "AG-" + System.currentTimeMillis();
        Agendamento agendamento = new Agendamento(id, cliente, veiculo, dataHora, descricaoProblema);
        return agendamentos.add(agendamento);
    }
    // Método para cancelar algum agendamento no sistema
    public boolean cancelarAgendamento(String idAgendamento) {
    for (Agendamento agendamento : agendamentos) {
        if (agendamento.getId().equals(idAgendamento)) {
            agendamento.setStatus(EnumStatusAgendamento.CANCELADO);
            return true;
        }
    }
    return false; // Nenhum agendamento com esse ID foi encontrado
}
    // Método para listar agendamentos no sistema
    public List<Agendamento> listarAgendamentosPorData() {
        List<Agendamento> copia = new ArrayList<>(agendamentos);
        copia.sort(null); // usa a ordem natural (Comparable)
        return copia;
    }

    // Métodos para Ordens de Serviço
    // Método para criar Ordem de Serviço 
    public OrdemServico criarOrdemServico(Agendamento agendamento, Mecanico mecanico) {
        String numero = "OS-" + System.currentTimeMillis();
        OrdemServico os = new OrdemServico(numero, agendamento, mecanico);
        ordensServico.add(os);
        return os;
    }

    // Métodos para Serviços
    // Método para adicionar novo serviço ao sistema
    public boolean adicionarServico(Servico servico) {
        return servicos.add(servico);
    }

    // Métodos para Funcionários
    // Método para adicionar novo funcionário ao sistema
    public boolean adicionarFuncionario(Funcionario funcionario) {
        return funcionarios.add(funcionario);
    }
    // Método de busca de mecânicos especializados no sistema
    public Mecanico buscarMecanicoPorEspecialidade(String especialidade) {
        return (Mecanico) funcionarios.stream()
                .filter(f -> f instanceof Mecanico && ((Mecanico)f).getEspecialidade().equals(especialidade))
                .findFirst().orElse(null);
    }

    // Métodos para Estoque
    // Método para adicionar nova peça ao estoque no sistema
    public boolean adicionarPecaEstoque(Peca peca) {
        estoque.adicionarPeca(peca);
        return true;
    }
    // Método de busca de peças no estoque
    public Peca buscarPecaEstoque(String codigo) {
        return estoque.buscarPeca(codigo);
    }

    // Métodos para Despesas
    // Método para registrar despesas no sistema
    public boolean registrarDespesa(Despesa despesa) {
        return despesas.add(despesa);
    }

    // Métodos para Relatórios
    // Método para gerar relatórios no sistema
    public RelatorioVendas gerarRelatorioVendas(Date dataInicio, Date dataFim) {
        List<OrdemServico> ordensNoPeriodo = new ArrayList<>();
        for (OrdemServico os : ordensServico) {
            // Verificar se a OS está dentro do período (implementação simplificada)
            ordensNoPeriodo.add(os);
        }
        return new RelatorioVendas(dataInicio, dataFim, ordensNoPeriodo);
    }
    // Método para gerar balanço mensal da oficina no sistema
    public BalancoMensal gerarBalancoMensal(int mes, int ano) {
        return new BalancoMensal(mes, ano, servicos, despesas);
    }

    // Métodos estáticos para contagem de veículos 
    public static int getTotalVeiculos() {
        return Veiculo.getTotalVeiculos();
    }

    public static int getTotalVeiculosProtected() {
        return Veiculo.getTotalVeiculosProtected();
    }

    public List<Funcionario> getFuncionarios() {
    return funcionarios;
    }

    public boolean cadastrarCliente(Cliente cliente) {
    return clientes.add(cliente);
}


    public List<Cliente> getClientes() {
    return clientes;
    }
    public List<Agendamento> getAgendamentos() {
    return agendamentos;
    }
    public List<Peca> listarPecasEstoque() {
    return estoque.listarPecas();
}
    
    public String gerarExtrato(Agendamento agendamento) {
    return "Extrato do agendamento: " + agendamento.toString();
}

public String gerarRelatorioMensal(int mes, int ano) {
    BalancoMensal b = gerarBalancoMensal(mes, ano);
    return b.toString();
}

/**
 * Retorna a lista de veículos cadastrados.
     * @return 
 */
public List<Veiculo> getVeiculos() {
    return veiculos;
}

public Agendamento buscarAgendamentoPorId(String id) {
    return agendamentos.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
}

/**
 * Adiciona um agendamento já existente (usado ao carregar do JSON).
     * @param agendamento
 */
public boolean adicionarAgendamento(Agendamento agendamento) {
    return agendamentos.add(agendamento);
}

}

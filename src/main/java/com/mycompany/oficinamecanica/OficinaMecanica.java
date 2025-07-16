/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/*
 * Sistema de Gerenciamento de uma Oficina Mecânica
 * Desenvolvido como parte do trabalho da disciplina Programação Orientada a Objetos
 * Autora: Helen Gonçalves
 */

package com.mycompany.oficinamecanica;

import Controller.AutenticacaoController;
import Controller.OficinaController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class OficinaMecanica {
    
    /**
     * Método principal que inicia a aplicação e demonstra todas as funcionalidades.
     * 
     * @param args Argumentos de linha de comando 
     */
    public static void main(String[] args) {
        // =====================================================================
        // 1. INICIALIZAÇÃO DO SISTEMA (Questão 1 - Encapsulamento)
        // =====================================================================
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SISTEMA DE GESTÃO DA OFICINA INICIADO ===");
        
        // Controladores principais
        OficinaController oficinaController = new OficinaController();
        AutenticacaoController authController = new AutenticacaoController();
        
        // Carregamento dos dados do JSON
        List<Cliente> clientes = PersistenciaJson.carregarClientes("clientes.json");
        clientes.forEach(oficinaController::adicionarCliente);

        List<Funcionario> funcionarios = PersistenciaJson.carregarFuncionarios("funcionarios.json");
        funcionarios.forEach(oficinaController::adicionarFuncionario);

        List<Veiculo> veiculos = PersistenciaJson.carregarVeiculos("veiculos.json");
        veiculos.forEach(oficinaController::adicionarVeiculo);

        List<Agendamento> agendamentos = PersistenciaJson.carregarAgendamentos("agendamentos.json");
        agendamentos.forEach(oficinaController::adicionarAgendamento);
        
        
        
        // =====================================================================
        // 2. CADASTRO INICIAL (Questões 6 e 7 - Funcionários e Clientes)
        // =====================================================================
       // Caso os arquivos JSON estejam vazios ou não existam, adiciona funcionários e clientes iniciais apenas uma vez.
        // =====================================================================
        System.out.println("\n=== CADASTRANDO FUNCIONÁRIOS E CLIENTES ===");
        
        // 2.1 Cadastro de funcionários (Questão 6)
        if (oficinaController.getFuncionarios().isEmpty()) {
    cadastrarFuncionariosIniciais(oficinaController);
}
        
          // 2.2 Cadastro de clientes (Questão 7)
        if (oficinaController.getClientes().isEmpty()) {
    cadastrarClientesIniciais(oficinaController);
}

  // =====================================================================
       // 3. AUTENTICAÇÃO (Questão 2 - Login inicial com entrada do usuário)
     // =====================================================================
    // Solicita que o usuário digite login e senha para acesso ao sistema.
   // Garante que apenas usuários cadastrados possam continuar.
   
      System.out.println("Login necessário para acessar o sistema");
      System.out.print("Usuário: ");
      String usuario = scanner.nextLine();
      System.out.print("Senha: ");
      String senha = scanner.nextLine();

      // Autentica com base na lista de funcionários já carregada do JSON
       Funcionario funcionarioAutenticado = authController.autenticar(usuario, senha, oficinaController.getFuncionarios());

      if (funcionarioAutenticado == null) {
      System.out.println("Falha na autenticação.");
       return;
}
      System.out.println("Login realizado com sucesso. Bem-vindo(a), " + funcionarioAutenticado.getNome());
      
        // =====================================================================
        // MENU DO SISTEMA - CADASTROS E RELATÓRIOS
// =====================================================================
   int opcao;
do {
    System.out.println("\n========= MENU =========");
    System.out.println("1. Cadastrar novo cliente");
    System.out.println("2. Cadastrar novo funcionário");
    System.out.println("3. Listar clientes");
    System.out.println("4. Listar funcionários");
    System.out.println("5. Salvar dados");
    System.out.println("6. Cadastrar novo veículo");
    System.out.println("7. Listar veículos");
    System.out.println("8. Agendar serviço");
    System.out.println("9. Listar agendamentos");
    System.out.println("10. Cancelar agendamento");  
    System.out.println("11. Gerar extrato de serviço");
    System.out.println("12. Gerar relatório mensal");
    System.out.println("0. Sair");
    System.out.print("Escolha uma opção: ");
    opcao = scanner.nextInt();
    scanner.nextLine();

    switch (opcao) {
        case 1 -> {
            scanner.nextLine(); //️ Limpa o \n deixado por nextInt
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            Cliente novo = new Cliente(nome, endereco, telefone, email, cpf);
            oficinaController.adicionarCliente(novo);
            System.out.println("Cliente cadastrado!");
        }
        case 2 -> {
            scanner.nextLine(); //️ Limpa o \n deixado por nextInt
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Usuário: ");
            String usuarioFuncionario = scanner.nextLine();
            System.out.print("Senha: ");
            String senhaNova = scanner.nextLine();
            Funcionario novo = new Funcionario(nome, cargo, id, usuario, senha);
            oficinaController.adicionarFuncionario(novo);
            System.out.println("Funcionário cadastrado!");
        }
        case 3 -> oficinaController.getClientes().forEach(System.out::println);
        case 4 -> oficinaController.getFuncionarios().forEach(System.out::println);
        case 5 -> salvarDados(oficinaController);
        case 6 -> {
           System.out.println("\n--- Cadastro de Veículo ---");
    
           System.out.print("CPF do cliente proprietário: ");
           String cpf = scanner.nextLine();
           Cliente cliente = oficinaController.buscarCliente(cpf);

      if (cliente == null) {
          System.out.println("Cliente não encontrado. Cadastre o cliente primeiro.");
        break;
    }

         System.out.print("Modelo: ");
         String modelo = scanner.nextLine();
    
         System.out.print("Placa: ");
         String placa = scanner.nextLine();
    
         System.out.print("Ano: ");
         int ano = scanner.nextInt();
         scanner.nextLine(); 
    
         System.out.print("Marca: ");
         String marca = scanner.nextLine();

    // Cria veículo com associação ao cliente
    Veiculo veiculo = new Veiculo(modelo, placa, ano, marca, cliente);
    
    oficinaController.adicionarVeiculo(veiculo);
    System.out.println("Veículo cadastrado com sucesso para o cliente " + cliente.getNome() + "!");
}
        case 7 -> listarVeiculos(oficinaController);
        case 8 -> {
           System.out.print("CPF do cliente: ");
           String cpf = scanner.nextLine();
           Cliente cliente = oficinaController.buscarCliente(cpf);
           if (cliente == null) {
           System.out.println("Cliente não encontrado!");
        break;
    }

          System.out.print("Placa do veículo: ");
          String placa = scanner.nextLine();
          Veiculo veiculo = oficinaController.buscarVeiculo(placa);
          if (veiculo == null) {
          System.out.println("Veículo não encontrado!");
        break;
    }

          System.out.print("Data e hora (yyyy-MM-dd HH:mm): ");
          String dataStr = scanner.nextLine();
          LocalDateTime dataHora = LocalDateTime.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

          System.out.print("Descrição do problema: ");
          String descricao = scanner.nextLine();

          oficinaController.agendarServico(cliente, veiculo, java.sql.Timestamp.valueOf(dataHora), descricao);
          System.out.println("Agendamento realizado com sucesso!");
}
        case 9 -> listarAgendamentos(oficinaController);
        case 10 ->  {
          System.out.println("\n--- Cancelar Agendamento ---");
          System.out.print("ID do agendamento: ");
          String id = scanner.nextLine();
          boolean cancelado = oficinaController.cancelarAgendamento(id);
      if (cancelado) {
          System.out.println("Agendamento cancelado com sucesso!");
    } else {
         System.out.println("Agendamento não encontrado.");
    }
}
        case 11 -> {
        System.out.println("\n--- Gerar Extrato de Serviço ---");
        System.out.print("ID do agendamento: ");
        String id = scanner.nextLine();
        Agendamento agendamento = oficinaController.buscarAgendamentoPorId(id);
    if (agendamento != null) {
        String extrato = oficinaController.gerarExtrato(agendamento);
        System.out.println("\n" + extrato);
    } else {
        System.out.println("Agendamento não encontrado.");
    }
}
        case 12 -> gerarRelatorio(scanner, oficinaController);
        case 0 -> System.out.println("Saindo...");
        default -> System.out.println("Opção inválida!");
    }
} while (opcao != 0);

scanner.close();
        
        System.out.println("\n=== SISTEMA FINALIZADO ===");
    }
    
    
    private static void cadastrarVeiculo(Scanner scanner, OficinaController controller) {
    System.out.println("\n--- Cadastro de Veículo ---");
    System.out.print("Modelo: ");
    String modelo = scanner.nextLine();
    System.out.print("Placa: ");
    String placa = scanner.nextLine();
    System.out.print("Marca: ");
    String marca = scanner.nextLine();
    System.out.print("Ano: ");
    int ano = scanner.nextInt();
    scanner.nextLine(); // limpa buffer

    Veiculo veiculo = new Veiculo(modelo, placa, ano, marca);
    controller.adicionarVeiculo(veiculo);
    System.out.println("Veículo cadastrado com sucesso!");
}

private static void listarVeiculos(OficinaController controller) {
    System.out.println("\n--- Lista de Veículos ---");
    controller.getVeiculos().forEach(System.out::println);
}
    /**
     * Cadastra os funcionários iniciais do sistema (Questão 6).
     * 
     * @param controller Controlador da oficina
     */
    private static void cadastrarFuncionariosIniciais(OficinaController controller) {
        // 4.4 Utilizando 'super' em construtores (Requisito 4)
        Gerente gerente = new Gerente("João Silva", "Gerente", "001", "gerente1", "senha123");
        Mecanico mecanico = new Mecanico("Carlos Souza", "Mecânico", "002", "mecanico1", "senha123", "Motor");
        
        controller.adicionarFuncionario(gerente);
        controller.adicionarFuncionario(mecanico);
        
        System.out.println("Funcionários cadastrados: " + controller.getFuncionarios().size());
    }
    
    
    private static void agendarServico(Scanner scanner, OficinaController controller) {
    System.out.println("\n--- Agendar Serviço ---");

    System.out.print("CPF do cliente: ");
    String cpf = scanner.nextLine();
    Cliente cliente = controller.buscarCliente(cpf);
    if (cliente == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }

    System.out.print("Placa do veículo: ");
    String placa = scanner.nextLine();
    Veiculo veiculo = controller.buscarVeiculo(placa);
    if (veiculo == null) {
        System.out.println("Veículo não encontrado.");
        return;
    }

    System.out.print("Data e hora (yyyy-MM-dd HH:mm): ");
    String dataHoraStr = scanner.nextLine();
    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    System.out.print("Descrição do problema: ");
    String descricao = scanner.nextLine();

    controller.agendarServico(cliente, veiculo, java.sql.Timestamp.valueOf(dataHora), descricao);
    System.out.println("Agendamento realizado com sucesso!");
}

private static void listarAgendamentos(OficinaController controller) {
    System.out.println("\n--- Lista de Agendamentos ---");
    controller.getAgendamentos().forEach(System.out::println);
}

private static void cancelarAgendamento(Scanner scanner, OficinaController controller) {
    System.out.println("\n--- Cancelar Agendamento ---");
    System.out.print("ID do agendamento: ");
    String id = scanner.nextLine();
    boolean cancelado = controller.cancelarAgendamento(id);
    if (cancelado) {
        System.out.println("Agendamento cancelado.");
    } else {
        System.out.println("Agendamento não encontrado.");
    }
}
    
    /**
     * Cadastra clientes iniciais (Questão 7).
     */
    private static void cadastrarClientesIniciais(OficinaController controller) {
        Cliente cliente1 = new Cliente("Maria Oliveira", "Rua A, 123", "11999998888", "maria@email.com", "12345678901");
        Cliente cliente2 = new Cliente("Pedro Santos", "Rua B, 456", "11988887777", "pedro@email.com", "98765432109");
        
        controller.cadastrarCliente(cliente1);
        controller.cadastrarCliente(cliente2);
        
        System.out.println("Clientes cadastrados: " + controller.getClientes().size());
    }
    
    /**
     * Demonstra o controle de veículos (Questão 5, 11, 12).
     */
    private static void demonstrarControleVeiculos(OficinaController controller) {
        System.out.println("\n=== CONTROLE DE VEÍCULOS ===");
        
        // 5.1 Cadastro de veículos
        Veiculo veiculo1 = new Veiculo("ABC1D23", "Onix", 2020, "Chevrolet");
        Veiculo veiculo2 = new Veiculo("XYZ9E87", "HB20", 2021, "Hyundai");
        
        // 11. Contagem de instâncias (duas estratégias)
        System.out.println("Total de veículos (privado): " + Veiculo.getTotalVeiculos());
        System.out.println("Total de veículos (protected): " + Veiculo.getTotalVeiculosProtected());
        
        // 12. Método de classe para contagem
        System.out.println("Total via controller: " + OficinaController.getTotalVeiculos());
    }
    
    /**
     * Aqui é demonstrado as operações de agendamento (Questões 5, 13).
     */
    private static void demonstrarAgendamentos(OficinaController controller) {
        System.out.println("\n=== AGENDAMENTOS ===");
        
        // 5.2 Criação de agendamentos
        Cliente cliente = controller.getClientes().get(0);
        Veiculo veiculo = new Veiculo("DEF2G34", "Gol", 2019, "Volkswagen");
        
       // 13. Uso de Comparator para ordenação
        Comparator<Agendamento> comparator = Comparator.comparing(Agendamento::getDataHora);

       // Cria um agendamento
        Date dataAgendamento = java.sql.Timestamp.valueOf(LocalDateTime.now().plusDays(2));
        controller.agendarServico(cliente, veiculo, dataAgendamento, "Troca de óleo");

      // Recupera o primeiro agendamento da lista
        Agendamento agendamento = controller.getAgendamentos().get(0);

     // Cancela
        double valorRetido = agendamento.cancelar();
        System.out.println("Agendamento cancelado. Valor retido: R$" + valorRetido);
    
    /**
     * Demonstra gestão de estoque (Questão 9).
     */
    }
       private static void demonstrarGestaoEstoque(OficinaController controller) {
           System.out.println("\n=== GESTÃO DE ESTOQUE ===");
        
        // Cadastro de peças
        Peca peca1 = new Peca("P001", "Filtro de óleo", "Filtro para motor 1.0", 25.90, 10);
        Peca peca2 = new Peca("P002", "Pastilha de freio", "Freio dianteiro", 89.90, 5);
        
        controller.adicionarPecaEstoque(peca1);
        controller.adicionarPecaEstoque(peca2);
        
        System.out.println("Peças em estoque: " + controller.listarPecasEstoque().size());
    }

    /**
     * Demonstra a geração de relatórios (Questões 10, 14).
     */
    private static void demonstrarRelatorios(OficinaController controller) {
        System.out.println("\n=== RELATÓRIOS ===");
        
        // 10. Extrato de serviço
        System.out.println("=== EXTRATO de Serviço ===");
        String extrato = controller.gerarExtrato(controller.getAgendamentos().get(0));
        System.out.println(extrato);
        
        // 14. Relatório mensal
        System.out.println("\n=== RELATÓRIO MENSAL ===");
        String relatorio = controller.gerarRelatorioMensal(
            LocalDate.now().getMonthValue(), 
            LocalDate.now().getYear()
        );
        System.out.println(relatorio);
    }  
    
    private static void gerarExtrato(Scanner scanner, OficinaController controller) {
    System.out.println("\n--- Gerar Extrato ---");
    System.out.print("ID do agendamento: ");
    String id = scanner.nextLine();
    Agendamento agendamento = controller.buscarAgendamentoPorId(id);
    if (agendamento != null) {
        System.out.println("Extrato: " + agendamento);
    } else {
        System.out.println("Agendamento não encontrado.");
    }
}

private static void gerarRelatorio(Scanner scanner, OficinaController controller) {
    System.out.println("\n--- Gerar Relatório Mensal ---");
    System.out.print("Mês (número): ");
    int mes = scanner.nextInt();
    System.out.print("Ano: ");
    int ano = scanner.nextInt();
    scanner.nextLine();

    System.out.println(controller.gerarRelatorioMensal(mes, ano));
}

    /**
 * Salva os dados da oficina em arquivos JSON.
 */
private static void salvarDados(OficinaController controller) {
    PersistenciaJson.salvarClientes(controller.getClientes(), "clientes.json");
    PersistenciaJson.salvarFuncionarios(controller.getFuncionarios(), "funcionarios.json");
    PersistenciaJson.salvarVeiculos(controller.getVeiculos(), "veiculos.json");
    PersistenciaJson.salvarAgendamentos(controller.getAgendamentos(), "agendamentos.json");
    PersistenciaJson.salvarVeiculos(controller.getVeiculos(), "veiculos.json");
    PersistenciaJson.salvarAgendamentos(controller.getAgendamentos(), "agendamentos.json");
    System.out.println("Dados salvos com sucesso!");
}

}
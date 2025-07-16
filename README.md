# 🔧 Sistema de Gestão de Oficina Mecânica  
Projeto da disciplina de **Programação Orientada a Objetos (POO)** – UFVJM  
Autora: Helen Gonçalves

---

## 📌 Descrição Geral

Este projeto simula um sistema completo de gestão para uma oficina mecânica. Ele foi desenvolvido com base no roteiro de atividades da disciplina, com foco nos principais conceitos de **POO**, como encapsulamento, herança, polimorfismo, composição, uso de `enum`, collections, `static`, persistência com JSON e organização modular em pacotes.

O sistema foi implementado em **Java** e roda totalmente via terminal (modo texto), utilizando a biblioteca **Gson** para salvar e recuperar dados em arquivos `.json`.

---

## 🎯 Funcionalidades Implementadas

| Funcionalidade                                         | Status     | Observações                                                                 |
|--------------------------------------------------------|------------|------------------------------------------------------------------------------|
| Encapsulamento e organização modular                   | ✅ Concluído | Classes organizadas em pacotes (`Controller`, `Model`, etc.)                |
| Cadastro e listagem de clientes e funcionários         | ✅ Concluído | Inclui CPF, nome, contato, cargo, login e senha                             |
| Cadastro de veículos vinculados a clientes             | ✅ Concluído | Com contadores `static` e uso de `protected` e `private`                    |
| Sistema de autenticação com login/senha                | ✅ Concluído | Classe `Login` e `AutenticacaoController`                                   |
| Agendamento de serviços                                | ✅ Concluído | Cliente + veículo + data/hora + descrição do problema                       |
| Cancelamento e extrato de agendamento                  | ✅ Concluído | Com retenção simulada (20%) e status controlado via `enum`                  |
| Persistência com JSON usando Gson                      | ✅ Concluído | Clientes, veículos, agendamentos e funcionários                             |
| Uso de `enum` para status e tipos                      | ✅ Concluído | Veículo, Agendamento, Ordem de Serviço, Elevador, Despesa                   |
| Polimorfismo (Funcionario, Gerente, Mecanico)          | ✅ Concluído | Subclasses com métodos específicos                                          |
| Herança e uso de `super`                               | ✅ Concluído | Construtores das subclasses herdam de `Funcionario`                         |
| Contador com `static` e métodos de classe              | ✅ Concluído | Duas estratégias diferentes (com `private` e `protected`)                   |
| Vetor `static` de elevadores                           | ✅ Concluído | Inicialização fixa de 3 elevadores com tipos diferentes                     |
| Estoque de peças                                       | ✅ Concluído | Peças cadastradas, reservadas e associadas a serviços                       |
| Geração de relatórios mensais                          | ✅ Concluído | Com receita, despesa e saldo                                                |
| Impressão de dados (`toString()`)                      | ✅ Concluído | Todas as classes principais implementam                                     |

---

## 🛠️ Funcionalidades em Desenvolvimento

| Funcionalidade                                         | Status        | Observações                                                                 |
|--------------------------------------------------------|---------------|------------------------------------------------------------------------------|
| Controle de acesso por tipo de funcionário             | ⚠️ Parcial     | Autenticação feita, mas ainda sem restrição de acesso por perfil (Gerente/Mecânico) |
| Ordens de serviço                                      | ⚠️ Parcial     | Classe implementada, mas não integrada no menu interativo                   |
| Relatório de inspeção (Mecânico)                       | ⚠️ Parcial     | Classe implementada, falta integração no fluxo                              |
| Relatório de vendas por período                        | ⚠️ Parcial     | Classe pronta, mas não acessível no menu                                    |
| Alocação/uso dos elevadores                            | ⚠️ Parcial     | Array `static` criado, falta integrar ao agendamento/execução               |

---

## ❌ Funcionalidades a Serem Implementadas

| Funcionalidade                                         | Status        | Observações                                                                 |
|--------------------------------------------------------|---------------|------------------------------------------------------------------------------|
| Exclusão de clientes e funcionários                    | ❌ Não feito   | Métodos ainda não integrados ao menu                                        |
| Alteração de dados de clientes/funcionários            | ❌ Não feito   | Sem interface de edição no menu                                             |
| Cadastro de despesas                                   | ❌ Não feito   | Classe implementada (`Despesa`), falta opção no menu                        |
| Recebimento de fornecedor (reposição de estoque)       | ❌ Não feito   | Estoque permite inserção, mas sem simulação de entrada por fornecedor       |
| Relatórios diários de serviços                         | ❌ Não feito   | Apenas relatório mensal implementado                                        |
| Interface gráfica (GUI)                                | ❌ Não feito   | Sistema funciona apenas via terminal                                        |
| Geração de JavaDoc                                     | ❌ Não feito   | Comentários JavaDoc em algumas classes, mas documentação completa pendente  |

---

## 🔎 Tecnologias e Recursos Utilizados

- Linguagem: **Java 17**
- IDE: **NetBeans**
- Biblioteca: [**Gson**](https://github.com/google/gson) (serialização JSON)
- Paradigma: **Programação Orientada a Objetos**
- Conceitos: `encapsulamento`, `herança`, `polimorfismo`, `enum`, `static`, `collections`

---

## 🧪 Como Executar

> Este projeto roda no terminal, dentro da IDE NetBeans ou qualquer outro ambiente Java que suporte arquivos `.json`.

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/oficina-mecanica.git
```

2. Abra na IDE de sua preferência e execute a classe:
```
OficinaMecanica.java
```

3. Interaja pelo menu e teste as opções de cadastro, agendamento e relatórios.


---

## 📝 Licença

Uso educacional. Projeto com fins de aprendizado e avaliação na graduação.
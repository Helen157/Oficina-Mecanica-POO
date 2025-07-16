/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Helen Gonçalves
 */

import com.mycompany.oficinamecanica.Funcionario;
import java.util.List;

/**
 * Classe controladora para autenticação de usuários da oficina
 */
public class AutenticacaoController {
    public Funcionario autenticar(String usuario, String senha, List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            if (f.getLogin().autenticar(usuario, senha)) {
                return f;
            }
        }
        return null;
    }

    public boolean alterarSenha(Funcionario funcionario, String senhaAtual, String novaSenha) {
        if (funcionario.getLogin().getSenha().equals(senhaAtual)) {
            funcionario.getLogin().setSenha(novaSenha);
            return true;
        }
        return false;
    }
}

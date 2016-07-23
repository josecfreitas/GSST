package br.com.gsst.controller;

import br.com.gsst.dao.UsuarioDAO;
import br.com.gsst.model.Usuario;
import br.com.gsst.outros.Mensagem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
    Autor: José Carlos de Freitas
    Data: 11/07/2016, 12:12:38
    Arquivo: LoginController
*/

@Controller
public class LoginController {
    
    @RequestMapping(value = {"entrar", ""})
    public String login(){
        return "login";
    }
    
    @RequestMapping("login")
    public String login(@Valid Usuario usuario, BindingResult result, HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        
        if (result.hasFieldErrors("funcionario") || result.hasFieldErrors("senha")) { //VALIDAÇÃO DOS INPUTS NO LOGIN
            //Seta o email da última tentativa
            redirectAttributes.addFlashAttribute("email", usuario.getFuncionario().getEmail());
            //Seta erros para redirect
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.usuario", result);

            return "redirect:/";
        }

        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.getUsuarioByEmail(usuario);

        if (user != null) { //VERIFICA SE ENCONTROU USUÁRIO
            if (!user.isAtivo()) { //VERIFICA SE O USUÁRIO ESTÁ AUTORIZADO PELO ADMIN
                //Seta o erro de login
                redirectAttributes.addFlashAttribute("mensagem", new Mensagem(true, "danger", "Erro no login!", "Seu usuário está desativado. Contate um administrador."));
                //Seta o email da ultima tentativa
                redirectAttributes.addFlashAttribute("email", usuario.getFuncionario().getEmail());
                //Redireciona para a página anterior
                return "redirect:/";
            } else { //LOGA O USUÁRIO
                //Remove caso haja na sessao
                session.removeAttribute("usuarioLogado");
                //Seta a sessao do usuário
                session.setAttribute("usuarioLogado", user);
                //Redireciona para a página inicial
                return "redirect:/user/";
            }
        } else { //ERRO! LOGIN COM DADOS INCORRETOS
            //Seta o erro de login
            redirectAttributes.addFlashAttribute("mensagem", new Mensagem(true, "danger", "Erro no login!", "Usuário ou senha incorretos."));
            //Seta o email da ultima tentativa
            redirectAttributes.addFlashAttribute("email", usuario.getFuncionario().getEmail());
            //Redireciona para a página anterior
            return "redirect:/";
        }
    }

    @RequestMapping("logoff")
    public String logout(HttpSession session, HttpServletRequest request
    ) {
        //Deleta a sessão
        session.invalidate();
        //Redireciona para a página anterior
        return "redirect:/";
    }
}

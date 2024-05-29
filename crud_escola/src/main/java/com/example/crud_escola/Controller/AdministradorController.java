package com.example.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.crud_escola.Model.Admnistrador;
import com.example.crud_escola.Repository.AdministradorRepository;
import com.example.crud_escola.Repository.VerificaCadastroAdmRepository;

import org.springframework.ui.Model;

/**
 * AdministradorController
 */

@Controller
public class AdministradorController {

    @Autowired
    AdministradorRepository ar;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    @PostMapping("cadastrar-adm")
    public String CadastrarAdmBD(Admnistrador adm, Model model) {
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        if (verificaCpf) {
            ar.save(adm);
            String mensagem = "Cadastro realizado com sucesso";
            model.addAttribute("mensagem", mensagem);
        } else {
            String mensagemErro = "Cadastro não realizado ";
            model.addAttribute("mensagem", mensagemErro); 
        }

        return "/login/login-adm";
    }
}
@PostMapping("cadastrar-adm")
public String cadastrarAdmBD(Admnistrador adm) {
    boolean verificaCpf = vcar.existsById(adm.getCpf());
    if (verificaCpf) {
        ar.save(adm);
        System.out.println("Cadastro Realizado com Sucesso");
    } else {
        System.out.println("Falha ao Cadastrar");

    }
    return "/login/login-adm";
}
}
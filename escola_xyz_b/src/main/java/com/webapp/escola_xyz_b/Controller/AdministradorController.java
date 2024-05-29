package com.webapp.escola_xyz_b.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.escola_xyz_b.Model.Administrador;
import com.webapp.escola_xyz_b.Model.Professores;
import com.webapp.escola_xyz_b.Repository.AdministradorRepository;
import com.webapp.escola_xyz_b.Repository.ProfessoresRepository;
import com.webapp.escola_xyz_b.Repository.VerificaCadastroAdmRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministradorController {

    @Autowired
    ProfessoresRepository pf;

    @Autowired
    AdministradorRepository ar;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    boolean acessoAdm = false;

    @PostMapping("cadastrar-adm")
    public String cadastrarAdmBD(Administrador adm) {
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        if (verificaCpf) {
            ar.save(adm);
            System.out.println("Cadastro Realizado com Sucesso");
        } else {
            System.out.println("Falha ao Cadastrar");

        }
        return "/login/login-adm";
    }

    @GetMapping("/interna-adm")
    public String acessoPageInternaAdm() {
        String vaiPara = "";
        if (acessoAdm) {
            vaiPara = "interna/interna-adm";
        } else {
            vaiPara = "login/login-adm";
        }
        return vaiPara;
    }

    @PostMapping("acesso-adm")
    public String acessoAdm(@RequestParam String cpf, @RequestParam String senha) {
        boolean verificaCpf = ar.existsById(cpf);
        boolean verificaSenha = ar.findByCpf(cpf).getSenha().equals(senha);
        try {
            String url = "";
            if (verificaCpf && verificaSenha) {
                acessoAdm = true;
                url = "redirect:/interna-adm";
            } else {
                url = "redirect:/login-adm";
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-adm";
        }

    }

    @PostMapping("/cadastrar-prof")
    public String cadastrarProfBD(Professores prof) {
        Professores professorexiste = pf.findByCpf(prof.getCpf());
        if (professorexiste != null) {
            System.out.println("Falha ao Cadastrar");
        } else {
            pf.save(prof);
            System.out.println("Cadastro Realizado com Sucesso");
        }
        return "/index";
    } 

    @GetMapping("/lista-prof")
    public String acessoPagelistaProf() {
        return "listas/lista-prof";
    }

}

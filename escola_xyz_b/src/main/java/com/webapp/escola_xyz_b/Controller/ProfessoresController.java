package com.webapp.escola_xyz_b.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.escola_xyz_b.Model.Professores;
import com.webapp.escola_xyz_b.Repository.ProfessoresRepository;
import com.webapp.escola_xyz_b.Repository.VerificaCadastroProfRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfessoresController {

    @Autowired
    ProfessoresRepository pf;

    @Autowired
    VerificaCadastroProfRepository vcpf;

    boolean acessoProf = false;

    @PostMapping("cadastrar-prof")
    public String cadastrarProfBD(Professores prof) {
        boolean verificaCpf = vcpf.existsById(prof.getCpf());
        if (verificaCpf) {
            pf.save(prof);
            System.out.println("Cadastro Realizado com Sucesso");
        } else {
            System.out.println("Falha ao Cadastrar");

        }
        return "/login/login-prof";
    }

    @GetMapping("/interna-prof")
    public String acessoPageInternaProf() {
        String vaiPara = "";
        if (acessoProf) {
            vaiPara = "interna/interna-prof";
        } else {
            vaiPara = "login/login-prof";
        }
        return vaiPara;
    } 

    @GetMapping("/perfil-prof")
    public String acessoPageperfilProf() {
        String vaiPara = "";
        if (acessoProf) {
            vaiPara = "perfil/perfil-prof";
        } else {
            vaiPara = "login/login-prof";
        }
        return vaiPara;
    }

    @PostMapping("acesso-prof")
    public String acessoProf(@RequestParam String cpf, @RequestParam String senha) {
        boolean verificaCpf = pf.existsById(cpf);
        boolean verificaSenha = pf.findByCpf(cpf).getSenha().equals(senha);
        try {
            String url = "";
            if (verificaCpf && verificaSenha) {
                acessoProf = true;
                url = "redirect:/interna-prof";
            } else {
                url = "redirect:/login-prof";
            }
            return url;
        } catch (Exception e) {
            return "redirect:/login-prof";
        }

    } 



}

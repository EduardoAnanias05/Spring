package com.webapp.escola_xyz_b.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.escola_xyz_b.Model.Professores; 
import com.webapp.escola_xyz_b.Repository.ProfessoresRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam; 

@Controller
public class ProfessoresController {

    @Autowired 
    ProfessoresRepository pf;

    boolean acessoProf = false;



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
    public String acessoProf(@RequestParam Long cpf, @RequestParam String senha) {
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

        @RequestMapping(value = "/professores", method = RequestMethod.GET)
    public String abrirprofessores() {
        return "professores/professores";
    }

    @RequestMapping(value = "/professore", method = RequestMethod.POST)
    public String gravarprofessores(Professores professores) {
        pf.save(professores);
        return "redirect:/professores";
    }


   


}




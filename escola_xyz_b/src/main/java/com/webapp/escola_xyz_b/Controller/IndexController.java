package com.webapp.escola_xyz_b.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class IndexController {

    
    @GetMapping("/home")
    public String acessoHomePage() {
        return "index";
    }

    @GetMapping("/login-adm")
    public String acessoPageLoginAdm() {
        return "login/login-adm";
    }

    @GetMapping("/cadastro-adm")
    public String acessoPageCadastroAdm() {
        return "cadastro/cadastro-adm";
    } 

    @GetMapping("/login-prof")
    public String acessoPageLoginprof() {
        return "login/login-prof";
    }

    @GetMapping("/cadastro-prof")
    public String acessoPageCadastroProf() {
        return "cadastro/cadastro-prof";
    }
    


    @GetMapping("/login-alu")
    public String acessoPageLoginAlu() {
        return "login/login-alu";
    }

    @GetMapping("/cadastro-alu")
    public String acessoPageCadastroAlu() {
        return "cadastro/cadastro-alu";
    }
    

    
    

}

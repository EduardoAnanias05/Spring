package com.example.crud_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



// sinalizando o elemento que será usado 
@Controller  
public class IndexController { 
    // configuração de rota 
    // toda vez que tiver uma solicitação home voltara paga o index 
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


}

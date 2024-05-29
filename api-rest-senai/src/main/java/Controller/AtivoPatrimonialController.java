package Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Model.AtivoPatrimonial;
import Repository.AtivoPatrimonialRepository;


@RestController
@RequestMapping("/ativos")
public class AtivoPatrimonialController {
    
    @Autowired
    private AtivoPatrimonialRepository repository;

    @GetMapping
    public List<AtivoPatrimonial> getAllAtivos() {
        return (List<AtivoPatrimonial>) repository.findAll();
    }

    @PostMapping
    public AtivoPatrimonial createAtivo(@RequestBody AtivoPatrimonial ativo) {
        return repository.save(ativo);
    }
    
    
}

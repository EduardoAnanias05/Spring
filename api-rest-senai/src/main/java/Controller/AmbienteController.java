package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Ambiente;
import Repository.AmbienteRepository;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController {
    
     @Autowired
    private AmbienteRepository repository;

    @GetMapping
    public List<Ambiente> getAllAmbientes() {
        return (List<Ambiente>) repository.findAll();
    }

    @PostMapping
    public Ambiente createAmbiente(@RequestBody Ambiente ambiente) {
        return repository.save(ambiente);
    }
}


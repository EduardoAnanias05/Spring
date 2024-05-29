package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Responsavel;
import Repository.ResponsavelRepository;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {
  
    @Autowired
    private ResponsavelRepository repository;

    @GetMapping
    public List<Responsavel> getAllResponsaveis() {
        return (List<Responsavel>) repository.findAll();
    }

    @PostMapping
    public Responsavel createResponsavel(@RequestBody Responsavel responsavel) {
        return repository.save(responsavel);
    }


    @GetMapping("/{id}")
    public Optional<Responsavel> getResponsavelById(@PathVariable Long id) {
        return repository.findById(id);  
    }

}

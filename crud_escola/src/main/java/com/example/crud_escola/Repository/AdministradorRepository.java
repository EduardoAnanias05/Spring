package com.example.crud_escola.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_escola.Model.Admnistrador;



public interface AdministradorRepository extends CrudRepository<Admnistrador, String>  {
    

       Admnistrador findByCpf(String cpf);
    // se eu precisar criar algum metodo extra eu crio aqui  

    }
    
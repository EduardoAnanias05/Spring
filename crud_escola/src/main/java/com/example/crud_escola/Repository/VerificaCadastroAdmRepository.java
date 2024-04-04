package com.example.crud_escola.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crud_escola.Model.VerificaCadastroAdm;


/**
 * VerificaCadastroAdmRepository
 */

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm, String>  {

VerificaCadastroAdmRepository findByCpf(String cpf); 
}
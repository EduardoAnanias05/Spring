package com.example.crud_escola.Repository;


import org.springframework.data.repository.CrudRepository;


/**
 * VerificaCadastroAdmRepository
 */
public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdmRepository, String>  {

VerificaCadastroAdmRepository findByCpf(String cpf); 
}
package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.VerificaCadastroProf;


public interface VerificaCadastroProfRepository extends CrudRepository<VerificaCadastroProf,String>{
    VerificaCadastroProf findByCpf(String cpf);
}
    

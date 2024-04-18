package com.webapp.escola_xyz_b.Repository;


import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Professores;


public interface ProfessoresRepository extends CrudRepository<Professores, String> {
    //se eu precisar criar algum método extra eu vou criar aqui
    
    Professores findByCpf(String cpf);
}

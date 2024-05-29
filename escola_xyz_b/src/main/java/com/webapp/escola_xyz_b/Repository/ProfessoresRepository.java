package com.webapp.escola_xyz_b.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Professores;

public interface ProfessoresRepository extends CrudRepository<Professores, Long> {
    // se eu precisar criar algum método extra eu vou criar aqui

    // criado para a busca Funcionario por nome
    Professores findByNome(String nome);

    // criado para a busca Professores por id ou chave primária
    Professores findByCpf(long cpf);

    // listar professores por nome
    @Query(value = "select u from Professores u where u.nome like %?1%")
    List<Professores> findByNomes(String nome);
}

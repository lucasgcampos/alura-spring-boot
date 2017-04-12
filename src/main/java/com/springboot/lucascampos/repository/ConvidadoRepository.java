package com.springboot.lucascampos.repository;


import com.springboot.lucascampos.model.Convidado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}

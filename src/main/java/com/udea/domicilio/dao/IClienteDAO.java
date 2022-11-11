package com.udea.domicilio.dao;

import com.udea.domicilio.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDAO extends CrudRepository<Cliente, Long> {
    
}
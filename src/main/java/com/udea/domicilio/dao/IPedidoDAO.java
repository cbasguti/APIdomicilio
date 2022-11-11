package com.udea.domicilio.dao;

import com.udea.domicilio.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoDAO extends CrudRepository<Pedido, Long>{
    
}
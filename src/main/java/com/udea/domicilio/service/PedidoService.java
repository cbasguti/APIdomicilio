package com.udea.domicilio.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.domicilio.dao.IPedidoDAO;
import com.udea.domicilio.model.Pedido;

@Service
public class PedidoService {
    @Autowired

    private IPedidoDAO dao;
    
    public Pedido save(Pedido p) {return dao.save(p);}
    public Iterable<Pedido> list() {return dao.findAll();}
    public Optional<Pedido> listId(Long id){return dao.findById(id);}
}
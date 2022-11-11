package com.udea.domicilio.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udea.domicilio.dao.IClienteDAO;
import com.udea.domicilio.model.Cliente;

@Service
public class ClienteService {
    @Autowired

    private IClienteDAO dao;
    
    public Cliente save(Cliente c) {return dao.save(c);}
    public Iterable<Cliente> list() {return dao.findAll();}
    public Optional<Cliente> listId(long id){return dao.findById(id);}
}

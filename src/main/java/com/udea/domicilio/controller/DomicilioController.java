package com.udea.domicilio.controller;

import com.udea.domicilio.exception.ModelNotFoundException;
import com.udea.domicilio.model.Cliente;
import com.udea.domicilio.model.Pedido;
import com.udea.domicilio.service.ClienteService;
import com.udea.domicilio.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1/domicilio")
@CrossOrigin("*")
@Api(value = "Sistema de gestión de pedidos", description = "Operations corresponding to order and customer data queries for a delivery platform.")
public class DomicilioController {
    @Autowired
    ClienteService clienteService;
    PedidoService pedidoService;

    @ApiOperation(value = "Añadir un cliente")
    @PostMapping("/save/cliente")
    public long save(
            @ApiParam(value = "Almacenamiento del objeto cliente en la tabla de la base de datos", required = true) @RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return cliente.getIdCliente();
    }

    @ApiOperation(value = "Añadir un pedido")
    @PostMapping("/save/pedido")
    public long save(
            @ApiParam(value = "Almacenamiento del objeto pedido en la tabla de la base de datos", required = true) @RequestBody Pedido pedido) {
        Long idCliente = pedido.getIdCliente();
        Optional<Cliente> cliente = clienteService.listId(idCliente);
        if (cliente.isPresent()) {
            pedidoService.save(pedido);
            return pedido.getIdPedido();
        } 
        throw new ModelNotFoundException("Cliente no existe");
    }

    @ApiOperation(value = "Consultar un pedido por ID")
    @GetMapping("/list/pedido/{id}")
    public Pedido listPedidoById(
            @ApiParam(value = "Id. del pedido del que se recuperará el objeto pedido", required = true) @PathVariable("id") Long id) {
        Optional<Pedido> pedido = pedidoService.listId(id);
        if (pedido.isPresent()) {
            return pedido.get();
        }
        throw new ModelNotFoundException("ID de pedido invalido");
    }
}

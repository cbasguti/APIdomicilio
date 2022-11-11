package com.udea.domicilio.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "Detalles del pedido.")
@Entity


public class Pedido implements Serializable{
    @ApiModelProperty(notes = "La base de datos genera el id del Pedido")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idpedido")
    private Long idPedido;

    @ApiModelProperty(notes = "Descripcion del pedido")
    @Column(name = "descripcion", nullable = false, length = 160)
    private @NonNull String descripcion;
    
    @ApiModelProperty(notes = "Precio del pedido")
    @Column(name = "precio", nullable = false, length = 80)
    private @NonNull Double precio;

    @ApiModelProperty(notes = "Cliente que realiza el pedido")
    @Column(name = "cliente", nullable = false)
    private @NonNull Long idCliente;
    
}   

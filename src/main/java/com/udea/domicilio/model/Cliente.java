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
@ApiModel(description = "Detalles del cliente.")
@Entity

public class Cliente implements Serializable{
    
    @ApiModelProperty(notes = "Se genera el Id del cliente por la base de datos")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcliente")
    private Long idCliente;     

    @ApiModelProperty(notes = "Nombre del cliente")
    @Column(name = "nombre", nullable = false, length = 160)
    private @NonNull String nombre;

    
    @ApiModelProperty(notes = "Direccion del cliente")
    @Column(name = "direccion", nullable = false, length = 100)
    private @NonNull String direccion;
}

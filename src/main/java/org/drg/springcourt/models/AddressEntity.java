package org.drg.springcourt.models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity (name = "address")
@Data
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Floor is mandatory")
    private String floor;

    @NotBlank(message = "Door is mandatory")
    private String door;

    @ManyToOne
    private UserEntity user;

}

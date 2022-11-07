package org.drg.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "QUIERES PONER EL MAIL HOSTIA")
    private String mail;

    public UserEntity(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

/*    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @NotBlank(message = "Alias is mandatory")
    private Object alias;

    @NotBlank(message = "Address is mandatory")
    private Object address;

    @NotBlank(message = "Floor is mandatory")
    private Object floor;

    @NotBlank(message = "Door is mandatory")
    private Object door;
*/
}

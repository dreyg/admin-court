package org.drg.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-02T19:44:59.902Z[GMT]")


public class UserResponseDto {

    private Long id;
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("alias")
    private Object alias;

    @JsonProperty("address")
    private Object address;

    @JsonProperty("floor")
    private Object floor;

    @JsonProperty("door")
    private Object door;

    public UserResponseDto username(String username) {
        this.username = username;
        return this;
    }


}

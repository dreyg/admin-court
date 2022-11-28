package org.drg.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
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

}

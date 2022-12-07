package org.drg.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto implements Comparable<UserResponseDto>{

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("username")
    private String username;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("password")
    private String password;

    @JsonProperty("address")
    private String address;

    @JsonProperty("floor")
    private String floor;

    @JsonProperty("door")
    private String door;

    @Override
    public int compareTo(UserResponseDto obj)
    {
        return this.name.compareTo(obj.name);
    }


}

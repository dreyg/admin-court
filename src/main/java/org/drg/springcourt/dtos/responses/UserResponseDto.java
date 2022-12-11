package org.drg.springcourt.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@ToString
public class UserResponseDto{

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

    /*@JsonProperty("address")
    private List<AddressResponseDto> address;*/

   /* @Override
    public int compareTo(UserResponseDto obj)
    {
        return this.name.compareTo(obj.name);
    }*/

    public UserResponseDto(Long id, String name, String surname, String username, String mail, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public UserResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
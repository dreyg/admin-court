package org.drg.springcourt.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRequestDto {

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
    private List<AddressRequestDto> addressList;

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

    public List<AddressRequestDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressRequestDto> addressList) {
        this.addressList = addressList;
    }
}

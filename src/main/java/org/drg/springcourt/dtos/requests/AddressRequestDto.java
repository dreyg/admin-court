package org.drg.springcourt.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-02T19:44:59.902Z[GMT]")

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressRequestDto {

    @JsonProperty("address")
    private String address;

    @JsonProperty("floor")
    private String floor;

    @JsonProperty("door")
    private String door;

}

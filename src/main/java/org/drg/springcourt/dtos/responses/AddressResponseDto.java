package org.drg.springcourt.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressResponseDto{

    @JsonProperty("address")
    private String address;

    @JsonProperty("floor")
    private String floor;

    @JsonProperty("door")
    private String door;

}
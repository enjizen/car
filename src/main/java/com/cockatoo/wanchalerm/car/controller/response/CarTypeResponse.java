package com.cockatoo.wanchalerm.car.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarTypeResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name_thai")
    private String nameThai;

    @JsonProperty("name_eng")
    private String nameEng;
}

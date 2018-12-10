package com.cockatoo.wanchalerm.car.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropDownResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("label_thai")
    private String labelThai;

    @JsonProperty("label_eng")
    private String labelEng;
}

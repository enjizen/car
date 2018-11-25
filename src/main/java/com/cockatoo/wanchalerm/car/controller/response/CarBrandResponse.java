package com.cockatoo.wanchalerm.car.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrandResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("brand_name_thai")
    private String brandNameThai;

    @JsonProperty("brand_name_eng")
    private String brandNameEng;
}

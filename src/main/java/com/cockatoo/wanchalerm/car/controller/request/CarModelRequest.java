package com.cockatoo.wanchalerm.car.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CarModelRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("label")
    private String label;

}

package com.cockatoo.wanchalerm.car.factory;

import com.cockatoo.wanchalerm.car.constant.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static com.cockatoo.wanchalerm.car.controller.response.Response.SUCCESS_CODE;

@Component
public class ResponseFactory {

    public ResponseEntity success() {
        final GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setCode(SUCCESS_CODE);
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity success(Object data, Class clazz) {
        final GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setCode(SUCCESS_CODE);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.ok(responseObject);
    }

    public ResponseEntity error(HttpStatus httpStatus, String errorCode) {
        final GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setCode(errorCode);
        return ResponseEntity.status(httpStatus).body(responseObject);
    }

    public ResponseEntity error(HttpStatus httpStatus, String errorCode, Object data, Class clazz) {
        final GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setCode(errorCode);
        responseObject.setData(clazz.cast(data));
        return ResponseEntity.status(httpStatus).body(responseObject);
    }

}

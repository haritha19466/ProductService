package com.scaler.fakestoreapiproxy.Common;

import com.scaler.fakestoreapiproxy.DTOs.UserDto;
import com.scaler.fakestoreapiproxy.InheritanceTypes.SingleTable.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;
@Component
public class Authcommon {
    private RestTemplate restTemplate;
    public Authcommon(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    //since we cant access vadlidate() of userservice from this service we are creating this
    // and replicating dependencies of validate here also like Roles(but we are not going to store this model
    // here also which leads to duplication so removed entity tag for it and UserDto.
    public UserDto validate(String tokenvalue){
        //System.out.println("Auth validate entered");
            //ResponseEntity<UserDto>response =restTemplate.getForEntity("http://localhost:8083/users/validate/"+tokenvalue, UserDto.class);
        ResponseEntity<UserDto>response =restTemplate.getForEntity("http://USERSERVICE/users/validate/"+tokenvalue, UserDto.class);
            if(!response.hasBody()){
                return null;
            }
            return response.getBody();
    }
}

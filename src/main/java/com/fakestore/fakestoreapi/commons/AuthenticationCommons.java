package com.fakestore.fakestoreapi.commons;

import com.fakestore.fakestoreapi.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthenticationCommons {

    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public boolean validateToken(String token){
        ResponseEntity<UserDto> userDtoResponse = restTemplate.postForEntity(
                "https://localhost:8090/users/validate/" + token,
                null,
                UserDto.class
        );
        return userDtoResponse.getBody() != null;
    }
}

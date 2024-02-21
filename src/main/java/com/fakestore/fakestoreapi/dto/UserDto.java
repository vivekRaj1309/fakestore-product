package com.fakestore.fakestoreapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private List<Role> roleList;
    private boolean isEmailVerified;
}

package com.gustavoboliveira.springmongo.dtos;

import com.gustavoboliveira.springmongo.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDto(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}

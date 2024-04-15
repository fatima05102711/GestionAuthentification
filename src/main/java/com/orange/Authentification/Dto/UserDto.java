package com.orange.Authentification.Dto;

import com.orange.Authentification.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@RequiredArgsConstructor
public class UserDto {
    private Integer id ;
    private String lastname;
    private String firstname;
    private String username;
    private String password;
    private String email;
    private String token;
    public static UserDto fromEntity (User user)
            // Recupère les champs depuis ma base de donnée après avoir effectuer une requete post
            //nb : je ne recupere pas le champs mdp parcequ'on ne doit pas le renvoyer aux users
    {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail()).build();


    }

    public static User toEntity (UserDto userDto)
    {
       //Ajout vers la base de donnée
        User user = new User();
        user.setLastname(userDto.getLastname());
        user.setFirstname(userDto.getFirstname());
       // user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());

        return user;
    }
}

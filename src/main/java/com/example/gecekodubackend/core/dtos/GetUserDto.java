package com.example.gecekodubackend.core.dtos;

import com.example.gecekodubackend.core.entities.User;
import com.example.gecekodubackend.entity.concretes.Role;
import com.example.gecekodubackend.entity.dtos.event.GetEventDto;
import com.example.gecekodubackend.entity.dtos.workshop.GetWorkshopDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDto {
    private int userId;

    private String firstName;

    private String lastName;

    private String email;


    private Set<Role> authorities;

    public GetUserDto(User user){
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.authorities = user.getAuthorities();
    }

    public List<GetUserDto> buildListGetUserDto(List<User> users){
        return users.stream()
                .map(GetUserDto::new)
                .collect(Collectors.toList());
    }
}

package com.app.heartfelt.dtos;

import java.util.List;
import java.util.UUID;

import com.app.heartfelt.security.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDTO {
    private UUID id;
    private String username;
    private String password;
    private String nickname;
    private List<Role> role;
}
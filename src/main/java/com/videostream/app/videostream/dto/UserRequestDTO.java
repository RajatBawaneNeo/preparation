package com.videostream.app.videostream.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @NotBlank(message = "user name is mandatory")
    private String username;

    @NotBlank(message = "user password is mandatory")
    private String password;
}

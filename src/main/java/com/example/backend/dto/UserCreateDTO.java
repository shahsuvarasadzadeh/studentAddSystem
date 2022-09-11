package com.example.backend.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Getter
@Setter
public class UserCreateDTO {
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 2, max = 20, message = "{backend.constraints.firstname.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastname.NotNull.message}")
    @Size(min = 2, max = 20, message = "{backend.constraints.lastname.Size.message}")
    private String lastName;

}

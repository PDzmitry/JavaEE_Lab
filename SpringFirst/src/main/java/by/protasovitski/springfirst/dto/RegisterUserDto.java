package by.protasovitski.springfirst.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterUserDto {
    @NotBlank
    @Pattern(regexp = "^[\\w-]{3,}[0-9a-zA-Z]$", message = "should match the pattern /^[\\w-]{3,30}[0-9a-zA-Z]$/")
            public String login;

    @NotBlank
    @Pattern(regexp = "^(.){8,}$", message = "should match the pattern /^(.){8,}$/")
    public String password;
}

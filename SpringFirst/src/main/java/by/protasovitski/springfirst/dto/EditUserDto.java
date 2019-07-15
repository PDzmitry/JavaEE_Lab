package by.protasovitski.springfirst.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
public class EditUserDto {

    @NotNull
    public Long id;

    @NotBlank
    public String login;

    public String name;
    public String bio;
    public String url;
    public String company;
    public String location;

}

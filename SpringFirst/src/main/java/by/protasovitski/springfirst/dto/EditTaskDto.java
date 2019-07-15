package by.protasovitski.springfirst.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
public class EditTaskDto {
    @NotNull
    public Long id;
    @NotBlank
    public String name;
    public String description;
}

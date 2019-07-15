package by.protasovitski.springfirst.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
public class EditProjectDto {
    @NotNull
    public Long id;
    @NotNull
    public Boolean isPublic;
    @NotBlank
    @Pattern(regexp = "^[\\w-]{3,}[0-9a-zA-Z]$", message = "should match the pattern /^[\\w-]{3,30}[0-9a-zA-Z]$/")
            public String name;
            public String description;
            public String about;
}

package by.protasovitski.springfirst.dto;

import by.protasovitski.springfirst.entities.enums.TaskType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class NewTaskDto {
    public Long parentTaskId;

    @NotNull
    public Long projectId;

    @NotNull
    public TaskType type;

    public Double estimate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate due;

    @NotBlank
    public String name;

    public String description;

}

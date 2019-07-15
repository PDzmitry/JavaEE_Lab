package by.protasovitski.springfirst.dto;

import by.protasovitski.springfirst.entities.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectTaskTypeDto {
    public TaskType type;
    public Integer count;


}

package by.protasovitski.springfirst.dto;

import by.protasovitski.springfirst.entities.enums.TaskStatus;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class NewActivityDto {

    @NotNull
    public Long taskId;

    public TaskStatus status;
    public String description;

    @Min(value = 0,message = "elapsed time cannot be negative")
    public Double elapsed;

    public String assigneeLogin;

    public NewActivityDto(@NotNull Long taskId, TaskStatus status, String
            description, @Min(value = 0, message = "elapsed time cannot be negative")
                                  Double elapsed, String assigneeLogin) {
        this.taskId = taskId;
        this.status = status;
        this.description = description;
        this.elapsed = elapsed;
        this.assigneeLogin = assigneeLogin;
    }
}

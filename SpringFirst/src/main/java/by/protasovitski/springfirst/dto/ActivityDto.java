package by.protasovitski.springfirst.dto;

import by.protasovitski.springfirst.entities.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class ActivityDto {
    public Long id;
    public TaskDto task;
    public UserDto creator;
    public UserDto assignee;
    public TaskStatus status;
    public String description;
    public Double elapsed;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime timestamp;

    public TaskDto getTask(){
        return task;
    }
    public void setId(Long id){
        this.id=id;
    }
    public void setTask(TaskDto task){
        this.task=task;
    }
}

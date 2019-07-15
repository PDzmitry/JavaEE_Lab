package by.protasovitski.springfirst.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    public Long id;
    public Boolean isPublic;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime created;
    public String name;
    public String description;
    public String about;
    public UserDto user;
    public Double estimate;
    public Double elapsed;

}

package by.protasovitski.springfirst.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectActivityDto {

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate day;

    public Integer activityAmount;

}

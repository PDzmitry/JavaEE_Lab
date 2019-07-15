package by.protasovitski.springfirst.dto;

import by.protasovitski.springfirst.entities.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate joined;

    public UserInfo userInfo;

}

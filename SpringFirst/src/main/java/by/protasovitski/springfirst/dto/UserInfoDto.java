package by.protasovitski.springfirst.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

    public Integer id;
    public String name;
    public String bio;
    public String url;
    public String company;
    public String location;

}

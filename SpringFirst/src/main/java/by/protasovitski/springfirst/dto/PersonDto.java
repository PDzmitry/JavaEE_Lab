package by.protasovitski.springfirst.dto;

import by.protasovitski.springfirst.validator.CellPhone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements Serializable {

    private Long id;
    @NotNull(message = "{valid.name.notNull}")
    @Size(min = 3, message = "{valid.firstname.size.min3}")
    private String firstName;
    @NotBlank(message = "{valid.lastname.notBlank}")
    private String lastName;
    @NotBlank(message = "{valid.street.notBlank}")
    private String street;
    @NotBlank(message = "{valid.city.notBlank}")
    private String city;
    @Digits(integer = 6, fraction = 0, message = "{valid.zip.digits}")
    private String zip;
    @NotBlank(message = "{valid.email.notBlank}")
    @Email(message = "{valid.email.email}")
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "{valid.birthday.past}")
    private Date birthday;

    @CellPhone(message = "{valid.phone.cellphone}")
    private String phone;
}

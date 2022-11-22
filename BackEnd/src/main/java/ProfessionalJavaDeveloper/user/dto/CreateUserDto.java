package ProfessionalJavaDeveloper.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
public class CreateUserDto {

    @JsonProperty("nameName")
    private String userName;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("password")
    private String password;

}

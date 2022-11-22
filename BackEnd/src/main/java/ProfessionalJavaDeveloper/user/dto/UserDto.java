package ProfessionalJavaDeveloper.user.dto;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("characterDtos")
    private Set<CharacterDto> characterDtos;

}

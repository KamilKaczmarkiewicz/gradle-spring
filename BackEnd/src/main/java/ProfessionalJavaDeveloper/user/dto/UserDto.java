package ProfessionalJavaDeveloper.user.dto;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import ProfessionalJavaDeveloper.user.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;
import java.util.function.Function;

@Getter
@Setter
@Builder
public class UserDto {

    @JsonProperty("id")
    private long id;

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

    //TODO check what to do with this
    public static User dtoToEntityMapper(UserDto userDto){
        return User.builder()
                .userName(userDto.getUserName())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}

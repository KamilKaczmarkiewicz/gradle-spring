package ProfessionalJavaDeveloper.user.dto;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import ProfessionalJavaDeveloper.user.entity.User;
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
@ToString
public class UserDto {
    private long id;
    private String userName;
    private String name;
    private String lastName;
    private Set<CharacterDto> characterDtos;

    public static User dtoToEntityMapper(UserDto userDto){
        return User.builder()
                .userName(userDto.getUserName())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .build();
    }
}

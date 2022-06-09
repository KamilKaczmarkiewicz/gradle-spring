package ProfessionalJavaDeveloper.user.dto;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserDto {
    private long id;
    private String name;
    private String lastName;
    private Set<CharacterDto> characterDtos;
}

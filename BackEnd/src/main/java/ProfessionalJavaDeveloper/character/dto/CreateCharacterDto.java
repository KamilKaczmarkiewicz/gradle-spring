package ProfessionalJavaDeveloper.character.dto;

import ProfessionalJavaDeveloper.character.entity.enums.CharacterClass;
import ProfessionalJavaDeveloper.character.entity.enums.Sex;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateCharacterDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("sex")
    private Sex sex;

    @JsonProperty("characterClass")
    private CharacterClass characterClass;
}

package ProfessionalJavaDeveloper.character.dto;

import ProfessionalJavaDeveloper.character.entity.enums.CharacterClass;
import ProfessionalJavaDeveloper.character.entity.enums.Sex;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@Builder
public class CharacterDto {
    private long id;
    private String name;
    private int lvl;
    private Sex sex;
    private CharacterClass characterClass;
}

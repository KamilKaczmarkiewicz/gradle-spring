package ProfessionalJavaDeveloper.character.dto;

import ProfessionalJavaDeveloper.character.entity.enums.CharacterClass;
import ProfessionalJavaDeveloper.character.entity.enums.Sex;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CharacterDto {
    private long id;
    private String name;
    private int lvl;
    private Sex sex;
    private CharacterClass characterClass;
    private int strength;
    private int dexterity;
    private int vitality;
    private int exp;
    private int gold;
    private int attributePoints;
    private int hp;
    private int maxHp;
    private Boolean isAlive;
}

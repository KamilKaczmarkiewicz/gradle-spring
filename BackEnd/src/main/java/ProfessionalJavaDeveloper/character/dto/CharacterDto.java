package ProfessionalJavaDeveloper.character.dto;

import ProfessionalJavaDeveloper.character.entity.Character;
import ProfessionalJavaDeveloper.character.entity.enums.CharacterClass;
import ProfessionalJavaDeveloper.character.entity.enums.Sex;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lvl")
    private int lvl;

    @JsonProperty("sex")
    private Sex sex;

    @JsonProperty("characterClass")
    private CharacterClass characterClass;

    @JsonProperty("strength")
    private int strength;

    @JsonProperty("dexterity")
    private int dexterity;

    @JsonProperty("vitality")
    private int vitality;

    @JsonProperty("exp")
    private int exp;

    @JsonProperty("gold")
    private int gold;

    @JsonProperty("attributePoints")
    private int attributePoints;

    @JsonProperty("hp")
    private int hp;

    @JsonProperty("maxHp")
    private int maxHp;

    @JsonProperty("isAlive")
    private Boolean isAlive;

    @JsonProperty("userId")
    private long userId;

    public CharacterDto (Character character){
        id = character.getId();
        name = character.getName();
        lvl = character.getLvl();
        sex = character.getSex();
        characterClass = character.getCharacterClass();
        strength = character.getStrength();
        dexterity = character.getDexterity();
        vitality = character.getVitality();
        exp = character.getExp();
        gold = character.getGold();
        attributePoints = character.getAttributePoints();
        hp = character.getHp();
        maxHp = character.getMaxHp();
        isAlive = character.getIsAlive();
        userId = character.getUserId().getId();
    }
}

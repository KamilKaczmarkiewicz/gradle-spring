package ProfessionalJavaDeveloper.character.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCharacterDto {

    @JsonProperty("strength")
    private int strength;

    @JsonProperty("dexterity")
    private int dexterity;

    @JsonProperty("vitality")
    private int vitality;

    @JsonProperty("lvl")
    private int lvl;

    @JsonProperty("maxHp")
    private int maxHp ;

    @JsonProperty("attributePoints")
    private int attributePoints;

    @JsonProperty("exp")
    private int exp;
}

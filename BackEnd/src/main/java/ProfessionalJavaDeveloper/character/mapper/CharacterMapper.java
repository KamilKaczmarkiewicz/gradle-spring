package ProfessionalJavaDeveloper.character.mapper;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import ProfessionalJavaDeveloper.character.dto.CreateCharacterDto;
import ProfessionalJavaDeveloper.character.dto.UpdateCharacterDto;
import ProfessionalJavaDeveloper.character.entity.Character;
import ProfessionalJavaDeveloper.user.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CharacterMapper {

    @Mapping(target = "userId", source = "userId", qualifiedByName = "mapUser")
    CharacterDto characterToCharacterDto(Character character);

    Character createCharacterDtoToCharacter(CreateCharacterDto createCharacterDto);

    default Character updateCharacterDtoToCharacter(Character character, UpdateCharacterDto updateCharacterDto){
        character.setStrength(updateCharacterDto.getStrength());
        character.setDexterity(updateCharacterDto.getDexterity());
        character.setVitality(updateCharacterDto.getVitality());
        character.setLvl(updateCharacterDto.getLvl());
        character.setMaxHp(updateCharacterDto.getMaxHp());
        character.setHp(updateCharacterDto.getMaxHp());
        character.setAttributePoints(updateCharacterDto.getAttributePoints());
        character.setExp(updateCharacterDto.getExp());
        return character;
    }

    @Named("mapUser")
    default long mapUser(User user){
        return user.getId();
    }
}

package ProfessionalJavaDeveloper.character.mapper;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import ProfessionalJavaDeveloper.character.entity.Character;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CharacterMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lvl", source = "lvl")
    @Mapping(target = "sex", source = "sex")
    @Mapping(target = "characterClass", source = "characterClass")
    @Mapping(target = "strength", source = "strength")
    @Mapping(target = "dexterity", source = "dexterity")
    @Mapping(target = "vitality", source = "vitality")
    @Mapping(target = "exp", source = "exp")
    @Mapping(target = "gold", source = "gold")
    @Mapping(target = "attributePoints", source = "attributePoints")
    @Mapping(target = "hp", source = "hp")
    @Mapping(target = "maxHp", source = "maxHp")
    @Mapping(target = "isAlive", source = "isAlive")
    CharacterDto convertCharacterToCharacterDto(Character character);
}

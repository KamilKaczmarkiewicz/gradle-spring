package ProfessionalJavaDeveloper.user.mapper;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import ProfessionalJavaDeveloper.character.entity.Character;
import ProfessionalJavaDeveloper.user.dto.UserDto;
import ProfessionalJavaDeveloper.user.entity.User;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

//TODO change all of this
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userName", source = "username")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "characterDtos", source = "characters", qualifiedByName = "mapCharacters")
    UserDto convertUserToUserDto(User user);

    //"long map(User value)"

    @Named("mapCharacters")
    default Set<CharacterDto> mapCharacters(Set<Character> characters){
        return characters.stream().map(character -> new CharacterDto(character)).collect(Collectors.toSet());
    }
}

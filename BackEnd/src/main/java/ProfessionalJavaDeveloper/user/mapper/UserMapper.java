package ProfessionalJavaDeveloper.user.mapper;

import ProfessionalJavaDeveloper.character.dto.CharacterDto;
import ProfessionalJavaDeveloper.character.entity.Character;
import ProfessionalJavaDeveloper.user.dto.CreateUserDto;
import ProfessionalJavaDeveloper.user.dto.UpdateUserDto;
import ProfessionalJavaDeveloper.user.dto.UserDto;
import ProfessionalJavaDeveloper.user.entity.User;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "userName", source = "username")
    @Mapping(target = "characterDtos", source = "characters", qualifiedByName = "mapCharacters")
    UserDto userToUserDto(User user);

    User createUserDtoToUser(CreateUserDto createUserDto);

    default User updateUserDtoToUser(User user, UpdateUserDto updateUserDto){
        user.setPassword(updateUserDto.getPassword());
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        return user;
    }

    @Named("mapCharacters")
    default Set<CharacterDto> mapCharacters(Set<Character> characters){
        return characters.stream().map(character -> new CharacterDto(character)).collect(Collectors.toSet());
    }
}

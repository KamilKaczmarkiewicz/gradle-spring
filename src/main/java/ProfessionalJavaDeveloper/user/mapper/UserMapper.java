package ProfessionalJavaDeveloper.user.mapper;

import ProfessionalJavaDeveloper.user.dto.UserDto;
import ProfessionalJavaDeveloper.user.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    UserDto convertUserToUserDto(User user);
}

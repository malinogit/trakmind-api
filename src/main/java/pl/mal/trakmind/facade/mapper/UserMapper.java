package pl.mal.trakmind.facade.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.model.dto.UserDto;

@Mapper(componentModel = "spring")
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "roles", ignore = true)
    })
    UserDto userToUserDto(User user);
}

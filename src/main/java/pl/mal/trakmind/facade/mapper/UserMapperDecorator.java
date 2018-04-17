package pl.mal.trakmind.facade.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mal.trakmind.model.domain.Role;
import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.model.dto.UserDto;

import java.util.stream.Collectors;

abstract class UserMapperDecorator implements UserMapper {

    private UserMapper userMapper;

    @Autowired
    public void init(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDto userToUserDto(User user) {
        UserDto accountDto = userMapper.userToUserDto(user);
        accountDto.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return accountDto;
    }
}

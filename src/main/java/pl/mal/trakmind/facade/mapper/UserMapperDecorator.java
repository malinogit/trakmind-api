package pl.mal.trakmind.facade.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import pl.mal.trakmind.model.domain.Privilege;
import pl.mal.trakmind.model.domain.Role;
import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.model.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class UserMapperDecorator implements UserMapper {

    private UserMapper userMapper;

    @Autowired
    public void init(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDto userToUserDto(User user) {
        UserDto userDto = userMapper.userToUserDto(user);
        List<Role> roles = new ArrayList<>(user.getRoles());
        List<String> privileges = new ArrayList<>();
        roles.forEach(role -> privileges.addAll(role.getPrivileges().stream().map(Privilege::getName).collect(Collectors.toList())));

        userDto.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        userDto.setPrivileges(privileges);

        return userDto;
    }
}

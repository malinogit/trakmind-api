package pl.mal.trakmind.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mal.trakmind.facade.mapper.UserMapper;
import pl.mal.trakmind.model.dto.UserDto;
import pl.mal.trakmind.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade{

    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    public List<UserDto> findByUsername(String username) {
        return userService.findByUsername(username)
                .stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    }
}

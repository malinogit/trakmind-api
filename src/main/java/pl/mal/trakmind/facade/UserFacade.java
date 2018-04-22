package pl.mal.trakmind.facade;

import pl.mal.trakmind.model.dto.UserDto;

import java.util.List;

public interface UserFacade {

    List<UserDto> findByUsername(String username);
    UserDto registerUser(UserDto userDto);
}

package pl.mal.trakmind.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.mal.trakmind.model.dto.UserDto;

import java.util.List;

public interface CommonController {



    default ResponseEntity<UserDto> packResponseUser(List<UserDto> users) {
        return users.stream()
                .map(accountDto -> new ResponseEntity<>(accountDto, HttpStatus.OK))
                .findFirst().orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

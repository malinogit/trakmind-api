package pl.mal.trakmind.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mal.trakmind.facade.UserFacade;
import pl.mal.trakmind.model.dto.UserDto;

import java.util.Collections;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController implements CommonController {

    private final UserFacade userFacade;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    ResponseEntity<UserDto> findByUsername(@PathVariable String username) {
        return packResponseUser(userFacade.findByUsername(username));
    }

    @CrossOrigin
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<UserDto> registerUser(@Validated @RequestBody UserDto userDto) {
        return packResponseUser(Collections.singletonList(userFacade.registerUser(userDto)));
    }
}

package pl.mal.trakmind.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.mal.trakmind.facade.UserFacade;
import pl.mal.trakmind.model.dto.UserDto;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {


    private final UserFacade userFacade;


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    ResponseEntity<UserDto> findByUsername(@PathVariable String username) {
        return userFacade.findByUsername(username).stream()
                .map(accountDto -> new ResponseEntity<>(accountDto, HttpStatus.OK))
                .findFirst().orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

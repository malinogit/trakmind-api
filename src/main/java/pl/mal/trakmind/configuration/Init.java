package pl.mal.trakmind.configuration;

import lombok.AllArgsConstructor;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import pl.mal.trakmind.model.domain.User;
import pl.mal.trakmind.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

import static pl.mal.trakmind.model.RoleNameEnum.*;

@Component
@AllArgsConstructor
public class Init {

    private final UserService userService;

    @PostConstruct
    public void initLoggerConfig() {
        BasicConfigurator.configure();
    }

    @Bean
    public CommandLineRunner initUsers() {
        List<User> userList = userService.findAll();
        if (userList != null && userList.size() > 0) {
            return null;
        }
        return (evt) -> Arrays.asList(
                Pair.of("Anonymous", ANONYMOUS), Pair.of("BasicUser", BASIC_USER), Pair.of("GlobalAdmin", GLOBAL_ADMIN))
                .forEach(
                        (preUser) -> userService.save(preUser.getFirst(), preUser.getSecond())
                );
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}

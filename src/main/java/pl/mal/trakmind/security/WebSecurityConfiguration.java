package pl.mal.trakmind.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.mal.trakmind.model.domain.Role;
import pl.mal.trakmind.service.UserService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    private final UserService userService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return (username) -> userService.findByUsername(username)
                .stream().map(a ->
                        new User(a.getUsername(), a.getPassword(), a.getEnabled(), a.getAccountNotExpired(),
                        a.getCredentialsNonExpired(), a.getAccountNonLocked(),
                        AuthorityUtils.commaSeparatedStringToAuthorityList(
                                new ArrayList<>(a.getRoles()).stream().map(Role::getName)
                                        .collect(Collectors.joining(","))))).findFirst().orElseThrow(
                        () -> new UsernameNotFoundException("could not find the user '"
                                + username + "'"));
    }
}

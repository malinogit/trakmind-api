package pl.mal.trakmind.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

import static pl.mal.trakmind.model.RegExp.EMAIL;
import static pl.mal.trakmind.model.RegExp.PASSWORD;
import static pl.mal.trakmind.model.RegExp.USERNAME;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    @NotNull
    @Pattern(regexp = USERNAME)
    private String username;

    @NotNull
    @Pattern(regexp = PASSWORD)
    private String password;

    @NotNull
    @Pattern(regexp = EMAIL)
    private String email;

    @JsonIgnore
    private Boolean enabled;

    @JsonIgnore
    private Boolean accountNotExpired;

    @JsonIgnore
    private Boolean credentialsNonExpired;

    @JsonIgnore
    private Boolean accountNonLocked;

    @JsonIgnore
    private List<String> roles;

    @JsonIgnore
    private List<String> privileges;
}

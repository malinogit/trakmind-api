package pl.mal.trakmind.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Integer id;
    private String username;
    private Boolean enabled;
    private Boolean accountNotExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    private List<String> roles;
    private List<String> privileges;
}

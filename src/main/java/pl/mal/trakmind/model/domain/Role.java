package pl.mal.trakmind.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> accountCollection;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;
}

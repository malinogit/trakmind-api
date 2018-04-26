package pl.mal.trakmind.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String actionType;

    @Column
    private String message;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column
    private String username;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}

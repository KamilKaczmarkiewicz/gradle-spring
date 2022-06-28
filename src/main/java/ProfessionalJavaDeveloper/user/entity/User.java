package ProfessionalJavaDeveloper.user.entity;

import ProfessionalJavaDeveloper.character.entity.Character;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


/**
 * Entity for the users.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Character> characters;
}

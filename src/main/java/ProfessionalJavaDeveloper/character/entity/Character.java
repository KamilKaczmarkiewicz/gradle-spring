package ProfessionalJavaDeveloper.character.entity;

import ProfessionalJavaDeveloper.character.entity.enums.CharacterClass;
import ProfessionalJavaDeveloper.character.entity.enums.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity for characters owned by the user.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    private int lvl;

    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "character_class")
    private CharacterClass characterClass;
}

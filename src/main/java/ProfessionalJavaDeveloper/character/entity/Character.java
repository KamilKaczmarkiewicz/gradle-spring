package ProfessionalJavaDeveloper.character.entity;

import ProfessionalJavaDeveloper.character.entity.enums.CharacterClass;
import ProfessionalJavaDeveloper.character.entity.enums.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity for characters owned by the user and NPC's.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="characters")
public class Character extends Creature {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /**
     * Sex of the character.
     */
    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    /**
     * Character's class.
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "character_class")
    private CharacterClass characterClass;
}

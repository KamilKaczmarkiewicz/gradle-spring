package ProfessionalJavaDeveloper.character.entity;

import ProfessionalJavaDeveloper.character.entity.enums.CharacterClass;
import ProfessionalJavaDeveloper.character.entity.enums.Sex;
import ProfessionalJavaDeveloper.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Entity for characters owned by the user and NPC's.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name="characters")
public class Character extends Creature {

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

    /**
     * Character's current Experience Points.
     */
    private int exp;

    /**
     * Character's gold in possession.
     */
    private int gold;

    /**
     * Character's available points that can be distributed between stats.
     */
    @Column(name = "attribute_points")
    @Builder.Default
    private int attributePoints = 3;

    /**
     * Character's userID.
     */
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
}

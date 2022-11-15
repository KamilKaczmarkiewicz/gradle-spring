package ProfessionalJavaDeveloper.character.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Class for all living creatures. Contains their stats.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
@MappedSuperclass
public class Creature {

    /**
     * Creature's name.
     */
    private String name;

    /**
     * Creature's strength stat. Related to damage creature does.
     */
    @Builder.Default
    private int strength = 1;

    /**
     * Creature's dexterity stat. Related to chance to hit and dodge in combat.
     */
    @Builder.Default
    private int dexterity = 1;

    /**
     * Creature's vitality stat. Related to max Health Points.
     */
    @Builder.Default
    private int vitality = 1;

    /**
     * Creature's lvl.
     */
    @Builder.Default
    private int lvl = 1;

    /**
     * Creature's current Health Points.
     */
    @Builder.Default
    private int hp = 10;

    /**
     * Creature's max Health Points.
     */
    @Column(name = "max_hp")
    @Builder.Default
    private int maxHp = 10;

    /**
     * Creature is alive - true. Creature is dead - false.
     */
    @Column(name = "is_alive")
    @Builder.Default
    private Boolean isAlive = true;
}

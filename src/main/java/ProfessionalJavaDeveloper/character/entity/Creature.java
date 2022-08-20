package ProfessionalJavaDeveloper.character.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Class for all living creatures. Contains their stats.
 */
@Getter
@Setter
@MappedSuperclass
public class Creature {

    /**
     * Creature's name.
     */
    private String name;

    /**
     * Creature's strength stat. Related to damage creature does.
     */
    private int strength;

    /**
     * Creature's dexterity stat. Related to chance to hit and dodge in combat.
     */
    private int dexterity;

    /**
     * Creature's vitality stat. Related to max Health Points.
     */
    private int vitality;

    /**
     * Creature's lvl.
     */
    private int lvl;

    /**
     * Creature's current Experience Points.
     */
    private int exp;

    /**
     * Creature's gold in possession.
     */
    private int gold;

    /**
     * Creature's available points that can be distributed between stats.
     */
    @Column(name = "attribute_points")
    private int attributePoints;

    /**
     * Creature's current Health Points.
     */
    private int hp;

    /**
     * Creature's max Health Points.
     */
    @Column(name = "max_hp")
    private int maxHp;

    /**
     * Creature is alive - true. Creature is dead - false.
     */
    @Column(name = "is_alive")
    private Boolean isAlive;
}

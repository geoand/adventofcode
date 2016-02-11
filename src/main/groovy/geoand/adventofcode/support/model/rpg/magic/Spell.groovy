package geoand.adventofcode.support.model.rpg.magic

import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 11/2/2016.
 */
@CompileStatic
class Spell {

    final int manaCost
    final int damage
    final int armor
    final int heal
    final int newMana
    final int duration

    Spell(int manaCost, int damage, int armor, int heal, int newMana, int duration) {
        this.manaCost = manaCost
        this.damage = damage
        this.armor = armor
        this.heal = heal
        this.newMana = newMana
        this.duration = duration
    }

    static Spell simpleAttack(int manaCost, int damage) {
        return new Spell(manaCost, damage, 0, 0, 0, 1)
    }

    static Spell healingAttack(int manaCost, int damage, int heal) {
        return new Spell(manaCost, damage, 0, heal, 0, 1)
    }

    static Spell defence(int manaCost, int armor, int duration) {
        return new Spell(manaCost, 0, armor, 0, 0, duration)
    }

    static Spell attack(int manaCost, int damage, int duration) {
        return new Spell(manaCost, damage, 0, 0, 0, duration)
    }

    static Spell rechange(int manaCost, int newMana, int duration) {
        return new Spell(manaCost, 0, 0, 0, newMana, duration)
    }
}

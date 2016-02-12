package geoand.adventofcode.support.model.rpg.magic.stats

import geoand.adventofcode.support.model.rpg.magic.spell.Spell
import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 12/2/2016.
 */
@CompileStatic
class PlayerStats {

    final int health
    final int mana

    private PlayerStats(int health, int mana) {
        this.health = health
        this.mana = mana
    }

    static PlayerStats with(int health, int mana) {
        return new PlayerStats(health, mana)
    }

    PlayerStats playRound(Spell spell, int bossDamage) {
        Math.max(bossDamage - spell.armorEffect.effect, 1)
        return new PlayerStats(health + spell.healthEffect.effect, mana + spell.manaEffect.effect)
    }
}

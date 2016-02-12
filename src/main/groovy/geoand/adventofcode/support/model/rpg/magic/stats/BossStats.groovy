package geoand.adventofcode.support.model.rpg.magic.stats

import geoand.adventofcode.support.model.rpg.magic.spell.Spell
import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 12/2/2016.
 */
@CompileStatic
class BossStats {

    final int health

    private BossStats(int health) {
        this.health = health
    }

    static BossStats with(int health) {
        return new BossStats(health)
    }

    BossStats applySpell(Spell spell) {
        return new BossStats(health - spell.damageEffect.effect)
    }
}

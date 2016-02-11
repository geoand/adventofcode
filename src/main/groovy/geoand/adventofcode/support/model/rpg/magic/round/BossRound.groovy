package geoand.adventofcode.support.model.rpg.magic.round

import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 11/2/2016.
 */
@CompileStatic
class BossRound {

    final int health
    final int damage

    BossRound(int health, int damage) {
        this.health = health
        this.damage = damage
    }

    BossRound reduceHealth(int number) {
        return new BossRound(health - number, damage)
    }
}

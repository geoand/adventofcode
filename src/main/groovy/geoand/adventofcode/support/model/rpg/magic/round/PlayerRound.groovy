package geoand.adventofcode.support.model.rpg.magic.round

import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 11/2/2016.
 */
@CompileStatic
class PlayerRound {

    final int health
    final int mana

    final SpellRoundsContainer spellRoundsContainer

    PlayerRound(int health, int mana, SpellRoundsContainer spellRoundsContainer) {
        this.health = health
        this.mana = mana
        this.spellRoundsContainer = spellRoundsContainer
    }


}

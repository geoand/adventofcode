package geoand.adventofcode.support.model.rpg.magic.round

import geoand.adventofcode.support.model.rpg.magic.Spell
import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 11/2/2016.
 */
@CompileStatic
class SpellRoundsContainer {

    @Delegate
    final Spell spell
    final int roundsAlreadyUsed

    SpellRoundsContainer(Spell spell, int roundsAlreadyUsed) {
        this.spell = spell
        this.roundsAlreadyUsed = roundsAlreadyUsed
    }

    static SpellRoundsContainer initialUse(Spell spell) {
        return new SpellRoundsContainer(spell, 0)
    }

    SpellRoundsContainer useAgain() {
        return new SpellRoundsContainer(spell, roundsAlreadyUsed+1)
    }
}

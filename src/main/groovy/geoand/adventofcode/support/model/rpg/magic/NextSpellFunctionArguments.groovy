package geoand.adventofcode.support.model.rpg.magic

import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 11/2/2016.
 */
@CompileStatic
class NextSpellFunctionArguments {

    final int playerHealth
    final int playerMana
    final int bossHealth

    NextSpellFunctionArguments(int playerHealth, int playerMana, int bossHealth) {
        this.playerHealth = playerHealth
        this.playerMana = playerMana
        this.bossHealth = bossHealth
    }
}

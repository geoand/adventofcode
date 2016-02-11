package geoand.adventofcode.support.model.rpg.magic.round

import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 11/2/2016.
 */
@CompileStatic
class RoundContainer {

    final BossRound bossRound
    final PlayerRound playerRound

    RoundContainer(BossRound bossRound, PlayerRound playerRound) {
        this.bossRound = bossRound
        this.playerRound = playerRound
    }
}

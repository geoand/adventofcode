package geoand.adventofcode.support.model.rpg.magic.stats

import geoand.adventofcode.support.model.rpg.magic.spell.Spell
import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 12/2/2016.
 */
@CompileStatic
class BossPlayerStats {

    enum RoundOutcome {
        PLAYER_WINS,
        BOSS_WINS,
        INCONCLUSIVE
    }

    final BossStats bossStats
    final PlayerStats playerStats

    private BossPlayerStats(BossStats bossStats, PlayerStats playerStats) {
        this.bossStats = bossStats
        this.playerStats = playerStats
    }

    static BossPlayerStats from(BossStats bossStats, PlayerStats playerStats) {
        return new BossPlayerStats(bossStats, playerStats)
    }

    BossPlayerStats playRound(Spell spell, int bossDamage) {
        return new BossPlayerStats(bossStats.applySpell(spell), playerStats.playRound(spell, bossDamage))
    }

    RoundOutcome outcome() {
        if(bossStats.health <= 0) {
            return RoundOutcome.PLAYER_WINS
        }
        if((playerStats.health < 0) || (playerStats.mana < 0)) {
            return RoundOutcome.BOSS_WINS
        }

        return RoundOutcome.INCONCLUSIVE
    }
}

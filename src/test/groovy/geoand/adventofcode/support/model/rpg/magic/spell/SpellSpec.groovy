package geoand.adventofcode.support.model.rpg.magic.spell

import geoand.adventofcode.support.model.rpg.magic.spell.specific.MagicMissile
import geoand.adventofcode.support.model.rpg.magic.spell.specific.Poison
import geoand.adventofcode.support.model.rpg.magic.spell.specific.Shield
import spock.lang.Specification

/**
 * Created by gandrianakis on 12/2/2016.
 */
class SpellSpec extends Specification {

    def "combination of single round spell with self"() {
        given:
            final Spell initSpell = new MagicMissile()

        when:
            final Spell newSpell = initSpell.combineForNextRound(new MagicMissile())

        then:
            newSpell.cost == 2 * initSpell.cost
            newSpell.armorEffect == initSpell.armorEffect
            newSpell.damageEffect == initSpell.damageEffect
            newSpell.healthEffect == initSpell.healthEffect
            newSpell.manaEffect == initSpell.manaEffect
    }

    def "combination of two different spells"() {
        given:
            final Spell poison = new Poison()

        and:
            final Spell shield = new Shield()

        when:
            final Spell newSpell = poison.combineForNextRound(shield)

        then:
            newSpell.cost == shield.cost + poison.cost
            newSpell.armorEffect == shield.armorEffect
            newSpell.damageEffect == poison.damageEffect.decreaseDuration()
            newSpell.healthEffect == SpellEffect.singleRoundNoEffect()
            newSpell.manaEffect == SpellEffect.singleRoundNoEffect()
    }

    def "illegal combination"() {
        given:
            final Spell initSpell = new Poison()

        when:
            initSpell.combineForNextRound(new MagicMissile())

        then:
            thrown IllegalStateException
    }
}

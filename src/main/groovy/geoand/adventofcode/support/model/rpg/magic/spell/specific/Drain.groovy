package geoand.adventofcode.support.model.rpg.magic.spell.specific

import geoand.adventofcode.support.model.rpg.magic.spell.AbstractCombineSpell
import geoand.adventofcode.support.model.rpg.magic.spell.SpellEffect
import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 12/2/2016.
 */
@CompileStatic
class Drain extends AbstractCombineSpell {

    @Override
    int getCost() {
        return 73
    }

    @Override
    SpellEffect getDamageEffect() {
        return SpellEffect.singleRoundEffect(2)
    }

    @Override
    SpellEffect getHealthEffect() {
        return SpellEffect.singleRoundEffect(2)
    }
}

package geoand.adventofcode.support.model.rpg.magic.spell.specific

import geoand.adventofcode.support.model.rpg.magic.spell.AbstractCombineSpell
import geoand.adventofcode.support.model.rpg.magic.spell.SpellEffect
import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 12/2/2016.
 */
@CompileStatic
class Poison extends AbstractCombineSpell{

    @Override
    int getCost() {
        return 173
    }

    @Override
    SpellEffect getDamageEffect() {
        return SpellEffect.with(3, 6)
    }
}

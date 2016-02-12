package geoand.adventofcode.support.model.rpg.magic.spell;
/**
 * Created by gandrianakis on 12/2/2016.
 */
public interface Spell {

    int getCost();

    default SpellEffect getDamageEffect() {
        return SpellEffect.singleRoundNoEffect();
    }

    default SpellEffect getHealthEffect() {
        return SpellEffect.singleRoundNoEffect();
    }

    default SpellEffect getArmorEffect() {
        return SpellEffect.singleRoundNoEffect();
    }

    default SpellEffect getManaEffect() {
        return SpellEffect.singleRoundNoEffect();
    }

    Spell combineForNextRound(Spell other);
}

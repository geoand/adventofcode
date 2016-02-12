package geoand.adventofcode.support.model.rpg.magic.spell

/**
 * Created by gandrianakis on 12/2/2016.
 */
abstract class AbstractCombineSpell implements Spell {

    @Override
    Spell combineForNextRound(Spell otherSpell) {
        final Spell thisSpell = this

        final SpellEffect newDamageEffect = combineSpellEffect(thisSpell.&getDamageEffect, otherSpell.&getDamageEffect)
        final SpellEffect newHealthEffect = combineSpellEffect(thisSpell.&getHealthEffect, otherSpell.&getHealthEffect)
        final SpellEffect newArmorEffect = combineSpellEffect(thisSpell.&getArmorEffect, otherSpell.&getArmorEffect)
        final SpellEffect newManaEffect = combineSpellEffect(thisSpell.&getManaEffect, otherSpell.&getManaEffect)

        return new AbstractCombineSpell() {
            @Override
            int getCost() {
                return thisSpell.cost + otherSpell.cost
            }

            @Override
            SpellEffect getDamageEffect() {
                return newDamageEffect
            }

            @Override
            SpellEffect getHealthEffect() {
                return newHealthEffect
            }

            @Override
            SpellEffect getArmorEffect() {
                return newArmorEffect
            }

            @Override
            SpellEffect getManaEffect() {
                return newManaEffect
            }
        }

    }

    private static SpellEffect combineSpellEffect(Closure<SpellEffect> thisSpellClosure, Closure<SpellEffect> otherSpellClosure) {
        final SpellEffect thisEffect = thisSpellClosure()
        final SpellEffect otherEffect = otherSpellClosure()

        if(thisEffect.duration in [0, 1]) {
            return otherEffect
        }

        if(otherEffect.effect > 0) {
            throw new IllegalStateException("Cannot combine spells because they have the same effect in the same round")
        }

        return thisEffect.decreaseDuration()
    }

}
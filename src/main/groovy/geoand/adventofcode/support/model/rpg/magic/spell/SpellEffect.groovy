package geoand.adventofcode.support.model.rpg.magic.spell

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by gandrianakis on 12/2/2016.
 */
@CompileStatic
@EqualsAndHashCode
@ToString(includePackage = false)
class SpellEffect {

    final int effect
    final int duration

    private SpellEffect(int effect, int duration) {
        if((effect < 0) || (duration < 0)) {
            throw new IllegalArgumentException("effect and duration must be non negative")
        }

        this.effect = effect
        this.duration = duration
    }

    static SpellEffect singleRoundNoEffect() {
        return new SpellEffect(0, 1)
    }

    static SpellEffect singleRoundEffect(int effect) {
        return new SpellEffect(effect, 1)
    }

    static SpellEffect with(int effect, int duration) {
        return new SpellEffect(effect, duration)
    }

    SpellEffect decreaseDuration() {
        if(duration == 0) {
            throw new IllegalStateException("Performing the operation would result in a negative duration")
        }

        return new SpellEffect(effect, duration - 1)
    }
}

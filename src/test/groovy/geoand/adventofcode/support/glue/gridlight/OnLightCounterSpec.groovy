package geoand.adventofcode.support.glue.gridlight

import spock.lang.Specification
import spock.lang.Unroll

import static geoand.adventofcode.support.glue.gridlight.State.*

/**
 * Created by George Andrianakis on 28/1/2016.
 */
class OnLightCounterSpec extends Specification {

    @Unroll
    def "simple 6x6 grid - part one"(int steps, int onCount) {
        given:
            final List<List<State>> grid = [
                    [OFF, ON, OFF, ON, OFF, ON],
                    [OFF, OFF, OFF, ON, ON, OFF],
                    [ON, OFF, OFF, OFF, OFF, ON],
                    [OFF, OFF, ON, OFF, OFF, OFF],
                    [ON, OFF, ON, OFF, OFF, ON],
                    [ON, ON, ON, ON, OFF, OFF]
            ]

        when:
            final OnLightCounter onLightCounter = new OnLightCounter(new PartOneStateCalculator())

        then:
            onLightCounter.count(grid, steps) == onCount

        where:
            steps | onCount
            1 | 11
            2 | 8
            3 | 4
            4 | 4
    }

    @Unroll
    def "simple 6x6 grid - part two"(int steps, int onCount) {
        given:
            final List<List<State>> grid = [
                    [ON, ON, OFF, ON, OFF, ON],
                    [OFF, OFF, OFF, ON, ON, OFF],
                    [ON, OFF, OFF, OFF, OFF, ON],
                    [OFF, OFF, ON, OFF, OFF, OFF],
                    [ON, OFF, ON, OFF, OFF, ON],
                    [ON, ON, ON, ON, OFF, ON]
            ]

        when:
            final OnLightCounter onLightCounter = new OnLightCounter(new PartTwoStateCalculator())

        then:
            onLightCounter.count(grid, steps) == onCount

        where:
            steps | onCount
            1 | 18
            2 | 18
            3 | 18
            4 | 14
            5 | 17
    }
}

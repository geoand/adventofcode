package geoand.adventofcode.support.math

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 3/2/2016.
 */
class FactorSumSpec extends Specification {

    @Unroll
    def "test"(Integer input, Integer expectedOutput) {
        expect:
            FactorSum.perform(input) == expectedOutput

        where:
            input | expectedOutput
            2 | 3
            8 | 15
            9 | 13
            1225 | 1767
            2450 | 5301
    }
}

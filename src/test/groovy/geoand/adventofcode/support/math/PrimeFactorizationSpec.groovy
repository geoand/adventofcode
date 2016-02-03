package geoand.adventofcode.support.math

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 3/2/2016.
 */
class PrimeFactorizationSpec extends Specification {

    @Unroll
    def "test"(Integer input, Map<Integer, Integer> expectedOutput) {
        expect:
            PrimeFactorization.perform(input) == expectedOutput

        where:
            input | expectedOutput
            35 | [5:1, 7:1]
            72 | [2:3, 3:2]
            189 | [3:3, 7:1]
            1225 | [5:2, 7:2]
            232321 | [47:1, 4943:1]
    }
}

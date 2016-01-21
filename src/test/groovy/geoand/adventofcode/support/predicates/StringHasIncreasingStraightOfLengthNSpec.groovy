package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 21/1/2016.
 */
class StringHasIncreasingStraightOfLengthNSpec extends Specification {

    final def predicate = new StringHasIncreasingStraightOfLengthN(3)

    @Unroll
    def "non matching"(String input) {
        expect:
            !predicate.test(input)

        where:
            input | _
            "" | _
            "ab" | _
            "abd" | _
            "abbcegjk" | _
            "abbceffg" | _
    }

    @Unroll
    def "matching"(String input) {
        expect:
            predicate.test(input)

        where:
            input | _
            "abc" | _
            "abcd" | _
            "dxyzd" | _
            "rqefgsdfgd" | _
            "abcdffaa" | _
            "ghjaabcc" | _

    }
}

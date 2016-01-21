package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 21/1/2016.
 */
class StringHasDifferentNonOverlappingPairsPredicateSpec extends Specification {

    final def predicate = new StringHasDifferentNonOverlappingPairsPredicate()

    @Unroll
    def "non matching"(String input) {
        expect:
            !predicate.test(input)

        where:
            input | _
            "" | _
            "a" | _
            "aa" | _
            "aaa" | _
            "aaab" | _
            "abab" | _
            "aaaa" | _
            "aafgab" | _
            "aafghjaa" | _
            "ieodomkazucvgmuy" | _
    }

    @Unroll
    def "matching"(String input) {
        expect:
            predicate.test(input)

        where:
            input | _
            "aabb" | _
            "aagfdbb" | _
            "baaqq" | _
            "aaqqf" | _
            "baadsfsdqqd" | _
            "abbceffg" | _
            "ghjaabcc" | _
            "abcdffaa" | _
    }
}

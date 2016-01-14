package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 14/1/2016.
 */
class StringHasNonOverlappingPairsPredicateSpec extends Specification {

    final def predicate = new StringHasNonOverlappingPairsPredicate()

    @Unroll
    def "non matching"(String input) {
        expect:
            !predicate.test(input)

        where:
            input | _
            "" | false
            "a" | false
            "aa" | false
            "aaa" | false
            "ieodomkazucvgmuy" | false
    }

    @Unroll
    def "matching"(String input) {
        expect:
            predicate.test(input)

        where:
            input | _
            "xyxy" | _
            "aabcdefgaa" | _
            "qjhvhtzxzqqjkmpb" | _
            "uurcxstgmygtbstg" | _
    }
}

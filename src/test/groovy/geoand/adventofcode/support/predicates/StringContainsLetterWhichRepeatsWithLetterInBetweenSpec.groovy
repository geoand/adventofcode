package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 15/1/2016.
 */
@Unroll
class StringContainsLetterWhichRepeatsWithLetterInBetweenSpec extends Specification {

    final def predicate = new StringContainsLetterWhichRepeatsWithLetterInBetween()

    def "matching"(String input) {
        expect:
            predicate.test(input)

        where:
            input | _
            "xyx" | _
            "abcdefeghi" | _
            "aaa" | _
            "qjhvhtzxzqqjkmpb" | _
            "ieodomkazucvgmuy" | _
    }

    def "non matching"(String input) {
        expect:
            !predicate.test(input)

        where:
            input | _
            "a" | _
            "aa" | _
            "abc" | _
            "uurcxstgmygtbstg" | _
    }
}

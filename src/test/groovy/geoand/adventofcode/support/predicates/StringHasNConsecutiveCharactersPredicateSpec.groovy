package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 14/1/2016.
 */
@Unroll
class StringHasNConsecutiveCharactersPredicateSpec extends Specification {

    final def twoCharacterPredicate = new StringHasNConsecutiveCharactersPredicate(2)
    final def threeCharacterPredicate = new StringHasNConsecutiveCharactersPredicate(3)

    def "matching two characters"(String input) {
        expect:
            twoCharacterPredicate.test(input)

        where:
            input | _
            "aa" | _
            "11" | _
            "aab" | _
            "aaa" | _
            "baab" | _
            "bcaab" | _
            "bcdabdda" | _
            "bcdabdaa" | _
            "ugknbfddgicrmopn" | _
    }

    def "non matching two characters"(String input) {
        expect:
            !twoCharacterPredicate.test(input)

        where:
            input | _
            "" | _
            "a" | _
            "a1" | _
            "bab" | _
            "abcd" | _
            "abab" | _
            "ababa" | _
    }

    def "matching three characters"(String input) {
        expect:
            threeCharacterPredicate.test(input)

        where:
            input | _
            "aaa" | _
            "111" | _
            "aaab" | _
            "aaaa" | _
            "baaab" | _
            "bcaaab" | _
            "bcdabddda" | _
            "bcdabddaddd" | _
    }

    def "non matching three characters"(String input) {
        expect:
            !threeCharacterPredicate.test(input)

        where:
            input | _
            "" | _
            "a" | _
            "aa" | _
            "a1" | _
            "aa1" | _
            "bab" | _
            "bbabb" | _
            "abcd" | _
            "abcde" | _
            "abab" | _
            "ababa" | _
            "ababab" | _
            "aabaa" | _
            "aabaabb" | _
    }
}

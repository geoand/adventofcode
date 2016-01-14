package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 14/1/2016.
 */
@Unroll
class StringHasAtLeastNVowelsPredicateSpec extends Specification {

    final def onePredicate = new StringHasAtLeastNVowelsPredicate(1)
    final def threePredicates = new StringHasAtLeastNVowelsPredicate(3)

    def "1 vowel"(String input, boolean expectedResult) {
        expect:
            onePredicate.test(input) == expectedResult

        where:
            input | expectedResult
            "" | false
            "b" | false
            "a" | true
            "e" | true
            "i" | true
            "o" | true
            "u" | true
            "bc" | false
            "ab" | true
            "bcd" | false
            "bcde" | true
            "bcdo" | true
    }

    def "3 vowels"(String input, boolean expectedResult) {
        expect:
            threePredicates.test(input) == expectedResult

        where:
            input | expectedResult
            "" | false
            "b" | false
            "a" | false
            "e" | false
            "bc" | false
            "aou" | true
            "abodu" | true
            "bcd" | false
            "bcde" | false
            "abicdo" | true
            "aeiou" | true
            "ugknbfddgicrmopn" | true
    }
}

package geoand.adventofcode.support.glue.nextpassword

import geoand.adventofcode.support.predicates.StringDoesNotContainPredicate
import geoand.adventofcode.support.predicates.StringHasDifferentNonOverlappingPairsPredicate
import geoand.adventofcode.support.predicates.StringHasIncreasingStraightOfLengthN
import spock.lang.Specification

/**
 * Created by gandrianakis on 21/1/2016.
 */
class NextStringGeneratorSpec extends Specification {

    final NextStringGenerator generator = new NextStringGenerator(
            new StringDoesNotContainPredicate('i', 'o', 'l')
            .and(new StringHasDifferentNonOverlappingPairsPredicate())
            .and(new StringHasIncreasingStraightOfLengthN(3))
    )

    def "generate"(String initial, String expected) {
        expect:
            generator.generate(initial) == expected

        where:
            initial | expected
            "abcdefgh" | "abcdffaa"
            "ghijklmn" | "ghjaabcc"
    }
}

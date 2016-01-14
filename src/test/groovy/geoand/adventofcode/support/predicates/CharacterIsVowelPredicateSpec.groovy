package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 14/1/2016.
 */
@Unroll
class CharacterIsVowelPredicateSpec extends Specification {

    final def predicate = new CharacterIsVowelPredicate()

    def "is vowel"(Character input) {
        expect:
            predicate.test(input)

        where:
            input | _
            'a' | _
            'e' | _
            'i' | _
            'o' | _
            'u' | _
    }

    def "is not vowel" (Character input) {
        expect:
            !predicate.test(input)

        where:
            input | _
            'b' | _
            'c' | _
            'd' | _
            'f' | _
            'x' | _
            'y' | _
            'z' | _
    }
}

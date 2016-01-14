package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 14/1/2016.
 */
class StringDoesNotContainSpec extends Specification {

    final def predicate = new StringDoesNotContainPredicate("ab", "cd", "pq", "xy")

    @Unroll
    def "test"(String input, boolean expectedResult) {
        expect:
            predicate.test(input) == expectedResult

        where:
            input | expectedResult
            "ugknbfddgicrmopn" | true
            "aaa" | true
            "haegwjzuvuyypxyu" | false
            "abcd" | false
            "testxty" | true
            "testxy" | false
    }
}

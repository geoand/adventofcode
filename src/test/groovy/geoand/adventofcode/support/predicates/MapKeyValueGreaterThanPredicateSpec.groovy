package geoand.adventofcode.support.predicates

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 26/1/2016.
 */
class MapKeyValueGreaterThanPredicateSpec extends Specification {

    @Unroll
    def "fails on missing key"(Map map, boolean expected) {
        given:
            final MapKeyValueGreaterThanPredicate<String, Integer> predicate = new MapKeyValueGreaterThanPredicate<>('key1', 1, true)

        expect:
            predicate.test(map) == expected

        where:
            map | expected
            [:] | false
            [key1: 2] | true
            [key2: 2] | false
            [key1: 0, key2: 2] | false
            [key1: 1] | false
            [key1: 1, key2: 2] | false
            [key1: 2, key2: 2] | true
    }

    @Unroll
    def "passes on missing key"(Map map, boolean expected) {
        given:
            final MapKeyValueGreaterThanPredicate<String, Integer> predicate = new MapKeyValueGreaterThanPredicate<>('key1', 1, false)

        expect:
            predicate.test(map) == expected

        where:
            map | expected
            [:] | true
            [key1: 2] | true
            [key2: 2] | true
            [key1: 0, key2: 2] | false
            [key1: 1] | false
            [key1: 1, key2: 2] | false
            [key1: 2, key2: 2] | true
    }
}

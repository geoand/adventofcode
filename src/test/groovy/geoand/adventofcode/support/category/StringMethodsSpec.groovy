package geoand.adventofcode.support.category

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by gandrianakis on 18/1/2016.
 */
class StringMethodsSpec extends Specification {

    @Unroll
    def "saveSize"(String input, int expectedSize) {
        expect:
            StringMethods.saveSize(input) == expectedSize

        where:
            input | expectedSize
            /"\""/ | 1
            /""/ | 0
            /"abc"/ | 3
            /"aaa\"aaa"/ | 7
            /"\x27"/ | 1
            /"\xa8br\x8bjr\""/ | 7
            /"e\\f\\mm\\ji"/ | 9
            /"u\x43nr\\\\br\"i"/ | 10
            /"a\\\""/ | 3
            /"a\\\\\""/ | 4
            /"\\\\"/ | 2
            /"q\"\"lfdentjgd\\"/ | 13
            /"nxzo\"hf\xp"/ | 10
    }

    @Unroll
    def "charIncrement"(String input, String expectedOutput) {
        expect:
            StringMethods.charIncrement(input) == expectedOutput

        where:
            input | expectedOutput
            "a" | "b"
            "z" | "aa"
            "za" | "zb"
            "zz" | "aaa"
            "aaa" | "aab"
            "abz" | "aca"
            "abcdezzz" | "abcdfaaa"
    }
}

package geoand.adventofcode.support.glue.lookandsay

import spock.lang.Specification

/**
 * Created by gandrianakis on 20/1/2016.
 */
class ConverterSpec extends Specification {

    def "convert"(String input, String expectedResult) {
        expect:
            Converter.convert(input) == expectedResult

        where:
            input | expectedResult
            "" | ""
            "1" | "11"
            "11" | "21"
            "21" | "1211"
            "1211" | "111221"
            "111221" | "312211"
    }
}

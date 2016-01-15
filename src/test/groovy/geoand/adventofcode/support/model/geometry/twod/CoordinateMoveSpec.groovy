package geoand.adventofcode.support.model.geometry.twod

import geoand.adventofcode.support.model.geometry.twod.Coordinate
import spock.lang.Specification

/**
 * Created by gandrianakis on 14/1/2016.
 */
class CoordinateMoveSpec extends Specification {

    def "erroneous input"(String input) {
        given:
            final def coordinate = Coordinate.start()

        when:
            coordinate.move(input)

        then:
            thrown IllegalArgumentException

        where:
            input | _
            "" | _
            "-" | _
            ")" | _
            "(" | _
            "~" | _
    }

    def "correct input"(String input, Coordinate expectedCoordinate) {
        given:
            final def coordinate = Coordinate.start()

        when:
            final def newCoordinate = coordinate.move(input)

        then:
            newCoordinate == expectedCoordinate

        where:
            input | expectedCoordinate
            ">" | new Coordinate(1,0)
            "v" | new Coordinate(0,-1)
            "<" | new Coordinate(-1,0)
            "^" | new Coordinate(0,1)
    }
}

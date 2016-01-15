package geoand.adventofcode.support.model.geometry.threed

import spock.lang.Specification

/**
 * Created by gandrianakis on 13/1/2016.
 */
class RectangleFromStringInputSpec extends Specification {

    def "invalid input"(String input) {
        when:
            Rectangle.fromStringInput(input)

        then:
            thrown IllegalArgumentException

        where:
            input | _
            "" | _
            "1" | _
            "1x2" | _
            "1x2xa" | _
            "1-2-3" | _
    }

    def "valid input"(String input, Rectangle expectedRectangle) {
        expect:
            Rectangle.fromStringInput(input) == expectedRectangle

        where:
            input | expectedRectangle
            "1x1x1" | new Rectangle(1,1,1)
            "1x2x3" | new Rectangle(1,2,3)
            "1x20x300" | new Rectangle(1,20,300)
    }
}

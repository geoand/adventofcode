package geoand.adventofcode.support.glue.cookie

import geoand.adventofcode.support.model.cookie.Ingredient
import spock.lang.Specification

/**
 * Created by gandrianakis on 25/1/2016.
 */
class CalculatorSpec extends Specification {

    def "calculate Butterscotch and Cinnamon"() {
        given:
            final def calculator = PartOneCalculator.of([new Ingredient('Butterscotch', -1, -2, 6, 3, 8), new Ingredient('Cinnamon', 2, 3, -2, -1, 3)])

        expect:
            calculator.calculate(['Butterscotch': 44, 'Cinnamon': 56]) == 62842880l
    }
}

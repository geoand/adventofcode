package geoand.adventofcode.support.glue.cookie

import geoand.adventofcode.support.model.cookie.Ingredient
import spock.lang.Specification

/**
 * Created by gandrianakis on 25/1/2016.
 */
class MatchingCaloriesCalculatorSpec extends Specification {

    final def calculator = MatchingCaloriesCalculator.of([new Ingredient('Butterscotch', -1, -2, 6, 3, 8), new Ingredient('Cinnamon', 2, 3, -2, -1, 3)], 500)

    def "calculate Butterscotch and Cinnamon with non matching calories"() {
        expect:
            calculator.calculate(['Butterscotch': 44, 'Cinnamon': 56]) == 0l
    }

    def "calculate Butterscotch and Cinnamon with matching calories"() {
        expect:
            calculator.calculate(['Butterscotch': 40, 'Cinnamon': 60]) == 57600000l
    }
}

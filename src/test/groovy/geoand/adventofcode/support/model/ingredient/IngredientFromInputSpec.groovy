package geoand.adventofcode.support.model.ingredient

import spock.lang.Specification

/**
 * Created by George Andrianakis on 24/1/2016.
 */
class IngredientFromInputSpec extends Specification {

    def "valid input"() {
        when:
            final Ingredient ingredient = Ingredient.fromInput("Sprinkles: capacity -3, durability 3, flavor 0, texture 0, calories 9")

        then:
            with(ingredient) {
                name == 'Sprinkles'
                durability == 3
                flavor == 0
                texture == 0
                calories == 9
            }

    }
}

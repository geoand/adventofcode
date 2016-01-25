package geoand.adventofcode.support.model.ingredient

import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

/**
 * Created by gandrianakis on 25/1/2016.
 */
class IngredientIntValueMapNoCaloriesSpec extends Specification {

    def "only int fields added and the negative fields transformed to 0"() {
        given:
            final def ingredient = new Ingredient("test", 1, 2, 0, -1, 10)

        when:
            final def map = ingredient.intValueMapNoCalories()

        then:
            assertThat(map).containsOnlyKeys("capacity", "durability", "flavor", "texture")
            map.capacity == 1
            map.durability == 2
            map.flavor == 0
            map.texture == 0
    }
}

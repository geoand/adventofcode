package geoand.adventofcode.support.glue.cookie

import geoand.adventofcode.support.model.ingredient.Ingredient

/**
 * Created by gandrianakis on 25/1/2016.
 */
abstract class CalculatorFactory {

    static partOne(Collection<Ingredient> ingredients) {
        return PartOneCalculator.of(ingredients)
    }
}

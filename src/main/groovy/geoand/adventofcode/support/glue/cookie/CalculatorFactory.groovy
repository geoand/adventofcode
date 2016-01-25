package geoand.adventofcode.support.glue.cookie

import geoand.adventofcode.support.model.cookie.Ingredient

/**
 * Created by gandrianakis on 25/1/2016.
 */
abstract class CalculatorFactory {

    static partOne(Collection<Ingredient> ingredients) {
        return AllNonCaloriesCalculator.of(ingredients)
    }

    static partTwo(Collection<Ingredient> ingredients, Integer matchingCalories) {
        return MatchingCaloriesCalculator.of(ingredients, matchingCalories)
    }
}

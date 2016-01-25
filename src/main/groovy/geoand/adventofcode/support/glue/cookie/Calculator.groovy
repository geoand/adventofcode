package geoand.adventofcode.support.glue.cookie

import geoand.adventofcode.support.model.ingredient.Ingredient

/**
 * Created by gandrianakis on 25/1/2016.
 */
interface Calculator {

    Set<Ingredient> getIngredients()

    public <T extends Number> Long calculate(Map<String, T> ingredientNameToCountMap)

}
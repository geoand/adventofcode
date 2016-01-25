package geoand.adventofcode.support.glue.cookie

import geoand.adventofcode.support.model.cookie.Ingredient

/**
 * Created by gandrianakis on 25/1/2016.
 */
class PartOneCalculator implements Calculator {

    final Set<Ingredient> ingredientsSet

    private final Map<String, Map<String, Integer>> ingredientPropertyToNameToValueMap
    private final Set<String> ingredientProperties

    private PartOneCalculator(Set<Ingredient> ingredients) {

        this.ingredientsSet = ingredients

        ingredientPropertyToNameToValueMap = ingredients.inject([:]) { Map<String, Map<String, Integer>> resultMap, Ingredient ingredient ->
            final propertyToValueMap = ingredient.intValueMapNoCalories()

            propertyToValueMap.collectEntries {propertyName, value ->
                final Map propertyMap = resultMap.getOrDefault(propertyName, [:])
                [(propertyName): propertyMap + [(ingredient.name): value]]
            }
        }

        ingredientProperties = ingredientPropertyToNameToValueMap.keySet()
    }

    static of(Collection<Ingredient> ingredients) {
        new PartOneCalculator(ingredients as Set)
    }

    @Override
    Set<Ingredient> getIngredients() {
        return ingredientsSet
    }

    public <T extends Number> Long calculate(Map<String, T> ingredientNameToCountMap) {
        return ingredientProperties.inject(1) { Long runningScore, String propertyName ->

            final def propertyScore =  (ingredientNameToCountMap.collect { String ingredientName, T count ->
                count * ingredientPropertyToNameToValueMap[propertyName][ingredientName]
            }.sum())

            runningScore * (propertyScore > 0 ? propertyScore : 0 )
        } as Long
    }
}

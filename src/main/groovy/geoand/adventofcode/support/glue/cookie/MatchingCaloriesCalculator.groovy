package geoand.adventofcode.support.glue.cookie

import geoand.adventofcode.support.model.cookie.Ingredient

/**
 * Created by gandrianakis on 25/1/2016.
 *
 * Returns
 */
class MatchingCaloriesCalculator extends AllNonCaloriesCalculator {

    final Map<String, Integer> caloriesMap
    final Integer matchingCalories

    private MatchingCaloriesCalculator(Set<Ingredient> ingredients, Integer matchingCalories) {
        super(ingredients)

        this.matchingCalories = matchingCalories
        caloriesMap = ingredients.collectEntries {[(it.name): it.calories]}
    }

    static of(Collection<Ingredient> ingredients, Integer matchingCalories) {
        new MatchingCaloriesCalculator(ingredients as Set, matchingCalories)
    }

    @Override
    public <T extends Number> Long calculate(Map<String, T> ingredientNameToCountMap) {
        final def totalCalories = ingredientNameToCountMap.collect{name, count -> count * caloriesMap[name]}.sum()

        return totalCalories == matchingCalories ? super.calculate(ingredientNameToCountMap) : 0
    }
}

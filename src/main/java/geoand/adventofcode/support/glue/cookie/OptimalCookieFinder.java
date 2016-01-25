package geoand.adventofcode.support.glue.cookie;

import geoand.adventofcode.support.model.ingredient.Ingredient;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by gandrianakis on 25/1/2016.
 */
public class OptimalCookieFinder {

    private final Calculator calculator;
    private final int size;

    public OptimalCookieFinder(Calculator calculator, int size) {
        this.calculator = calculator;
        this.size = size;
    }

    public Long highestScore() {
        final Stream<List<Ingredient>> combinationsStream = getCombinationsStream();


        return combinationsStream
                .map(ingredientCombination ->
                    ingredientCombination.stream().collect(Collectors.groupingBy(Ingredient::getName, Collectors.counting())) //create count map for each ingredient
                )
                .map(calculator::calculate)
                .max(Long::compare)
                .get();
    }

    private Stream<List<Ingredient>> getCombinationsStream() {
        ICombinatoricsVector<Ingredient> initialVector = Factory.createVector(calculator.getIngredients());
        Generator<Ingredient> gen = Factory.createMultiCombinationGenerator(initialVector, size);

        return StreamSupport.stream(gen.spliterator(), false).parallel().map(ICombinatoricsVector::getVector);
    }
}

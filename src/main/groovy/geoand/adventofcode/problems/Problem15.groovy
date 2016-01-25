package geoand.adventofcode.problems

import geoand.adventofcode.support.glue.cookie.CalculatorFactory
import geoand.adventofcode.support.glue.cookie.OptimalCookieFinder
import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.cookie.Ingredient

/**
 * Created by George Andrianakis on 24/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(15)

final List<Ingredient> ingredients = lines.collect {Ingredient.fromInput(it)}

/**
 * The problem is solvable by brute force since the number of combinations is C(100+4-1,100) = 176851
 */

println ((new OptimalCookieFinder(CalculatorFactory.partOne(ingredients), 100)).highestScore())

println ((new OptimalCookieFinder(CalculatorFactory.partTwo(ingredients, 500), 100)).highestScore())



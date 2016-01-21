package geoand.adventofcode.problems

import geoand.adventofcode.support.glue.nextpassword.NextStringGenerator
import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.predicates.StringDoesNotContainPredicate
import geoand.adventofcode.support.predicates.StringHasDifferentNonOverlappingPairsPredicate
import geoand.adventofcode.support.predicates.StringHasIncreasingStraightOfLengthN

import java.util.function.Predicate

/**
 * Created by gandrianakis on 21/1/2016.
 */

final String input = InputProviderFactory.inputProvider().getWhole(11)

final Predicate<String> predicate =
        new StringDoesNotContainPredicate('i', 'o', 'l')
        .and(new StringHasDifferentNonOverlappingPairsPredicate())
        .and(new StringHasIncreasingStraightOfLengthN(3))

final NextStringGenerator generator = new NextStringGenerator(predicate)
final String partOnePassword = generator.generate(input)

println partOnePassword

println generator.generate(partOnePassword)



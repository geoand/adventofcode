package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.predicates.StringContainsLetterWhichRepeatsWithLetterInBetween
import geoand.adventofcode.support.predicates.StringDoesNotContainPredicate
import geoand.adventofcode.support.predicates.StringHasAtLeastNVowelsPredicate
import geoand.adventofcode.support.predicates.StringHasNConsecutiveCharactersPredicate
import geoand.adventofcode.support.predicates.StringHasNonOverlappingPairsPredicate

import java.util.function.Predicate

/**
 * Created by gandrianakis on 14/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(5)

final Predicate<String> firstPartPredicate = new StringHasAtLeastNVowelsPredicate(3).and(new StringHasNConsecutiveCharactersPredicate(2)).and(new StringDoesNotContainPredicate("ab", "cd", "pq", "xy"))
final Predicate<String> secondPartPredicate = new StringHasNonOverlappingPairsPredicate().and(new StringContainsLetterWhichRepeatsWithLetterInBetween())

final List<List<Boolean>> testResults = lines.collect {[firstPartPredicate.test(it), secondPartPredicate.test(it)]}
println part(testResults, 0).count {it}
println part(testResults, 1).count {it}

List<Boolean> part(List<List<Boolean>> testResult, int index) {
    return testResult.collect {it[index]}
}
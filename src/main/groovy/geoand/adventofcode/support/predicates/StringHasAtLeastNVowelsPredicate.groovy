package geoand.adventofcode.support.predicates

import java.util.function.Predicate

/**
 * Created by gandrianakis on 14/1/2016.
 */
class StringHasAtLeastNVowelsPredicate implements Predicate<String>{

    final int number

    final def characterVowelPredicate = new CharacterIsVowelPredicate()

    StringHasAtLeastNVowelsPredicate(int number) {
        this.number = number
    }

    @Override
    boolean test(String s) {
        return s.toCharArray().collect {characterVowelPredicate.test(it)}.inject(0) {runningCount, isVowel -> isVowel ? runningCount + 1 : runningCount} >= number
    }
}

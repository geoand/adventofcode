package geoand.adventofcode.support.predicates

import geoand.adventofcode.support.category.ListMethods
import groovy.transform.CompileStatic

import java.util.function.Predicate

/**
 * Created by gandrianakis on 21/1/2016.
 */
@CompileStatic
class StringHasIncreasingStraightOfLengthN implements Predicate<String>{

    final int straightLength

    StringHasIncreasingStraightOfLengthN(int straightLength) {
        if(straightLength < 2) {
            throw new IllegalArgumentException("straightLength cannot be less that 2")
        }
        this.straightLength = straightLength
    }

    @Override
    boolean test(String s) {
        if(!s || s.length() < straightLength) {
            return false
        }

        final int windowLength = straightLength - 1

        ListMethods.collectWindow(s.toCharArray() as List<Character>, windowLength) { Character c, List<Character> window ->
            if(window.size() < windowLength) {
                return 0
            }


            final boolean anyOfPreviousNotInCorrectOrder = (1..windowLength).find { int index -> window[index-1] + index != (c as int) }
            return anyOfPreviousNotInCorrectOrder ? 0 : 1
        } //returns a list where each character corresponds to 1 if it's the end of a straight character sequence of length straightLength, and 0 otherwise
        .find {it > 0}

    }
}

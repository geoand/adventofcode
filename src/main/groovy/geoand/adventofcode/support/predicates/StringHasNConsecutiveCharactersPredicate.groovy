package geoand.adventofcode.support.predicates

import java.util.function.Predicate

/**
 * Created by gandrianakis on 14/1/2016.
 */
class StringHasNConsecutiveCharactersPredicate implements Predicate<String> {

    final int number

    StringHasNConsecutiveCharactersPredicate(int number) {
        if(number < 2) {
            throw new IllegalArgumentException("number must be greater or equal to 2")
        }
        this.number = number
    }

    @Override
    boolean test(String s) {
        return s =~ /(\w)${'\\1' * (number-1)}/
    }

}

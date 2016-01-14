package geoand.adventofcode.support.predicates

import java.util.function.Predicate

/**
 * Created by gandrianakis on 15/1/2016.
 */
class StringContainsLetterWhichRepeatsWithLetterInBetween implements Predicate<String> {

    @Override
    boolean test(String s) {
        return s =~ /(\w)(\w)\1/
    }
}

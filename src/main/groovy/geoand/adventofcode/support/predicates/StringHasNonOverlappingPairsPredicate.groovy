package geoand.adventofcode.support.predicates

import java.util.function.Predicate

/**
 * Created by gandrianakis on 14/1/2016.
 */
class StringHasNonOverlappingPairsPredicate implements Predicate<String> {


    @Override
    boolean test(String s) {
        if(s.length() < 4) {
            return false
        }

        return s =~ /(\w\w)(\w*)\1/
    }

}

package geoand.adventofcode.support.predicates

import java.util.function.Predicate
import java.util.regex.Matcher

/**
 * Created by gandrianakis on 14/1/2016.
 */
class StringHasDifferentNonOverlappingPairsPredicate implements Predicate<String> {


    @Override
    boolean test(String s) {
        if(s.length() < 4) {
            return false
        }

        final Matcher matcher = (s =~ /\w*(\w)\1\w*(\w)\2\w*/)
        if(1l == matcher.size()) {
            final def match = matcher[0]
            return match[1] != match[2]
        }

        return false
    }

}

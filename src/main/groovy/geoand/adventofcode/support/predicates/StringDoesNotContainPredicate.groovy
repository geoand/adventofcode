package geoand.adventofcode.support.predicates

import java.util.function.Predicate

/**
 * Created by gandrianakis on 14/1/2016.
 */
class StringDoesNotContainPredicate implements Predicate<String> {

    final String[] blacklist

    StringDoesNotContainPredicate(String... blacklist) {
        this.blacklist = blacklist
    }

    @Override
    boolean test(String s) {
        return !blacklist.any {s.contains(it)}
    }
}

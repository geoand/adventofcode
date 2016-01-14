package geoand.adventofcode.support.predicates

import java.util.function.Predicate

/**
 * Created by gandrianakis on 14/1/2016.
 */
class CharacterIsVowelPredicate implements Predicate<Character>{


    static final List<Character> VOWELS = ['a', 'e', 'i', 'o', 'u'].collect {it as char}

    @Override
    boolean test(Character character) {
        return VOWELS.contains(character)
    }
}

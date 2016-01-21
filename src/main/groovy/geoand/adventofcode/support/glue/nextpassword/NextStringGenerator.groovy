package geoand.adventofcode.support.glue.nextpassword

import geoand.adventofcode.support.category.StringMethods
import groovy.transform.CompileStatic
import groovy.transform.TailRecursive

import java.util.function.Predicate

/**
 * Created by gandrianakis on 21/1/2016.
 */
@CompileStatic
class NextStringGenerator {

    private final Predicate<String> predicate

    NextStringGenerator(Predicate<String> predicate) {
        if(!predicate) {
            throw new IllegalArgumentException("predicate cannot be null")
        }

        this.predicate = predicate
    }

    @TailRecursive
    String generate(String input) {
        final String next = StringMethods.charIncrement(input)
        return predicate.test(next) ? next : generate(next)
    }
}

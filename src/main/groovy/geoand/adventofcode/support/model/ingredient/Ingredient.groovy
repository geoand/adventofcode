package geoand.adventofcode.support.model.ingredient

import groovy.transform.Immutable
import groovy.transform.ToString

import java.util.regex.Matcher

/**
 * Created by George Andrianakis on 24/1/2016.
 */
@Immutable
@ToString(includePackage = false)
class Ingredient {

    String name

    int capacity
    int durability
    int flavor
    int texture
    int calories


    public static Ingredient fromInput(String input) {
        final Matcher matcher = (input =~ /(\w+):\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+)\s*/)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not in the expected format")
        }

        final def match = matcher[0]

        final Map constructorArg = (2..10).step(2).inject([name: match[1] as String]) {Map map, Integer index -> map + [(match[index]): (match[index + 1] as Integer) ] }

        return new Ingredient(constructorArg)
    }


}

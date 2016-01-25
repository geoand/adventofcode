package geoand.adventofcode.support.model.ingredient

import groovy.transform.Immutable
import groovy.transform.ToString

import java.lang.reflect.Field
import java.util.function.Predicate
import java.util.regex.Matcher

/**
 * Created by George Andrianakis on 24/1/2016.
 */
@Immutable
@ToString(includePackage = false)
class Ingredient {

    String name

    Integer capacity
    Integer durability
    Integer flavor
    Integer texture
    Integer calories


    public static Ingredient fromInput(String input) {
        final Matcher matcher = (input =~ /(\w+):\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+),\s+(\w+)\s+([+-]?\d+)\s*/)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not in the expected format")
        }

        final def match = matcher[0]

        final Map constructorArg = (2..10).step(2).inject([name: match[1] as String]) {Map map, Integer index -> map + [(match[index]): (match[index + 1] as Integer) ] }

        return new Ingredient(constructorArg)
    }

    private Map valueMap(Predicate<Field> predicate) {
        final Predicate<Field> finalPredicate = predicate.and({!it.synthetic})

        this.class.declaredFields.findAll { finalPredicate.test(it) }.collectEntries {
            [(it.name): this."$it.name"]
        }
    }

    Map intValueMapNoCalories() {
        return valueMap(({it.name != 'calories'} as Predicate<Field>).and({Number.isAssignableFrom(it.type)}))
    }
}

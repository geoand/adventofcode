package geoand.adventofcode.support.model.aunt

import java.util.regex.Matcher

/**
 * Created by gandrianakis on 26/1/2016.
 */
class Aunt {

    final Integer id
    final Map<String, Integer> attributes

    private Aunt(Integer id, Map<String, Integer> attributes) {
        this.id = id
        this.attributes = attributes
    }

    static Aunt fromInput(String input) {
        final Matcher matcher = (input =~ /(\w+)\s+(\d+):\s+(\w+)\s*:\s*(\d+),\s+(\w+)\s*:\s*(\d+),\s+(\w+)\s*:\s*(\d+)/)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not in the expected format")
        }

        final def match = matcher[0]

        final Integer id = match[2] as Integer
        final Map<String,Integer> attributes = (3..8).step(2).collectEntries {[(match[it] as String): match[it+1] as Integer]}

        return new Aunt(id, attributes)
    }
}

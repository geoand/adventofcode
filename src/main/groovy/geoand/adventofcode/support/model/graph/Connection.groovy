package geoand.adventofcode.support.model.graph

import java.util.regex.Matcher

/**
 * Created by gandrianakis on 19/1/2016.
 */
class Connection {

    final String from
    final String to
    final double weight

    private Connection(String from, String to, double weight) {
        this.from = from
        this.to = to
        this.weight = weight
    }

    static Connection fromInput(String input) {
        final String regex = /(\w+)\s+to\s+(\w+)\s+=\s+(\d+)/
        final Matcher matcher = (input =~ regex)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not is the expected format")
        }

        final def match = matcher[0]

        return new Connection(match[1] as String, match[2] as String, match[3] as double)
    }

    static List<Connection> fromInputWithReverse(String input) {
        final Connection forward = fromInput(input)
        return [forward, forward.reverse()]
    }

    Connection reverse() {
        return new Connection(to, from, weight)
    }
}


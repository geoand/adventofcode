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

    static Connection fromProblem9Input(String input) {
        final Matcher matcher = (input =~ /(\w+)\s+to\s+(\w+)\s+=\s+(\d+)/)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not is the expected format")
        }

        final def match = matcher[0]

        return new Connection(match[1] as String, match[2] as String, match[3] as double)
    }


    static Connection fromProblem13Input(String input) {
        final Matcher matcher = (input =~ /(\w+)\s+would\s+(gain|lose)\s+(\d+)\s+happiness\s+units\s+by\s+sitting\s+next\s+to\s+(\w+)./)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not is the expected format")
        }

        final def match = matcher[0]

        return new Connection(match[1] as String, match[4] as String, ((match[3] as double) * (match[2] == 'gain' ? 1 : -1)))
    }

    static Connection zeroWeight(String from, String to) {
        return new Connection(from, to, 0)
    }
}


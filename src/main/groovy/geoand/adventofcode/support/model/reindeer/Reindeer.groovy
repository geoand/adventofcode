package geoand.adventofcode.support.model.reindeer

import groovy.transform.Memoized
import groovy.transform.PackageScope

import java.util.regex.Matcher

/**
 * Created by gandrianakis on 22/1/2016.
 */
class Reindeer {

    final String name
    final int speed
    final int flightDuration
    final int restDuration

    //visible for testing
    @PackageScope
    Reindeer(String name, int speed, int flightDuration, int restDuration) {
        this.name = name
        this.speed = speed
        this.flightDuration = flightDuration
        this.restDuration = restDuration
    }

    static Reindeer fromInput(String input) {
        final Matcher matcher = (input =~ /(\w+)\s+can\s+fly\s+(\d+)\s+km\/s\s+for\s+(\d+)\s+seconds,\s+but\s+then\s+must\s+rest\s+for\s+(\d+)\s+seconds./)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not is the expected format")
        }

        final def match = matcher[0]

        return new Reindeer(match[1] as String, match[2] as int, match[3] as int, match[4] as int)
    }

    @Memoized
    int distanceCovered(int seconds) {
        final int numberOfCompletedCycles = seconds / (flightDuration + restDuration)
        final int numberOfSecondsInCurrentCycle = seconds % (flightDuration + restDuration)

        return speed * (numberOfCompletedCycles * flightDuration + (numberOfSecondsInCurrentCycle <= flightDuration ? numberOfSecondsInCurrentCycle : flightDuration))

    }
}

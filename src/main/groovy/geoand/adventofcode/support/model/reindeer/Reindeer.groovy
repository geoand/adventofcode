package geoand.adventofcode.support.model.reindeer

import groovy.transform.CompileStatic
import groovy.transform.Memoized
import groovy.transform.PackageScope
import groovy.transform.ToString

import java.util.regex.Matcher

/**
 * Created by gandrianakis on 22/1/2016.
 */
@ToString(includes = 'name', includePackage = false)
class Reindeer {

    final String name
    final Integer speed
    final Integer flightDuration
    final Integer restDuration

    //visible for testing
    @PackageScope
    Reindeer(String name, Integer speed, Integer flightDuration, Integer restDuration) {
        this.name = name
        this.speed = speed
        this.flightDuration = flightDuration
        this.restDuration = restDuration
    }

    static Reindeer fromInput(String input) {
        final Matcher matcher = (input =~ /(\w+)\s+can\s+fly\s+(\d+)\s+km\/s\s+for\s+(\d+)\s+seconds,\s+but\s+then\s+must\s+rest\s+for\s+(\d+)\s+seconds./)
        if(matcher.size() != 1) {
            throw new IllegalArgumentException("input '${input}' was not in the expected format")
        }

        final def match = matcher[0]

        return new Reindeer(match[1] as String, match[2] as int, match[3] as int, match[4] as int)
    }

    @Memoized
    @CompileStatic
    Integer distanceCovered(Integer seconds) {
        final Integer numberOfCompletedCycles = seconds.intdiv(flightDuration + restDuration) as Integer
        final Integer numberOfSecondsInCurrentCycle = seconds % (flightDuration + restDuration)

        return speed * (numberOfCompletedCycles * flightDuration + (numberOfSecondsInCurrentCycle <= flightDuration ? numberOfSecondsInCurrentCycle : flightDuration))
    }
}

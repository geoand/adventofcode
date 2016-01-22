package geoand.adventofcode.support.model.reindeer

import spock.lang.Specification

/**
 * Created by gandrianakis on 22/1/2016.
 */
class ReindeerFromInputSpec extends Specification {

    def "Comet"() {
        when:
            final def comet = Reindeer.fromInput("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.")

        then:
            comet.name == 'Comet'
            comet.speed == 14
            comet.flightDuration == 10
            comet.restDuration == 127
    }
}

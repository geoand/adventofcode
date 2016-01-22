package geoand.adventofcode.support.model.reindeer

import spock.lang.Specification

/**
 * Created by gandrianakis on 22/1/2016.
 */
class ReindeerDistanceCoveredSpec extends Specification {

    def "Comet"() {
        given:
            final def comet = new Reindeer('Comet', 14, 10, 127)

        expect:
            comet.distanceCovered(1000) == 1120
    }

    def "Dancer"() {
        given:
            final def comet = new Reindeer('Dancer', 16, 11, 162)

        expect:
            comet.distanceCovered(1000) == 1056
    }
}

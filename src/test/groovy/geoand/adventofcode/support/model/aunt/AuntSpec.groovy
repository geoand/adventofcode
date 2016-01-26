package geoand.adventofcode.support.model.aunt

import org.assertj.core.api.Assertions
import spock.lang.Specification

import java.util.AbstractMap.SimpleEntry as Entry

/**
 * Created by gandrianakis on 26/1/2016.
 */
class AuntSpec extends Specification {

    def "fromInput with valid input"() {
        when:
            final Aunt aunt = Aunt.fromInput('Sue 123: goldfish: 6, trees: 9, akitas: 0')

        then:
            aunt.id == 123
            Assertions.assertThat(aunt.attributes).containsExactly(
                    new Entry<String, Integer>('goldfish', 6),
                    new Entry<String, Integer>('trees', 9),
                    new Entry<String, Integer>('akitas', 0)
            )
    }
}

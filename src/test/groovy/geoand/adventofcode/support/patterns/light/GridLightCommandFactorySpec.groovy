package geoand.adventofcode.support.patterns.light

import geoand.adventofcode.support.model.light.PartOneGridLight
import org.assertj.core.api.Assertions
import spock.lang.Specification

/**
 * Created by gandrianakis on 15/1/2016.
 */
class GridLightCommandFactorySpec extends Specification {

    private GridLightCommandFactory factory =
            new GridLightCommandFactory(
                    [
                            [new PartOneGridLight(0,0), new PartOneGridLight(0,1), new PartOneGridLight(0,2)],
                            [new PartOneGridLight(1,0), new PartOneGridLight(1,1), new PartOneGridLight(1,2)],
                            [new PartOneGridLight(2,0), new PartOneGridLight(2,1), new PartOneGridLight(2,2)]
                    ]
            )

    def "erroneous command"() {
        expect:
            factory.create("toggle1 461,550 through 564,900").isEmpty()
    }

    def "missing start coordinates"() {
        expect:
            factory.create("toggle through 564,900").isEmpty()
    }

    def "missing end coordinates"() {
        expect:
            factory.create("toggle 461,550 through ").isEmpty()
    }

    def "correct toggle command"() {
        expect:
            Assertions.assertThat(factory.create("toggle 1,1 through 2,2")).containsOnly(toggleCommand(1,1), toggleCommand(1,2), toggleCommand(2,1), toggleCommand(2,2))
    }

    def "correct turn-off command"() {
        expect:
            Assertions.assertThat(factory.create("turn off 0,0 through 2,0")).containsOnly(turnOffCommand(0,0), turnOffCommand(1,0), turnOffCommand(2,0))
    }

    def "correct turn-on command"() {
        expect:
            Assertions.assertThat(factory.create("turn on 1,1 through 1,2")).containsOnly(turnOnCommand(1,1), turnOnCommand(1,2))
    }

    private GridLightToggleCommand toggleCommand(int xPos, int yPos) {
        return new GridLightToggleCommand(new PartOneGridLight(xPos, yPos))
    }

    private GridLightTurnOffCommand turnOffCommand(int xPos, int yPos) {
        return new GridLightTurnOffCommand(new PartOneGridLight(xPos, yPos))
    }

    private GridLightTurnOnCommand turnOnCommand(int xPos, int yPos) {
        return new GridLightTurnOnCommand(new PartOneGridLight(xPos, yPos))
    }

}

package geoand.adventofcode.support.model.light

import geoand.adventofcode.support.model.geometry.twod.Coordinate
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by gandrianakis on 15/1/2016.
 */
@EqualsAndHashCode(includes = ['coordinate'])
@ToString(includePackage = false, includeFields=true, includes = ['coordinate', 'state'])
@CompileStatic
class PartOneGridLight implements GridLight<PartOneGridLight>{

    enum State {
        OFF,
        ON

        State toggle() {
            return this == OFF ? ON : OFF
        }
    }

    //not used for querying, but can be used if needed
    private final Coordinate coordinate

    private State state = State.OFF

    PartOneGridLight(int xPos, int yPos) {
        this(new Coordinate(xPos, yPos))
    }

    PartOneGridLight(Coordinate coordinate) {
        this.coordinate = coordinate
    }

    PartOneGridLight turnOn() {
        state = State.ON
        return this
    }

    PartOneGridLight turnOff() {
        state = State.OFF
        return this
    }

    PartOneGridLight toggle() {
        state = state.toggle()
        return this
    }
}

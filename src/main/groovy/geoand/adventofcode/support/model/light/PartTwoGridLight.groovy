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
class PartTwoGridLight implements GridLight<PartTwoGridLight>{

    private int brightness = 0

    //not used for querying, but can be used if needed
    private final Coordinate coordinate

    PartTwoGridLight(int xPos, int yPos) {
        this(new Coordinate(xPos, yPos))
    }

    PartTwoGridLight(Coordinate coordinate) {
        this.coordinate = coordinate
    }

    PartTwoGridLight turnOn() {
        brightness++
        return this
    }

    PartTwoGridLight turnOff() {
        if(brightness > 0) {
            brightness--
        }
        return this
    }

    PartTwoGridLight toggle() {
        brightness += 2
        return this
    }
}

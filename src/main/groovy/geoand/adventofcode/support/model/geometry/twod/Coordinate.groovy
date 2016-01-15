package geoand.adventofcode.support.model.geometry.twod

import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import groovy.transform.ToString

/**
 * Created by gandrianakis on 14/1/2016.
 */
@EqualsAndHashCode
@Sortable
@ToString(includePackage = false)
class Coordinate {

    final int xPos
    final int yPos

    Coordinate(int xPos, int yPos) {
        this.xPos = xPos
        this.yPos = yPos
    }

    static Coordinate start() {
        return new Coordinate(0, 0)
    }

    Coordinate move(String input) {
        switch (input) {
            case "^":
                return moveNorth()
            case ">":
                return moveEast()
            case "v":
                return moveSouth()
            case "<":
                return moveWest()
            default:
                throw new IllegalArgumentException("Symbol provided to method is not allowed")
        }
    }

    Coordinate moveEast() {
        return new Coordinate(xPos + 1, yPos)
    }

    Coordinate moveWest() {
        return new Coordinate(xPos -1, yPos)
    }

    Coordinate moveNorth() {
        return new Coordinate(xPos, yPos + 1)
    }

    Coordinate moveSouth() {
        return new Coordinate(xPos, yPos -1)
    }
}

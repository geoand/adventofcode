package geoand.adventofcode.support.glue.gridlight

/**
 * Created by George Andrianakis on 28/1/2016.
 */
enum State {

    ON(1),
    OFF(0)

    State(int intValue) {
        this.intValue = intValue
    }


    final int intValue

}
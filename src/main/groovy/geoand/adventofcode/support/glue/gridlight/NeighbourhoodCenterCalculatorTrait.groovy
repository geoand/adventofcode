package geoand.adventofcode.support.glue.gridlight

import groovy.transform.CompileStatic

/**
 * Created by George Andrianakis on 29/1/2016.
 */
@CompileStatic
trait NeighbourhoodCenterCalculatorTrait {

    State calculate(Neighbourhood neighbourhood) {
        final State initialState = neighbourhood.center()
        final int neighboursOn = neighbourhood.intValueSumIgnoreCenter()
        if(initialState == State.OFF) {
            return 3 ==  neighboursOn ? State.ON : State.OFF
        }
        else {
            return (2 == neighboursOn) || (3 == neighboursOn) ? State.ON : State.OFF
        }
    }

}
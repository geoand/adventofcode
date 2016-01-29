package geoand.adventofcode.support.glue.gridlight

import groovy.transform.CompileStatic


/**
 * Created by George Andrianakis on 28/1/2016.
 */
@CompileStatic
class PartTwoStateCalculator implements StateCalculator, NeighbourhoodCenterCalculatorTrait {

    @Override
    State calculateCentralsNewState(Neighbourhood neighbourhood, int y, int x, int size) {
        if((x == 1 && y == 1)
          || (x == 1 && y == size)
          || (x == size && y == 1)
          || (x == size && y == size)) {
            return State.ON
        }

        return calculate(neighbourhood)
    }
}

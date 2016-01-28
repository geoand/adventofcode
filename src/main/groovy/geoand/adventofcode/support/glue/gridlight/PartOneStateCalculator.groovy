package geoand.adventofcode.support.glue.gridlight

import groovy.transform.CompileStatic


/**
 * Created by George Andrianakis on 28/1/2016.
 */
@CompileStatic
class PartOneStateCalculator implements StateCalculator, NeighbourhoodCenterCalculatorTrait {

    @Override
    State calculateCentralsNewState(Neighbourhood neighbourhood, int y, int x, int size) {
        calculate(neighbourhood)
    }
}

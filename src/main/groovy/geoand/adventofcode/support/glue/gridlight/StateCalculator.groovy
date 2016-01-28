package geoand.adventofcode.support.glue.gridlight

/**
 * Created by George Andrianakis on 28/1/2016.
 */
interface StateCalculator {

    State calculateCentralsNewState(Neighbourhood neighbourhood, int y, int x, int totalSize)

}
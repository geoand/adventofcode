package geoand.adventofcode.support.glue.gridlight

import groovy.transform.CompileStatic

/**
 * Created by George Andrianakis on 28/1/2016.
 */
class OnLightCounter {

    final StateCalculator stateCalculator

    OnLightCounter(StateCalculator stateCalculator) {
        this.stateCalculator = stateCalculator
    }

    int count(List<List<State>> grid, int steps) {
        final int size = grid.size()

        List<List<State>> finalConfiguration = (1..steps).inject(gridWithSurrounding(grid)) {List<List<State>> currentConfiguration, int step ->
            gridWithSurrounding((1..size).collect {int yPos ->
                (1..size).collect {int xPos -> stateCalculator.calculateCentralsNewState(Neighbourhood.fromGrid(currentConfiguration, 3, yPos, xPos), yPos, xPos, size)}
            })
        }

        return finalConfiguration.flatten().collect { State state -> state.intValue}.sum() as int
    }

    @CompileStatic
    private List<List<State>> gridWithSurrounding(List<List<State>> grid) {
        [wholeSurroundingLine(grid)] +
        grid.collect {line -> [State.OFF] + line + [State.OFF]} +
        [wholeSurroundingLine(grid)]
    }

    @CompileStatic
    private List<State> wholeSurroundingLine(List<List<State>> grid) {
        (0..grid.size()+1).collect {State.OFF}
    }
}

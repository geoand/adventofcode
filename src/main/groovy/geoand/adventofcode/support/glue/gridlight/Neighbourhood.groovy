package geoand.adventofcode.support.glue.gridlight

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

/**
 * Created by George Andrianakis on 28/1/2016.
 */
@CompileStatic
class Neighbourhood {

    private final Integer size
    private final List<List<State>> neighbourhoodGrid


    private Neighbourhood(List<List<State>> neighbourhoodGrid, int size) {
        this.neighbourhoodGrid = neighbourhoodGrid
        this.size = size
    }

    static Neighbourhood fromGrid(List<List<State>> totalGrid, int size, int y, int x) {
        if(!totalGrid) {
            throw new IllegalArgumentException('totalGrid cannot be empty')
        }

        if(size < 0 || size % 2 == 0) {
            throw new IllegalArgumentException('size must be a positive odd integer')
        }

        final Integer sizeDiv = (Integer)size.intdiv(2)

        return new Neighbourhood(
                (-sizeDiv..sizeDiv).collect{ yOffset ->
                    (-sizeDiv..sizeDiv).collect {xOffset ->
                        totalGrid[y+yOffset][x+xOffset]
                    }
                }
                ,size
        )
    }

    @CompileDynamic
    int intValueSumIgnoreCenter() {
        return neighbourhoodGrid.flatten().collect {it.intValue}.sum() + (center().intValue == 1 ? -1 : 0)
    }


    State center() {
        final Integer midIndex = (Integer)size.intdiv(2)
        return neighbourhoodGrid[midIndex][midIndex]
    }
}

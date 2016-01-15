package geoand.adventofcode.support.patterns.light

import geoand.adventofcode.support.model.light.GridLight
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by gandrianakis on 15/1/2016.
 */
@ToString(includePackage = false, includeSuper = true)
@EqualsAndHashCode(callSuper = true)
@CompileStatic
class GridLightTurnOffCommand<T extends GridLight<T>> extends AbstractGridLightCommand<T> {

    GridLightTurnOffCommand(T gridLight) {
        super(gridLight)
    }

    @Override
    void execute() {
        gridLight.turnOff()
    }
}

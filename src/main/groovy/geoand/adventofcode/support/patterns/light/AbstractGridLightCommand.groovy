package geoand.adventofcode.support.patterns.light

import geoand.adventofcode.support.model.light.GridLight
import geoand.adventofcode.support.patterns.Command
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by gandrianakis on 15/1/2016.
 */
@ToString(includePackage = false, includeFields=true, includes = ['gridLight'])
@EqualsAndHashCode
abstract class AbstractGridLightCommand<T extends GridLight<T>> implements Command<T> {

    protected final T gridLight

    AbstractGridLightCommand(T gridLight) {
        this.gridLight = gridLight
    }
}

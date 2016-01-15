package geoand.adventofcode.support.model.light

/**
 * Created by gandrianakis on 15/1/2016.
 */
interface GridLight<T extends GridLight<T>> {

    T turnOn()

    T turnOff()

    T toggle()
}
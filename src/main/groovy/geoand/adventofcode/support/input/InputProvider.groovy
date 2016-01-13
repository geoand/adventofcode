package geoand.adventofcode.support.input

/**
 * Created by gandrianakis on 13/1/2016.
 */
interface InputProvider {

    String getWhole(int problem)

    List<String> getLines(int problem)
}
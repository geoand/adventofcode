package geoand.adventofcode.support.input

/**
 * Created by gandrianakis on 13/1/2016.
 */
class FileInputProvider implements InputProvider {

    @Override
    String get(int problem) {
        if(!(1..30).contains(problem)) {
            throw new IllegalArgumentException('The problem number is not correct')
        }

        return this.getClass().getResource("/problem${problem}.in").text
    }
}

package geoand.adventofcode.support.input

/**
 * Created by gandrianakis on 13/1/2016.
 */
class FileInputProvider implements InputProvider {

    @Override
    String getWhole(int problem) {
        if(!(1..30).contains(problem)) {
            throw new IllegalArgumentException('The problem number is not correct')
        }

        return getURL(problem).text
    }

    @Override
    List<String> getLines(int problem) {
        return new File(getURL(problem).file).readLines()
    }

    private URL getURL(int problem) {
        this.getClass().getResource("/problem${problem}.in")
    }
}

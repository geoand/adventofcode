package geoand.adventofcode.support.extension

/**
 * Created by gandrianakis on 13/1/2016.
 */
@Category(String)
class StringCategory {

    List<String> toList() {
        return this.toCharArray().collect{new String(it)}
    }
}

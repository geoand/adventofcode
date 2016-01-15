package geoand.adventofcode.problems

import geoand.adventofcode.support.category.ListMethods
import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.geometry.twod.Coordinate

/**
 * Created by gandrianakis on 14/1/2016.
 */


final def sanitizedInput = InputProviderFactory.inputProvider().getWhole(3).toList().findAll { it in ["^", ">", "v", "<"] }

/**
 * 1. From the list of input characters create a list of coordinate objects by appending each corresponding Coordinate to the list
 * 2. Based on that list, create a map containing each distinct Coordinate as the key, and the number of occurrences as the value
 * 3. Count the values of the map that are greater than 1
 */
println houseCount(houseCoordinates(sanitizedInput))

final def splitLists = splitEvenOdd(sanitizedInput)
final def santaInput = splitLists[0]
final def roboSantaInput = splitLists[1]

println houseCount(houseCoordinates(santaInput) + houseCoordinates(roboSantaInput))

List<Coordinate> houseCoordinates(List<String> input) {
    return input.inject([Coordinate.start()]) {list, character ->
        list + [list[-1].move(character)]
    }
}

int houseCount(List<Coordinate> houseCoordinates) {
    return houseCoordinates.countBy {it}.count {key, value -> value >= 1}
}

List<List<String>> splitEvenOdd(List<String> input) {
    use(ListMethods) {
        return input.splitWithIndex {entry, i -> i % 2 == 0 }
    }
}
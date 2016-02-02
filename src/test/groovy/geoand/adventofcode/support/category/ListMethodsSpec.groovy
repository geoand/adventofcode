package geoand.adventofcode.support.category

import spock.lang.Specification

/**
 * Created by gandrianakis on 29/1/2016.
 */
class ListMethodsSpec extends Specification{

    def "indexCollate list of normal size"() {
        given:
            final list = [1, 2, 3, 4, 5]
        expect:
            ListMethods.indexCollate(list, -1) == [[], [1, 2, 3, 4, 5]]
            ListMethods.indexCollate(list, 0) == [[], [2, 3, 4, 5]]
            ListMethods.indexCollate(list, 1) == [[1], [3, 4, 5]]
            ListMethods.indexCollate(list, 2) == [[1, 2], [4, 5]]
            ListMethods.indexCollate(list, 3) == [[1, 2, 3], [5]]
            ListMethods.indexCollate(list, 4) == [[1, 2, 3, 4], []]
            ListMethods.indexCollate(list, 5) == [[1, 2, 3, 4, 5], []]
    }

    def "indexCollate single element list"() {
        given:
            final list = [1]
        expect:
            ListMethods.indexCollate(list, -1) == [[],[1]]
            ListMethods.indexCollate(list, 0) == [[],[]]
            ListMethods.indexCollate(list, 1) == [[1],[]]
    }

    def "indexCollate list with two elements"() {
        given:
            final list = [1, 2]
        expect:
            ListMethods.indexCollate(list, -1) == [[],[1, 2]]
            ListMethods.indexCollate(list, 0) == [[],[2]]
            ListMethods.indexCollate(list, 1) == [[1],[]]
            ListMethods.indexCollate(list, 2) == [[1, 2],[]]
            ListMethods.indexCollate(list, 3) == [[1, 2],[]]
    }
}

package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import groovy.json.JsonSlurper

/**
 * Created by gandrianakis on 21/1/2016.
 */

final String input = InputProviderFactory.inputProvider().getWhole(12)

final def object = new JsonSlurper().parseText(input)

println new SumCalculator().sum(object)
println new MapFilteringSumCalculator('red').sum(object)


class SumCalculator {

    int sum(Map map) {
        if(!map) {
            return 0
        }
        return sum(map.values())
    }

    int sum(Collection list) {
        return list.collect { sum(it) }.sum()
    }

    int sum(Number num) {
        return num
    }

    int sum(String s) {
        return 0
    }

}

class MapFilteringSumCalculator extends SumCalculator{

    final List<String> blacklistValues

    MapFilteringSumCalculator(String... blacklistValues) {
        this.blacklistValues = blacklistValues
    }

    int sum(Map map) {

        if(blacklistValues.find {blacklistValue -> map?.values()?.contains(blacklistValue)}) {
            return 0
        }

        return super.sum(map)
    }

}

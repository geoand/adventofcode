package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.geometry.twod.Coordinate
import geoand.adventofcode.support.model.light.GridLight
import geoand.adventofcode.support.model.light.PartOneGridLight
import geoand.adventofcode.support.model.light.PartTwoGridLight
import geoand.adventofcode.support.patterns.light.GridLightCommandFactory

import java.util.function.BiFunction
import java.util.function.Supplier


final List<String> lines = InputProviderFactory.inputProvider().getLines(6)

/**
 * Part One
 */

final List<List<PartOneGridLight>> partOneGridLights = Dummy.createGrid({xPos, yPos -> new PartOneGridLight(xPos, yPos)})
final GridLightCommandFactory partOneCommandFactory = new GridLightCommandFactory(partOneGridLights)

performCommands(lines, partOneCommandFactory)

println partOneGridLights.flatten().count {it.state == PartOneGridLight.State.ON}

/**
 * Part Two
 */

final List<List<PartTwoGridLight>> partTwoGridLights = Dummy.createGrid({xPos, yPos -> new PartTwoGridLight(xPos, yPos)})
final GridLightCommandFactory partTwoCommandFactory = new GridLightCommandFactory(partTwoGridLights)

performCommands(lines, partTwoCommandFactory)

println partTwoGridLights.flatten().sum {it.brightness}


void performCommands(List<String> lines, commandFactory) {
    def allCommands = lines.collectMany { commandFactory.create(it) }
    allCommands.each { it.execute() }
}

/**
 * Only exists because I could not find a way to add generics to a function of the script
 */
class Dummy {

    public static <T extends GridLight<T>> List<List<T>> createGrid(BiFunction<Integer, Integer, T> supplier) {
        return (0..999).collect { xPos -> (0..999).collect { yPos -> supplier.apply(xPos, yPos) }}
    }
}

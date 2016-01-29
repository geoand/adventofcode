package geoand.adventofcode.problems

import geoand.adventofcode.support.glue.gridlight.OnLightCounter
import geoand.adventofcode.support.glue.gridlight.PartOneStateCalculator
import geoand.adventofcode.support.glue.gridlight.PartTwoStateCalculator
import geoand.adventofcode.support.glue.gridlight.State
import geoand.adventofcode.support.input.InputProviderFactory

/**
 * Created by George Andrianakis on 28/1/2016.
 */

final int STEPS = 100

final List<String> lines = InputProviderFactory.inputProvider().getLines(18)

final List<List<State>> initialConfiguration = lines.collect{ line -> line.toList().collect { light -> light == '#' ? State.ON : State.OFF}}


final OnLightCounter partOne = new OnLightCounter(new PartOneStateCalculator())
println partOne.count(initialConfiguration, STEPS)

final OnLightCounter partTwo = new OnLightCounter(new PartTwoStateCalculator())
println partTwo.count(setCornerValues(initialConfiguration), STEPS)

private List<List<State>> setCornerValues(List<List<State>> initialConfiguration) {
    final List<State> newFirstLine = changeFirstAndLastElements(initialConfiguration.head(), State.ON)
    final List<State> newLastLine = changeFirstAndLastElements(initialConfiguration.last(), State.ON)

    [newFirstLine] + initialConfiguration.tail().init() + [newLastLine]
}

private List<State> changeFirstAndLastElements(List<State> states, State value) {
    return [value] + states.tail().init() + [value]
}


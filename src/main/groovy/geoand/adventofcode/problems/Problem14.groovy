package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.reindeer.Reindeer

/**
 * Created by gandrianakis on 22/1/2016.
 */

final int RUNNING_TIME = 2503

final List<String> lines = InputProviderFactory.inputProvider().getLines(14)

println lines
        .collect {Reindeer.fromInput(it)}
        .max {it.distanceCovered(RUNNING_TIME)}
        .distanceCovered(RUNNING_TIME)




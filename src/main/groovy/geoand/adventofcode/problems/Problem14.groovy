package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.reindeer.Reindeer
import groovy.transform.PackageScope

import java.util.regex.Matcher

/**
 * Created by gandrianakis on 22/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(14)

println lines.collect {Reindeer.fromInput(it)}.max {Reindeer a, Reindeer b -> a.distanceCovered(2503) <=> b.distanceCovered(2053)}.distanceCovered(2053)






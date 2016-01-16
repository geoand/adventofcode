package geoand.adventofcode.problems

import geoand.adventofcode.support.glue.gates.Combiner
import geoand.adventofcode.support.glue.gates.LineToCombineArgsConverter
import geoand.adventofcode.support.glue.gates.Registry
import geoand.adventofcode.support.input.InputProviderFactory

/**
 * Created by George Andrianakis on 16/1/2016.
 */

final Registry registry = new Registry()
final Combiner combiner = new Combiner(registry)
final LineToCombineArgsConverter lineToCombineArgsConverter = new LineToCombineArgsConverter()

final List<String> lines = InputProviderFactory.inputProvider().getLines(7)

lines.collect {lineToCombineArgsConverter.convert(it)}.each {combiner.combine(*it)}

/**
 * Hack
 * TODO find a better way to re-initiate the process
 */

def partOneValue
registry.getOrCreate('a').subscribe {partOneValue = it} .unsubscribe()
println partOneValue

registry.clear()

lines.collect {lineToCombineArgsConverter.convert(it)}.collect{(it[0] instanceof Integer && 'b' == it[1]) ? [partOneValue, 'b']: it}.each {combiner.combine(*it)}
registry.getOrCreate('a').subscribe {println it}



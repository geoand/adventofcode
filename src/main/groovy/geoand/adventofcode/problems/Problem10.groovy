package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory

import static geoand.adventofcode.support.glue.lookandsay.Converter.convert

/**
 * Created by gandrianakis on 20/1/2016.
 */

final String input = InputProviderFactory.inputProvider().getWhole(10)


final String firstConversion = convert(input)


final String partOneResult = (2..40).inject(firstConversion) { String converted, int index -> convert(converted) }
println(partOneResult.length())


println( ((1..10).inject(partOneResult) { String converted, int index -> convert(converted) }).length())



package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.math.FactorSum

/**
 * Created by gandrianakis on 3/2/2016.
 */

final Integer input = (InputProviderFactory.inputProvider().getWhole(20) as Integer)

/**
 * The first thing to note is that we can ignore the multiplication by 10 of each number
 * and correspondingly divide the input by 10
 * The basic idea is to calculate the sum of factors of each number until we find a number
 * whose sum is greater or equal to the input divided by 10
 */

final Integer inputIgnoringMultiplication = input / 10

println ((2..inputIgnoringMultiplication).find {FactorSum.perform(it) >= inputIgnoringMultiplication})
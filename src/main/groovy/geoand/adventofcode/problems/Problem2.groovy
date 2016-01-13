package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.Rectangle

/**
 * Created by gandrianakis on 13/1/2016.
 */

def rectangles = InputProviderFactory.inputProvider().getLines(2).collect { Rectangle.fromStringInput(it) }

println rectangles.collect {it.surfaceArea() + it.smallestSideArea()}.sum()
println rectangles.collect {it.volume() + it.smallestSideAPerimeter()}.sum()



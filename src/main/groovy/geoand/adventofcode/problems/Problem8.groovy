package geoand.adventofcode.problems

import geoand.adventofcode.support.category.StringMethods
import geoand.adventofcode.support.input.InputProviderFactory

/**
 * Created by gandrianakis on 18/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(8)

use(StringMethods) {
//    println lines.collect {it.size() - it.saveSize()}.sum()
    println lines.collect {it.encodedSize() - it.size()}.sum()
}

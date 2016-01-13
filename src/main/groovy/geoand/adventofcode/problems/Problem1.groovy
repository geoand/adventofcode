package geoand.adventofcode.problems

import geoand.adventofcode.support.extension.StringCategory
import geoand.adventofcode.support.input.InputProviderFactory

/**
 * Created by gandrianakis on 13/1/2016.
 */

use(StringCategory) {
    final def sanitizedInput = InputProviderFactory.inputProvider().get(1).toList().findAll { it in ["(", ")"] }

    println sanitizedInput.collect(this.&value).sum()

    /**
     * Produce the sum in each step of the way by appending to the list
     * the sum of the value of the character and the value of the last item in the list
     */
    println sanitizedInput.inject([0]) {list, character ->
        list + [(list[-1] + value(character))]
    }.findIndexOf {it == -1}

}

int value(String input) {
    return "(" == input  ? 1 : -1
}
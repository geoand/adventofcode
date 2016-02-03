package geoand.adventofcode.support.math

import groovy.transform.CompileStatic

/**
 * Created by gandrianakis on 3/2/2016.
 */
@CompileStatic
abstract class FactorSum {

    /**
     * Uses the algorithm described at http://mathforum.org/library/drmath/view/71550.html
     * This method is far more efficient than finding all factors and then summing them
     */
    static Integer perform(Integer input) {
        PrimeFactorization.perform(input)
                .collect { key, value -> powersSum(key, value)}
                .inject(1){ Integer currentProduct, Integer value -> currentProduct*value} as Integer
    }

    private static Integer powersSum(Integer num, Integer count) {
        return ((0..count).collect {Integer power -> num**power}.sum() as Integer)
    }
}

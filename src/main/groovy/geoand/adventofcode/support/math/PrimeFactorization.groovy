package geoand.adventofcode.support.math

import groovy.transform.CompileStatic
import org.apache.commons.math3.primes.Primes

/**
 * Created by gandrianakis on 3/2/2016.
 */
@CompileStatic
abstract class PrimeFactorization {

    /**
     * Originally implemented my own solution using inject and recursion, but was atrociously slow for large numbers
     * probably due to it's immutable nature
     */
    static Map<Integer, Integer> perform(Integer input) {
        return Primes.primeFactors(input).countBy {it}
    }

}

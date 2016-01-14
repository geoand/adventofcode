package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.security.SecurityUtils

/**
 * Created by gandrianakis on 14/1/2016.
 */

final String secret = InputProviderFactory.inputProvider().getWhole(4)


println matchingHash(secret, '00000')
println matchingHash(secret, '000000')

String matchingHash(String secret, String startsWith) {
    return (1..Integer.MAX_VALUE).find {SecurityUtils.generateMD5("${secret}${it}").startsWith(startsWith)}
}
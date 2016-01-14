package geoand.adventofcode.support.security

import groovy.transform.CompileStatic

import java.security.MessageDigest

/**
 * Created by gandrianakis on 14/1/2016.
 */
@CompileStatic
abstract class SecurityUtils {

    static String generateMD5(String input) {
        return MessageDigest.getInstance("MD5").digest(input.bytes).encodeHex().toString()
    }

}
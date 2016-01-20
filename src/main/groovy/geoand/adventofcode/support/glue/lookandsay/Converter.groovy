package geoand.adventofcode.support.glue.lookandsay

import java.util.regex.Matcher

/**
 * Created by gandrianakis on 20/1/2016.
 */
abstract class Converter {

    static String convert(String input) {
        if(!input) {
            return ''
        }

        final Matcher matcher = (input =~ /(\d)\1*/)
        return matcher.collect {it[0]}.collect {"${it.length()}${it[0]}"}.join('')
    }

}

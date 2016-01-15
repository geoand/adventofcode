package geoand.adventofcode.support.glue.gates

import rx.functions.Func2

/**
 * Created by George Andrianakis on 16/1/2016.
 */
class LineToCombineArgsConverter {

    static final AND_REGEX = /([a-z]+)\s+AND\s+([a-z]+)\s+->\s+([a-z]+)/
    static final AND_STATIC_REGEX = /(\d+)\s+AND\s+([a-z]+)\s+->\s+([a-z]+)/
    static final OR_REGEX = /([a-z]+)\s+OR\s+([a-z]+)\s+->\s+([a-z]+)/
    static final LEFT_SHIFT_REGEX = /([a-z]+)\s+LSHIFT\s+(\d+)\s+->\s+([a-z]+)/
    static final RIGHT_SHIFT_REGEX = /([a-z]+)\s+RSHIFT\s+(\d+)\s+->\s+([a-z]+)/
    static final NOT_REGEX = /NOT\s+([a-z]+)\s+->\s+([a-z]+)/
    static final VALUE_ASSIGN_REGEX = /(\d+)\s+->\s+([a-z]+)/
    static final VAR_ASSIGN_REGEX = /(\w+)\s+->\s+([a-z]+)/


    List convert(String line) {
        switch (line) {
            case ~AND_REGEX:
                final def matcher = getMatcher(line, AND_REGEX)
                return [matcher[1], matcher[2], matcher[3], {a,b -> a & b} as Func2]
            case ~AND_STATIC_REGEX:
                final def matcher = getMatcher(line, AND_STATIC_REGEX)
                return [matcher[2], matcher[1] as int, matcher[3], {a,b -> a & b} as Func2]
            case ~OR_REGEX:
                final def matcher = getMatcher(line, OR_REGEX)
                return [matcher[1], matcher[2], matcher[3], {a,b -> a | b} as Func2]
            case ~LEFT_SHIFT_REGEX:
                final def matcher = getMatcher(line, LEFT_SHIFT_REGEX)
                return [matcher[1], matcher[2] as int, matcher[3], {a,b -> a << b} as Func2]
            case ~RIGHT_SHIFT_REGEX:
                final def matcher = getMatcher(line, RIGHT_SHIFT_REGEX)
                return [matcher[1], matcher[2] as int, matcher[3], {a,b -> a >> b} as Func2]
            case ~NOT_REGEX:
                final def matcher = getMatcher(line, NOT_REGEX)
                return [matcher[1],  matcher[2], { a, b -> ~a > 0 ?: ~a + 65536} as Func2]
            case ~VALUE_ASSIGN_REGEX:
                final def matcher = getMatcher(line, VALUE_ASSIGN_REGEX)
                return [matcher[1] as int, matcher[2]]
            case ~VAR_ASSIGN_REGEX:
                final def matcher = getMatcher(line, VAR_ASSIGN_REGEX)
                return [matcher[1], matcher[2], { a, b -> a} as Func2]
            default:
                throw new IllegalStateException("The line $line could did not match by any of the predefined regexes")

        }
    }

    def getMatcher(String input, def regex) {
        return (input =~regex)[0]
    }
}

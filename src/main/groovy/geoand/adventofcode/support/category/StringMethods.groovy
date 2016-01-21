package geoand.adventofcode.support.category

import groovy.transform.CompileStatic
import groovy.transform.TailRecursive

/**
 * Created by gandrianakis on 18/1/2016.
 */
class StringMethods {

    static int saveSize(String self) {
        if(!self) {
            return 0
        }

        use(ListMethods) {
            final String nonQuotedString =  self.substring(1, self.size()-1)
            if(!nonQuotedString) {
                return 0
            }

            nonQuotedString.replaceAll(/\\x[0-9A-Fa-f][0-9A-Fa-f]/, 'U').replace("\\\\", 'S').replace("\\\"", "C").size()
        }
    }

    static int encodedSize(String self) {
        if(!self) {
            return 0
        }

        use(ListMethods) {
            self.replace('\\', '\\\\').replace('"', "\\\"").size() + 2
        }
    }


    static String charIncrement(String self) {
        return doCharIncrement(self, "")
    }

    @TailRecursive
    @CompileStatic
    private static String doCharIncrement(String self, String result) {
        if(!self) {
            return result
        }

        final String last = self[-1]
        final String nonLast = self.substring(0, self.size()-1)
        if('z' == last) {
            return doCharIncrement(nonLast, (nonLast ? 'a' : 'aa') + result)
        }

        return doCharIncrement('', nonLast + (((last as Character) + 1) as Character).toString() + result)
    }

}

package geoand.adventofcode.support.category
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

}

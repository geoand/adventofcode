package geoand.adventofcode.support.category

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam
import org.codehaus.groovy.runtime.callsite.BooleanClosureWrapper

/**
 * Created by gandrianakis on 14/1/2016.
 */
@Category(List)
class ListMethods {

    public <T> List<List<T>> splitWithIndex(@ClosureParams(FirstParam.FirstGenericType.class) Closure closure) {
        final List<T> accept = []
        final List<T> reject = []

        final BooleanClosureWrapper bcw = new BooleanClosureWrapper(closure)

        this.eachWithIndex { T entry, int i ->
            if (bcw.call(entry, i)) {
                accept.add(entry)
            } else {
                reject.add(entry)
            }
        }

        return [accept, reject]
    }
}

package geoand.adventofcode.support.category

import groovy.transform.CompileStatic
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam
import org.codehaus.groovy.runtime.callsite.BooleanClosureWrapper

/**
 * Created by gandrianakis on 14/1/2016.
 */
class ListMethods {

    @CompileStatic
    static public <T> List<List<T>> splitWithIndex(List<T> self, @ClosureParams(FirstParam.FirstGenericType.class) Closure closure) {
        final List<T> accept = []
        final List<T> reject = []

        final BooleanClosureWrapper bcw = new BooleanClosureWrapper(closure)

        for(int i=0 ; i<self.size(); i++) {
            final T entry = self[i]
            if (bcw.call(entry, i)) {
                accept.add(entry)
            } else {
                reject.add(entry)
            }
        }

        return [accept, reject]
    }

    /**
     * Same as collect with the addition that the closure has access to a second argument that is a list containing the previous windowSize elements is order of proximity
     * to the current list.
     * For example if list = [1,4,2,5,1] and windowSize is 3 then the arguments for each invocation of the closure would be:
     * [1, []]
     * [4, [1]]
     * [2, [4,1]]
     * [5, [2,4,1]]
     * [1, [5,2,4]]
     *
     */
    @CompileStatic
    public static <S,T> List<T> collectWindow(List<S> self, int windowSize, @ClosureParams(FirstParam.FirstGenericType.class) Closure<T> transform) {
        final List<T> collector = new ArrayList<>()

        for(int i=0 ; i<self.size(); i++) {
            collector.add(transform.call(self[i], windowList(self, windowSize, i)));
            if (transform.getDirective() == Closure.DONE) {
                break
            }
        }

        return collector
    }

    private static <T> List windowList(List<T> list, int windowSize, int index) {
        if(index >= windowSize) {
            return list.subList(index - windowSize, index).reverse()
        }
        else if(index > 0) {
            return list.subList(0, index).reverse()
        }

        return []
    }
}

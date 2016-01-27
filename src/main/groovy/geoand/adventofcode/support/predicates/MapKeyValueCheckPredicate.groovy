package geoand.adventofcode.support.predicates

import groovy.transform.CompileStatic

import java.util.function.BiFunction
import java.util.function.Predicate

/**
 * Created by gandrianakis on 27/1/2016.
 */
@CompileStatic
class MapKeyValueCheckPredicate<K,V> implements Predicate<Map<K, V>> {

    final BiFunction<? super V, ? super V, ? extends Boolean> checkFunction

    final boolean failOnMissingKey

    final K key
    final V value


    MapKeyValueCheckPredicate(BiFunction<? super V, ? super V, ? extends Boolean> checkFunction, K key, V value) {
        this(checkFunction, key, value, true)
    }

    MapKeyValueCheckPredicate(BiFunction<? super V, ? super V, ? extends Boolean> checkFunction, K key, V value, boolean failOnMissingKey) {
        this.checkFunction = checkFunction
        this.key = key
        this.value = value
        this.failOnMissingKey = failOnMissingKey
    }

    @Override
    boolean test(Map<K, V> map) {
        if(map.containsKey(key)) {
            return checkFunction.apply(map[key], value)
        }
        return !failOnMissingKey
    }
}

package geoand.adventofcode.support.predicates

import groovy.transform.CompileStatic

import java.util.function.Predicate

/**
 * Created by gandrianakis on 26/1/2016.
 */
@CompileStatic
class MapKeyValuePredicate<K,V> implements Predicate<Map<K, V>> {

    final boolean failOnMissingKey

    final K key
    final V value

    MapKeyValuePredicate(K key, V value) {
        this(key, value, true)
    }

    MapKeyValuePredicate(K key, V value, boolean failOnMissingKey) {
        this.key = key
        this.value = value
        this.failOnMissingKey = failOnMissingKey
    }

    @Override
    boolean test(Map<K, V> map) {
        if(map.containsKey(key)) {
            return map[key] == value
        }
        return !failOnMissingKey
    }
}

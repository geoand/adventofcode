package geoand.adventofcode.support.predicates

import java.util.function.Predicate

/**
 * Created by gandrianakis on 26/1/2016.
 */
class MapKeyValueEqualsPredicate<K,V> implements Predicate<Map<K, V>> {

    @Delegate
    final MapKeyValueCheckPredicate<K,V> delegate

    MapKeyValueEqualsPredicate(K key, V value, boolean failOnMissingKey) {
        delegate = new MapKeyValueCheckPredicate<K,V>({a,b -> a == b}, key, value, failOnMissingKey)
    }
}

package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.aunt.Aunt
import geoand.adventofcode.support.predicates.MapKeyValueEqualsPredicate
import geoand.adventofcode.support.predicates.MapKeyValueGreaterThanPredicate
import geoand.adventofcode.support.predicates.MapKeyValueLessThanPredicate
import groovy.transform.CompileStatic

import java.util.function.Predicate
import java.util.stream.Stream

/**
 * Created by George Andrianakis on 24/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(16)
final List<Aunt> aunts = lines.collect { Aunt.fromInput(it) }

final List<List<Object>> specs = [
        ['children', 3],
        ['cats', 7],
        ['samoyeds', 2],
        ['pomeranians', 3],
        ['akitas', 0],
        ['vizslas', 0],
        ['goldfish', 5],
        ['trees', 3],
        ['cars', 2],
        ['perfumes', 1],
]

println find(aunts, specs.collect {new AuntPartOnePredicate(it[0], it[1])})
println find(aunts, specs.collect {new AuntPartTwoPredicate(it[0], it[1])})

/**
 * construct a stream using the predicates above since the stream will efficiently perform each stage filtering
 * Could also have used predicate.and() to construct a single final predicate
 */
private String find(Collection<Aunt> aunts, Collection<Predicate<Aunt>> predicates) {
    final Stream<Aunt> auntStream = predicates.inject(aunts.stream()) { Stream<Aunt> stream, Predicate<Aunt> predicate -> stream.filter(predicate) }
    return auntStream.findFirst().get().id
}

@CompileStatic
class AuntPartOnePredicate implements Predicate<Aunt> {
    
    final Predicate<Map<String, Integer>> delegate

    AuntPartOnePredicate(String key, Integer value) {
        this.delegate = new MapKeyValueEqualsPredicate<String, Integer>(key, value, false)
    }

    @Override
    boolean test(Aunt aunt) {
        return delegate.test(aunt.attributes)
    }
}

class AuntPartTwoPredicate implements Predicate<Aunt> {

    private static final Map<String, Class> nameToPredicateClassMap = [
            'cats'       : MapKeyValueGreaterThanPredicate, 'trees': MapKeyValueGreaterThanPredicate,
            'pomeranians': MapKeyValueLessThanPredicate, 'goldfish': MapKeyValueLessThanPredicate
    ]

    final Predicate<Map<String, Integer>> delegate

    AuntPartTwoPredicate(String key, Integer value) {
        this.delegate = nameToPredicateClassMap.getOrDefault(key, MapKeyValueEqualsPredicate).metaClass.&invokeConstructor(key, value, false)
    }

    @CompileStatic
    @Override
    boolean test(Aunt aunt) {
        return delegate.test(aunt.attributes)
    }
}



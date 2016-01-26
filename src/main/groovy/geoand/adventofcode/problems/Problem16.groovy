package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.aunt.Aunt
import geoand.adventofcode.support.predicates.MapKeyValuePredicate
import groovy.transform.CompileStatic

import java.util.function.Predicate
import java.util.stream.Stream

/**
 * Created by George Andrianakis on 24/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(16)

final List<Aunt> aunts = lines.collect { Aunt.fromInput(it) }
final List<AuntPredicate> predicates = [
        new AuntPredicate('children', 3),
        new AuntPredicate('cats', 7),
        new AuntPredicate('samoyeds', 2),
        new AuntPredicate('pomeranians', 3),
        new AuntPredicate('akitas', 0),
        new AuntPredicate('vizslas', 0),
        new AuntPredicate('goldfish', 5),
        new AuntPredicate('trees', 3),
        new AuntPredicate('cars', 2),
        new AuntPredicate('perfumes', 1),
]

//construct a stream using the predicates above since the stream will efficiently perform each stage filtering
//Could also have used predicate.and() to construct a single final predicate
final Stream<Aunt> auntStream = predicates.inject(aunts.stream()) { Stream<Aunt> stream, AuntPredicate predicate -> stream.filter(predicate)}
println auntStream.findFirst().get().id


@CompileStatic
class AuntPredicate implements Predicate<Aunt> {
    
    final Predicate<Map<String, Integer>> delegate

    AuntPredicate(String key, Integer value) {
        this.delegate = new MapKeyValuePredicate<String, Integer>(key, value, false)
    }

    @Override
    boolean test(Aunt aunt) {
        return delegate.test(aunt.attributes)
    }
}


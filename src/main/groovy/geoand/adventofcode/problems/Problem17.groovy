package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import groovy.transform.CompileStatic
import groovy.transform.Memoized

/**
 * Created by George Andrianakis on 24/1/2016.
 */

final int SIZE = 150

final List<Integer> containerCapacities = InputProviderFactory.inputProvider().getLines(17).collect {Integer.valueOf(it)}

println count(SIZE, containerCapacities)

final Integer max = containerCapacities.max()
final Integer min = containerCapacities.min()
final Integer minimumContainers = (SIZE / max) + 1
final Integer maximumContainer = (SIZE / min) - 1

final Integer actualMinimumContainers = ((minimumContainers..maximumContainer).find{countMatchingSteps(SIZE, containerCapacities, it) > 0})
println countMatchingSteps(SIZE, containerCapacities, actualMinimumContainers)

/**
 * This algorithm is based on the fact that the count of each capacity
 * is equal to the sum of counts of that capacity minus each container capacity
 */


@CompileStatic
@Memoized
Integer count(Integer initialCapacity, Collection<Integer> containerCapacities) {
    if(initialCapacity == 0) {
        return 1
    }

    if((initialCapacity < 0) || !containerCapacities) {
        return 0
    }

    final Integer head = containerCapacities.head()
    final Collection<Integer> tail = containerCapacities.tail()

    return count(initialCapacity - head, tail) + count(initialCapacity, tail)
}


@CompileStatic
@Memoized
Integer countMatchingSteps(Integer initialCapacity, Collection<Integer> containerCapacities, Integer steps) {
    if((initialCapacity == 0) && (steps == 0)){
        return 1
    }

    if((initialCapacity < 0) || !containerCapacities) {
        return 0
    }

    final Integer head = containerCapacities.head()
    final Collection<Integer> tail = containerCapacities.tail()

    return countMatchingSteps(initialCapacity - head, tail, steps - 1) + countMatchingSteps(initialCapacity, tail, steps)
}


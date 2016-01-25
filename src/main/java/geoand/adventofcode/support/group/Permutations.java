package geoand.adventofcode.support.group;

import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by gandrianakis on 22/1/2016.
 *
 * see http://minborgsjavapot.blogspot.gr/2015/07/java-8-master-permutations.html
 */
public abstract class Permutations {

    public static <T> Stream<List<T>> of(Collection<T> items) {
        final List<T> itemList = new ArrayList<>(items);
        return LongStream.range(0, factorial(items.size()))
                .mapToObj(no -> permutation(no, itemList));
    }

    private static long factorial(int n) {
        if (n > 20 || n < 0) throw new IllegalArgumentException(n + " is out of range");
        return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }

    private static <T> List<T> permutation(long no, List<T> items) {
        return permutationHelper(no,
                new LinkedList<>(Objects.requireNonNull(items)),
                new ArrayList<>());
    }

    private static <T> List<T> permutationHelper(long no, LinkedList<T> in, List<T> out) {
        if (in.isEmpty()) return out;
        long subFactorial = factorial(in.size() - 1);
        out.add(in.remove((int) (no / subFactorial)));
        return permutationHelper((int) (no % subFactorial), in, out);
    }
}

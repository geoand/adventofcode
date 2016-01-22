package geoand.adventofcode.support.glue.graph;

import geoand.adventofcode.support.category.JGraphTWeightedGraphMethods;
import geoand.adventofcode.support.group.Permutations;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;
import java.util.function.Function;

/**
 * Created by gandrianakis on 22/1/2016.
 */
public abstract class GraphPermutations {

    public static <T> double maxPath(WeightedGraph<T, DefaultWeightedEdge> graph) {
        return maxPath(graph, Function.identity());
    }

    public static <T> double maxPath(WeightedGraph<T, DefaultWeightedEdge> graph, Function<List<T>, List<T>> permutationTransform) {
        return Permutations.of(graph.vertexSet()).parallel()
                .map(permutationTransform)
                .map(permutation -> JGraphTWeightedGraphMethods.getWeightOfWholePath(graph, permutation))
                .max(Double::compare)
                .get();
    }
}

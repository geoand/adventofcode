package geoand.adventofcode.support.category

import groovy.transform.CompileStatic
import org.jgrapht.WeightedGraph

/**
 * Created by gandrianakis on 19/1/2016.
 */
class JGraphTWeightedGraphMethods {

    @CompileStatic
    static <V, E> E addEdge(WeightedGraph<V, E> self, V sourceVertex, V targetVertex, double weight) {
        self.addVertex(sourceVertex)
        self.addVertex(targetVertex)

        final def result = self.addEdge(sourceVertex, targetVertex)
        self.setEdgeWeight(result, weight)

        return result
    }

    @CompileStatic
    static <V, E> double getEdgeWeightValue(WeightedGraph<V, E> self, V sourceVertex, V targetVertex) {
        final def edge = self.getEdge(sourceVertex, targetVertex)
        if(edge) {
            return self.getEdgeWeight(edge)
        }

        throw new IllegalArgumentException("No edge exists between $sourceVertex and $targetVertex")
    }

    @CompileStatic
    static <V, E> double getWeightOfWholePath(WeightedGraph<V, E> self, List<V> vertices) {
        return ListMethods.collectWindow(vertices, 1) { V current, List<V> window ->
            if(!window) {
                return 0
            }

            return getEdgeWeightValue(self, window[0], current)
        }.sum() as double
    }
}

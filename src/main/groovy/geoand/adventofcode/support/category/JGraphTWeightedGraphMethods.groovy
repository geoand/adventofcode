package geoand.adventofcode.support.category

import groovy.transform.CompileStatic
import org.jgrapht.WeightedGraph

/**
 * Created by gandrianakis on 19/1/2016.
 */
class JGraphTWeightedGraphMethods {

    private static class AddEdgeResult<E> {

        final E edge
        final boolean newEdge

        AddEdgeResult(E edge, boolean newEdge) {
            this.edge = edge
            this.newEdge = newEdge
        }
    }

    @CompileStatic
    static <V, E> E addEdge(WeightedGraph<V, E> self, V sourceVertex, V targetVertex, double weight) {
        addEdge(self, sourceVertex, targetVertex, weight, {a, b -> b})
    }

    @CompileStatic
    static <V, E> E addEdge(WeightedGraph<V, E> self, V sourceVertex, V targetVertex, double weight, Closure<Double> weightCombine) {
        self.addVertex(sourceVertex)
        self.addVertex(targetVertex)

        final AddEdgeResult<E> addEdgeResult = addEdgeSafe(self, sourceVertex, targetVertex)
        final double previousEdgeWeight = addEdgeResult.newEdge ? 0 : self.getEdgeWeight(addEdgeResult.edge)
        self.setEdgeWeight(addEdgeResult.edge, weightCombine.call(previousEdgeWeight, weight))

        return addEdgeResult.edge
    }

    @CompileStatic
    private static <V, E> AddEdgeResult<E> addEdgeSafe(WeightedGraph<V, E> self, V sourceVertex, V targetVertex) {
        final def addResult = self.addEdge(sourceVertex, targetVertex)
        if(addResult) {
            return new AddEdgeResult<E>(addResult, true)
        }

        return new AddEdgeResult<E>(self.getEdge(sourceVertex, targetVertex), false)
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

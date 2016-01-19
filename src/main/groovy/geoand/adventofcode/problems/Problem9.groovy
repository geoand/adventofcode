package geoand.adventofcode.problems

import geoand.adventofcode.support.category.JGraphTWeightedGraphMethods
import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.graph.Connection
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.SimpleWeightedGraph

/**
 * Created by gandrianakis on 19/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(9)

final List<Connection> connections = lines.collect {Connection.fromInput(it)}


use(JGraphTWeightedGraphMethods) {
    final SimpleWeightedGraph<String, DefaultWeightedEdge> graph = connections.inject(new SimpleWeightedGraph(DefaultWeightedEdge)) {g, conn -> g.addEdge(conn.from, conn.to, conn.weight); return g}

    /**
     * This is a super naive implementation that will not scale at all!!!
     */

    final double min = Double.MAX_VALUE
    final double max = Double.MIN_VALUE

    //not using .permutation().collect().min()/.max() because the number of permutation is huge
    graph.vertexSet().eachPermutation {
        try {
            final double weightOfWholePath = graph.getWeightOfWholePath(it)
            if(min > weightOfWholePath) {
                min = weightOfWholePath
            }
            if(max < weightOfWholePath) {
                max = weightOfWholePath
            }
        } catch (IllegalArgumentException e) {}
    }

    println min as int
    println max as int
}


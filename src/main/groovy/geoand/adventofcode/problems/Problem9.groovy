package geoand.adventofcode.problems

import geoand.adventofcode.support.category.JGraphTWeightedGraphMethods
import geoand.adventofcode.support.glue.graph.GraphPermutations
import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.graph.Connection
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.SimpleWeightedGraph

/**
 * Created by gandrianakis on 19/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(9)

final List<Connection> connections = lines.collect {Connection.fromProblem9Input(it)}



use(JGraphTWeightedGraphMethods) {
    final SimpleWeightedGraph<String, DefaultWeightedEdge> graph = connections.inject(new SimpleWeightedGraph(DefaultWeightedEdge)) {g, conn -> g.addEdge(conn.from, conn.to, conn.weight); return g}

    /**
     * This is a super naive implementation that will not scale at all!!!
     * It works for this problem because the problem is brute-force able
     * due to the small input size
     */

    final DoubleSummaryStatistics summaryStatistics = GraphPermutations.summaryStatistics(graph)
    println summaryStatistics.min as int
    println summaryStatistics.max as int
}


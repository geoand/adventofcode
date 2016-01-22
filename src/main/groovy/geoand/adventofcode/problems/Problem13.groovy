package geoand.adventofcode.problems

import geoand.adventofcode.support.category.JGraphTWeightedGraphMethods
import geoand.adventofcode.support.glue.graph.GraphPermutations
import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.graph.Connection
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.SimpleWeightedGraph

/**
 * Created by gandrianakis on 22/1/2016.
 */

final List<String> lines = InputProviderFactory.inputProvider().getLines(13)

final List<Connection> partOneConnections = lines.collect {Connection.fromProblem13Input(it)}




use(JGraphTWeightedGraphMethods) {
    final SimpleWeightedGraph<String, DefaultWeightedEdge> partOneGraph = graph(partOneConnections)


    /**
     * This is a super naive implementation that will not scale at all!!!
     */

    println calculate(partOneGraph)

    final List<Connection> partTwoConnections = partOneConnections + partOneGraph.vertexSet().collect {Connection.zeroWeight('geo', it)}

    println calculate(graph(partTwoConnections))
}

private int calculate(SimpleWeightedGraph<String, DefaultWeightedEdge> partOneGraph) {
    GraphPermutations.maxPath(partOneGraph, { list -> list + list.head() })
}

private SimpleWeightedGraph<String, DefaultWeightedEdge> graph(List<Connection> connections) {
    use(JGraphTWeightedGraphMethods) {
        return connections.inject(new SimpleWeightedGraph(DefaultWeightedEdge)) { g, conn -> g.addEdge(conn.from, conn.to, conn.weight, { a, b -> a + b }); return g }
    }
}

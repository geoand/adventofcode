package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.reindeer.Reindeer

/**
 * Created by gandrianakis on 22/1/2016.
 */

final int RUNNING_TIME = 2503

final List<String> lines = InputProviderFactory.inputProvider().getLines(14)

final List<Reindeer> reindeerList = lines .collect { Reindeer.fromInput(it) }
println reindeerList.collect {it.distanceCovered(RUNNING_TIME)}.max()



final List<Integer> initialScores = (1..reindeerList.size()).collect { 0 }
println (((1..RUNNING_TIME).inject(initialScores) { List<Integer> runningScores, int time ->
    final distanceListForTime = reindeerList.collect{reindeer ->
        reindeer.distanceCovered(time)
    }

    final maxScoreOfRound = distanceListForTime.max()
    final List<Integer> roundScores = distanceListForTime.collect {it ==  maxScoreOfRound ? 1 : 0}

    [runningScores, roundScores].transpose().collect{it[0] + it[1]}
}).max())






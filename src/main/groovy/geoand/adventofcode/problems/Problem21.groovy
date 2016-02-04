package geoand.adventofcode.problems

import com.google.common.collect.Sets
import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.rpg.Item
import geoand.adventofcode.support.model.rpg.Player

import static geoand.adventofcode.support.model.rpg.Item.*

/**
 * Created by gandrianakis on 4/2/2016.
 */

final Set<Item> weapons = [
        offensive(8, 4),
        offensive(10, 5),
        offensive(25, 6),
        offensive(40, 7),
        offensive(74, 8),
]

final Set<Item> armor = [
        defensive(13, 1),
        defensive(31, 2),
        defensive(53, 3),
        defensive(75, 4),
        defensive(102, 5),
]

final Set<Item> rings = [
        offensive(25, 1),
        offensive(50, 2),
        offensive(100, 3),
        defensive(20, 1),
        defensive(40, 2),
        defensive(80, 3),
]

final int PLAYER_HP = 100

final List<String> lines = InputProviderFactory.inputProvider().getLines(21)

final Player BOSS = new Player(*lines.collect {extractInt(it)})

final List<Item> weaponsArmorCombinations = combinations(weapons, armor + nonExistent())
final List<Item> ringCombinations = ringCombinations(rings)

final List<Item> allCombinations = combinations(weaponsArmorCombinations, ringCombinations)

final List<MatchResult> matchResults = allCombinations
        .collect {new Player(PLAYER_HP, it)}
        .collect {new MatchResult(it, it.winsIfPlaysFirst(BOSS))}

println (matchResults.findAll {it.playerWins}.min {it.playerItemCost()}.playerItemCost())
println (matchResults.findAll {!it.playerWins}.max {it.playerItemCost()}.playerItemCost())


private int extractInt(String input) {
    input.find( /\d+/ ).toInteger()
}

private List<Item> ringCombinations(Set<Item> rings) {
    Sets.powerSet(rings).findAll {it.size() <= 2}.collect {
        if(it.empty) {
            return nonExistent()
        }
        if(1 == it.size()) {
            return it[0]
        }

        return combine(it.head(), it.last())
    }
}

class MatchResult {
    final Player player
    final boolean playerWins

    MatchResult(Player player, boolean playerWins) {
        this.player = player
        this.playerWins = playerWins
    }

    int playerItemCost() {
        return player.itemCost()
    }
}
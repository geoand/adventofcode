package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.rpg.magic.Spell

import static geoand.adventofcode.support.model.rpg.magic.Spell.*

/**
 * Created by gandrianakis on 11/2/2016.
 */
final List<String> lines = InputProviderFactory.inputProvider().getLines(22)

final List<Spell> spells = [
        simpleAttack(53, 4),
        healingAttack(73, 2, 2),
        defence(113, 7, 6),
        attack(173, 3, 6),
        rechange(229, 101, 5)
]

private int extractInt(String input) {
    input.find( /\d+/ ).toInteger()
}



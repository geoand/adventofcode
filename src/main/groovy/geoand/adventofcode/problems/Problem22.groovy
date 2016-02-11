package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import geoand.adventofcode.support.model.rpg.magic.NextSpellFunctionArguments
import geoand.adventofcode.support.model.rpg.magic.Spell
import geoand.adventofcode.support.model.rpg.magic.round.BossRound
import geoand.adventofcode.support.model.rpg.magic.round.PlayerRound
import geoand.adventofcode.support.model.rpg.magic.round.RoundContainer
import geoand.adventofcode.support.model.rpg.magic.round.SpellRoundsContainer
import groovy.transform.CompileStatic
import groovy.transform.TailRecursive

import java.util.function.Function

import static geoand.adventofcode.support.model.rpg.magic.Spell.*
import static geoand.adventofcode.support.model.rpg.magic.round.SpellRoundsContainer.initialUse

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

final BossRound firstBossRound = new BossRound(extractInt(lines.head()), extractInt(lines.last()))

(1..100000).each {
    final Random random = new Random();
    final PlayerRound firstPlayerRound = new PlayerRound(50, 500, initialUse(spells.head()))
    final int cost = simulate(new RoundContainer(firstBossRound, firstPlayerRound), {spells[random.nextInt(spells.size())]})
    if(cost > 0) {
        println cost
    }

}


@CompileStatic
private int simulate(RoundContainer firstRoundContainer, Function<NextSpellFunctionArguments, Spell> nextSpellFunction) {
    final CollectingFunction collectingFunction = new CollectingFunction(nextSpellFunction)
    return doSimulate(firstRoundContainer, collectingFunction)
}

@CompileStatic
@TailRecursive
private int doSimulate(RoundContainer roundContainer, CollectingFunction nextSpellFunction) {
    if(roundContainer.bossRound.health <= 0) {
        return nextSpellFunction.spells.collect {it.manaCost}.sum() as int
    }
    else if(roundContainer.playerRound.health <= 0) {
        return -1
    }
    else if(roundContainer.playerRound.mana <= 0) {
        return -1
    }

    return doSimulate(simulateRound(roundContainer, nextSpellFunction), nextSpellFunction)
}


@CompileStatic
private RoundContainer simulateRound(RoundContainer currentRound, Function<NextSpellFunctionArguments, Spell> nextSpellFunction) {
    final BossRound bossCurrentRound = currentRound.bossRound
    final PlayerRound playerCurrentRound = currentRound.playerRound

    final SpellRoundsContainer currentSpellRoundsContainer = playerCurrentRound.spellRoundsContainer

    final BossRound bossNextRound = bossCurrentRound.reduceHealth(currentSpellRoundsContainer.damage)

    final int playerHealthNextRound = playerCurrentRound.health - Math.max(bossCurrentRound.damage - currentSpellRoundsContainer.armor, 1) + playerCurrentRound.spellRoundsContainer.heal
    final int playerManaNextRound = currentSpellRoundsContainer.roundsAlreadyUsed == 0 ?
                                        playerCurrentRound.mana - currentSpellRoundsContainer.manaCost + currentSpellRoundsContainer.newMana :
                                        playerCurrentRound.mana + currentSpellRoundsContainer.newMana

    final SpellRoundsContainer nextSpellRoundsContainer =
            (currentSpellRoundsContainer.roundsAlreadyUsed + 1) == currentSpellRoundsContainer.duration ?
              initialUse(nextSpellFunction.apply(new NextSpellFunctionArguments(playerHealthNextRound, playerManaNextRound, bossNextRound.health))) :
              currentSpellRoundsContainer.useAgain()

    final PlayerRound playerNextRound = new PlayerRound(
            playerHealthNextRound,
            playerManaNextRound,
            nextSpellRoundsContainer
    )

    return new RoundContainer(bossNextRound, playerNextRound)
}

class CollectingFunction implements Function<NextSpellFunctionArguments, Spell> {

    final List<Spell> spells = []

    final Function<NextSpellFunctionArguments, Spell> delegate

    CollectingFunction(Function<NextSpellFunctionArguments, Spell> delegate) {
        this.delegate = delegate
    }

    @Override
    Spell apply(NextSpellFunctionArguments nextSpellFunctionArguments) {
        final Spell spell = delegate.apply(nextSpellFunctionArguments)
        spells << spell

        return spell
    }
}
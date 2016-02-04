package geoand.adventofcode.support.model.rpg

/**
 * Created by gandrianakis on 4/2/2016.
 */
class Player {

    final int hp
    final Item item

    Player(int hp, Item item) {
        this.hp = hp
        this.item = item
    }

    Player(int hp, int damage, int armor) {
        this(hp, new Item(0, damage, armor))
    }

    boolean winsIfPlaysFirst(Player other) {
        final int numberOfHitsForThisToKillOther = roundUp(other.hp, calculateAttackDamage(this.item.damage, other.item.armor))
        final int numberOfHitsForOtherToKillThis = roundUp(this.hp, calculateAttackDamage(other.item.damage, this.item.armor))

        return numberOfHitsForThisToKillOther <= numberOfHitsForOtherToKillThis
    }

    private int calculateAttackDamage(int damage, int armor) {
        return Math.max(damage - armor, 1)
    }

    private int roundUp(int dividend, int divisor) {
        return (dividend + divisor - 1) / divisor
    }

    int itemCost() {
        return item.cost
    }
}

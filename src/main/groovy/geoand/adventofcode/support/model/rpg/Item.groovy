package geoand.adventofcode.support.model.rpg

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovy.transform.ToString

/**
 * Created by gandrianakis on 4/2/2016.
 */
@ToString(includePackage = false)
@CompileStatic
class Item {

    final int cost
    final int damage
    final int armor

    Item(int cost, int damage, int armor) {
        this.cost = cost
        this.damage = damage
        this.armor = armor
    }

    static Item offensive(int cost, int damage) {
        return new Item(cost, damage, 0)
    }

    static Item defensive(int cost, int armor) {
        return new Item(cost, 0, armor)
    }

    static Item nonExistent() {
        return new Item(0, 0, 0)
    }

    static Item combine(Item first, Item second) {
        return new Item(first.cost + second.cost, first.damage + second.damage, first.armor + second.armor)
    }

    @CompileDynamic
    static List<Item> combinations(Collection<Item> first, Collection<Item> second) {
        return [first, second].combinations().collect {List<Item> items -> combine(items.head(), items.last())}
    }
}

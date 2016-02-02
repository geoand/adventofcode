package geoand.adventofcode.problems

import geoand.adventofcode.support.input.InputProviderFactory
import groovy.transform.TailRecursive

import java.util.function.Predicate

/**
 * Created by George Andrianakis on 28/1/2016.
 */

final String SPLIT = '=>'

final List<String> lines = InputProviderFactory.inputProvider().getLines(19).findAll{it}

final Predicate<String> isReplacementLinePredicate = new IsReplacementLinePredicate(SPLIT)

final List<String> replacementLines = lines.findAll(isReplacementLinePredicate.&test)
final String stringToReplace = lines.find(isReplacementLinePredicate.negate().&test)

final Map<String, List<String>> replacements = getReplacementMap(replacementLines, SPLIT, true)

println (partOneResults(stringToReplace, replacements).sort().size())

final Map<String, String> reverseReplacements = getReplacementMap(replacementLines, SPLIT, false).collectEntries {key, value -> [(key):value[0]]}

println(countSteps(stringToReplace, reverseReplacements, 0))


private Map<String, List<String>> getReplacementMap(List<String> replacementLines, String SPLIT, boolean straight) {
    replacementLines.inject([:] as Map<String, List<String>>) { Map<String, List<String>> currentMap, String currentLine ->
        final String[] parts = currentLine.split(SPLIT)
        if (!parts || parts.size() != 2) {
            throw new IllegalArgumentException("Line $currentLine is not a replacement line")
        }

        final int keyIndex = straight ? 0 : 1
        final int valueIndex = (keyIndex + 1) % 2

        final String key = parts[keyIndex].trim()
        final String value = parts[valueIndex].trim()

        currentMap[key] = currentMap.getOrDefault(key, []) + value

        return currentMap
    }
}


/**
 * Collect all the strings that are the result of each replacement and return a unique list
 */
private List<String> partOneResults(String stringToReplace, Map<String, List<String>> replacements) {
    replacements.keySet().collect{it.size()}.unique().collectMany {partOneResults(stringToReplace, replacements, it)}.unique()
}

/**
 * Returns all the unique replacements for the specified number of chars to check each time
 */
private List<String> partOneResults(String stringToReplace, Map<String, List<String>> replacements, int numberOfChars) {
    return stringToReplace.toList().collate(numberOfChars, 1, false).inject(new InjectResult('', stringToReplace.drop(numberOfChars).toString(), [])) { InjectResult running, List<String> partToReplaceList ->
        final String partToReplace = partToReplaceList.join('')
        final String prefix = running.prefix
        final String suffix = running.suffix

        final List<String> existingReplacements = running.generated

        final List<String> newReplacements = replacements.getOrDefault(partToReplace, [partToReplace]).collect { replacement -> prefix + replacement + suffix }
        return new InjectResult(prefix + partToReplace[0], suffix.drop(1).toString(), existingReplacements + newReplacements)
    }.generated.unique() - [stringToReplace]
}

@TailRecursive
private int countSteps(String input, Map<String, String> replacements, Integer initCount) {


    final StringInteger roundResult = replacements.inject(new StringInteger(input, initCount)) { StringInteger current, String key, String value ->
        if(current.string.contains(key)) {
            return new StringInteger(current.string.replaceFirst(key, value), current.integer + 1)
        }

        return current
    }

    if(roundResult.string == 'e') {
        return roundResult.integer
    }
    else {
        return countSteps(roundResult.string, replacements, roundResult.integer)
    }
}

class InjectResult {
    final String prefix
    final String suffix
    final List<String> generated

    InjectResult(String prefix, String suffix, List<String> generated) {
        this.prefix = prefix
        this.suffix = suffix
        this.generated = generated
    }
}

class IsReplacementLinePredicate implements Predicate<String> {

    final String split

    IsReplacementLinePredicate(String split) {
        this.split = split
    }

    @Override
    boolean test(String s) {
        return s.contains(split)
    }
}

class StringInteger {
    final String string
    final Integer integer

    StringInteger(String string, Integer integer) {
        this.string = string
        this.integer = integer
    }
}
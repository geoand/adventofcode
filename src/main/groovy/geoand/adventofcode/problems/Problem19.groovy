package geoand.adventofcode.problems
/**
 * Created by George Andrianakis on 28/1/2016.
 */

final input = 'HOH'

final Map<String, List<String>> replacements = [
        H: ['OH', 'HO'],
        O: ['HH']
]

//previous, next, results
final List<String> finalResult = input.inject(['', input.drop(1), []]) {running, character ->
    final String prefix = running[0]
    final String postfix = running[1]
    final List<String> runningResults = running[2]

    final List<String> current = replacements.getOrDefault(character, [character]).collect {replacement -> prefix + replacement + postfix}

    return [prefix + character, postfix.drop(1), runningResults + current]
}[2].unique()

println finalResult
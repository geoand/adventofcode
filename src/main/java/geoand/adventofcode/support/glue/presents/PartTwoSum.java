package geoand.adventofcode.support.glue.presents;

import java.util.stream.IntStream;

/**
 * Created by gandrianakis on 4/2/2016.
 */
public abstract class PartTwoSum {

    public static int calculate(Integer candidate) {
        final int floorDiv = Math.floorDiv(candidate, 50);
        final int minimumAllowedFactor = floorDiv > 0 ? floorDiv : 1;
        final int maximumPossibleFactorExcludingSelf = (candidate + 1) / 2;

        return (
                IntStream.rangeClosed(minimumAllowedFactor, maximumPossibleFactorExcludingSelf)
                        .filter(possibleFactor -> candidate % possibleFactor == 0)
                        .sum()
                + candidate
        ) * 11;
    }
}

package geoand.adventofcode.support.patterns.light

import geoand.adventofcode.support.model.light.GridLight
import geoand.adventofcode.support.model.light.PartOneGridLight
import geoand.adventofcode.support.patterns.Command
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

import java.util.regex.Matcher

/**
 * Created by gandrianakis on 15/1/2016.
 */
@CompileStatic
class GridLightCommandFactory {

    private final List<List<? extends GridLight>> gridLights

    GridLightCommandFactory(List<List<PartOneGridLight>> gridLights) {
        this.gridLights = gridLights
    }

    List<? extends Command<? extends GridLight>> create(String input) {
        final Matcher matcher = ( input =~ /(toggle|turn\s+off|turn\s+on)\s+(\d+),(\d+)\s+through\s+(\d+),(\d+)/ )
        if(matcher.size() != 1) {
            return []
        }

        try {
            final List<Object> match = matcher[0] as List<Object>
            final String commandStr = match[1]
            final int startXPos = match[2] as int
            final int startYPos = match[3] as int
            final int endXPos = match[4] as int
            final int endYPos = match[5] as int

            final def xPosRange = (startXPos..endXPos)
            final def yPosRange = (startYPos..endYPos)

            return doCreateCommands(xPosRange, yPosRange, commandStr)

        } catch (Exception e) {
            return []
        }

    }

    @CompileDynamic
    private List<Command<PartOneGridLight>> doCreateCommands(IntRange xPosRange, IntRange yPosRange, String commandStr) {
        return [xPosRange, yPosRange].combinations().collect { List<Integer> coordinatesList -> createCommand(commandStr, coordinatesList[0], coordinatesList[1]) }
    }

    private Command<PartOneGridLight> createCommand(String commandStr, int xPos, int yPos) {
        switch (commandStr) {
            case "toggle":
                return new GridLightToggleCommand(gridLights[xPos][yPos])
            case ~/turn\s+on/:
                return new GridLightTurnOnCommand(gridLights[xPos][yPos])
            case ~/turn\s+off/:
                return new GridLightTurnOffCommand(gridLights[xPos][yPos])
            default:
                throw new IllegalStateException("The initial filter allowed command $commandStr to pass but the value cannot be mapped to Command class")

        }
    }
}

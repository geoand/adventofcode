package geoand.adventofcode.support.model.geometry.threed

import groovy.transform.EqualsAndHashCode
import groovy.transform.Memoized

/**
 * Created by gandrianakis on 13/1/2016.
 */
@EqualsAndHashCode
class Rectangle {

    final int length
    final int width
    final int height

    Rectangle(int length, int width, int height) {
        this.length = length
        this.width = width
        this.height = height
    }

    public static Rectangle fromStringInput(String input) {
        if(!(input ==~ /(\d+)x(\d+)x(\d+)/)) {
            throw new IllegalArgumentException("The input $input is not in the correct form")
        }

        return new Rectangle(*(input.split('x').collect{Integer.parseInt(it)}))
    }

    @Memoized
    int surfaceArea() {
        return 2*length*width + 2*width*height + 2*height*length
    }

    @Memoized
    int smallestSideArea() {
        return [side1Area(), side2Area(), side3Area()].min()
    }

    @Memoized
    int volume() {
        return length*width*height
    }

    @Memoized
    private int side1Area() {
        return length*width
    }

    @Memoized
    private int side2Area() {
        return width*height
    }

    @Memoized
    private int side3Area() {
        return height*length
    }

    @Memoized
    private int side1Perimeter() {
        return 2*length + 2*width
    }

    @Memoized
    private int side2Perimeter() {
        return 2*width  + 2*height
    }

    @Memoized
    private int side3Perimeter() {
        return 2*height + 2*length
    }

    @Memoized
    int smallestSideAPerimeter() {
        return [side1Perimeter(), side2Perimeter(), side3Perimeter()].min()
    }
}

package geoand.adventofcode.support.input

import groovy.transform.Memoized

/**
 * Created by gandrianakis on 13/1/2016.
 */
abstract class InputProviderFactory {

    static InputProvider inputProvider

    @Memoized
    static InputProvider inputProvider() {
        if(null == inputProvider) {
            inputProvider = new FileInputProvider()
        }

        return inputProvider
    }
}

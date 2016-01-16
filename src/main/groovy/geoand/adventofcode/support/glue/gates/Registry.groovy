package geoand.adventofcode.support.glue.gates

import rx.subjects.BehaviorSubject

/**
 * Created by George Andrianakis on 16/1/2016.
 */
class Registry {

    final Map<String, BehaviorSubject<Integer>> map = [:]

    BehaviorSubject<Integer> createWithValue(String name, int value) {
        final BehaviorSubject<Integer> subject = BehaviorSubject.create(value)
        map[name] = subject
        return subject
    }

    BehaviorSubject<Integer> getOrCreate(String name) {
        final def existingSubject = map[name]
        if(existingSubject) {
            return existingSubject
        }

        final BehaviorSubject<Integer> newSubject = BehaviorSubject.create()
        map[name] = newSubject
        return newSubject
    }

    void clear() {
        map.clear()
    }
}

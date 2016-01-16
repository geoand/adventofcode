package geoand.adventofcode.support.glue.gates

import rx.Observable
import rx.functions.Func1
import rx.functions.Func2
import rx.subjects.BehaviorSubject

/**
 * Created by George Andrianakis on 16/1/2016.
 */
class Combiner {

    final Registry registry

    Combiner(Registry registry) {
        this.registry = registry
    }

    void combine(String firstInputName, String secondInputName, String resultName, Func2 function) {
        Observable.combineLatest(registry.getOrCreate(firstInputName), registry.getOrCreate(secondInputName), function).subscribe(registry.getOrCreate(resultName))
    }

    void combine(String inputName, String resultName, Func1 function) {
        registry.getOrCreate(inputName).map(function).subscribe(registry.getOrCreate(resultName))
    }

    void combine(String inputName, int staticInput, String resultName, Func2 function) {
        Observable.combineLatest(registry.getOrCreate(inputName), BehaviorSubject.create(staticInput), function).subscribe(registry.getOrCreate(resultName))
    }

    void combine(int staticInput, String resultName) {
        registry.getOrCreate(resultName).onNext(staticInput)
    }

}

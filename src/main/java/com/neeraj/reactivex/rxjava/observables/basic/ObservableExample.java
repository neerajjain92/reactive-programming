package com.neeraj.reactivex.rxjava.observables.basic;

import io.reactivex.Observable;

import java.util.List;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ObservableExample {

    public static void main(String[] args) {
        createObservableWithJust();
        createObservableWithIterable();
        createObservableUsingCreate();
    }

    public static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(System.out::println);
        System.out.println("---------------");
    }

    public static void createObservableWithIterable() {
        Observable.fromIterable(List.of(1, 2, 3, 4, 5))
                .subscribe(System.out::println);
        System.out.println("---------------");
    }

    public static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(10);
            observableEmitter.onNext(20);
            observableEmitter.onNext(30);
            observableEmitter.onNext(40);
            observableEmitter.onNext(null); /*Null values are generally not allowed in 2.x operators and sources */
            observableEmitter.onComplete();
        });
        /* Data Channel, Error Channel, and finally Complete channel */
        observable.subscribe(System.out::println,
                error -> System.err.println("There was an error " + error.getLocalizedMessage()),
                () -> System.out.println("Completed...."));
    }
}

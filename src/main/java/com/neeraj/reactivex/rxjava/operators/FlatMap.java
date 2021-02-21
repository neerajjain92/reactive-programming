package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

/**
 * @author neeraj on 22/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class FlatMap {

    public static void main(String[] args) {
        flatMap();
        flatMapBiFunction();
    }

    private static void flatMap() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.flatMap(
                item -> item.equals("bar") ? Observable.just(item) : Observable.fromArray(item.split("")))
                .subscribe(System.out::println);
    }

    private static void flatMapBiFunction() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.flatMap(item -> Observable.fromArray(item.split("")),
                (actual, second) -> actual + " " + second)
                .subscribe(System.out::println);
    }
}

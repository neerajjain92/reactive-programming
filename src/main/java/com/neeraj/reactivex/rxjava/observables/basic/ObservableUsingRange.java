package com.neeraj.reactivex.rxjava.observables.basic;

import io.reactivex.Observable;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ObservableUsingRange {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.range(0, 10);
        observable.subscribe(System.out::println);

    }
}

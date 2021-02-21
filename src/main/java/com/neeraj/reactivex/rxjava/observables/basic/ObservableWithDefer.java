package com.neeraj.reactivex.rxjava.observables.basic;

import io.reactivex.Observable;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ObservableWithDefer {

    private static int start = 5, count = 2;

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.defer(() -> {
            System.out.println("Creating New Observable with start=" + start + " and count=" + count);
            return Observable.range(start, count);
        });
        observable.subscribe(item -> System.out.println("Observer 1: " + item));

        count = 5; // Range method already holds the count value so it will not be changing the output accordingly
        // Hence defer comes to rescue, which delays the execution
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }
}

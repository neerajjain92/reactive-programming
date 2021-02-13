package org.example.rxjava;

import io.reactivex.Observable;

/**
 * http://reactivex.io/documentation/operators/empty-never-throw.html
 *
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class EmptyOrNeverObservable {

    public static void main(String[] args) throws InterruptedException {
        creatingObservableUsingEmpty();
        creatingObservableUsingNever();
    }

    private static void creatingObservableUsingEmpty() {
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println, System.err::println, () -> System.out.println("Completed"));
    }

    private static void creatingObservableUsingNever() throws InterruptedException {
        Observable observable = Observable.never();
        Thread.sleep(4000); // The never neither complete neither error out
        observable.subscribe(System.out::println, System.err::println, () -> System.out.println("Completed"));
    }
}

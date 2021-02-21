package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

/**
 * @author neeraj on 21/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class DoOrActionOperators {

    public static void main(String[] args) {
        doOnSubscribe();
        doOnNext();
        doOnComplete();
    }

    private static void doOnSubscribe() {
        Observable observable = Observable.just(1, 2, 3, 4, 4, 5)
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: Subscribed"));

        /* doOnSubscribe will get invoked everytime */
        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);
    }

    private static void doOnNext() {
        /* doOnNext will get invoked on every emission */
        Observable.just(1, 2, 3, 4, 4, 5)
                .doOnNext(item -> System.out.println("doOnNext: invoked"))
                .subscribe(System.out::println);

    }

    private static void doOnComplete() {
        System.out.println("DoOnComplete example........");
        Observable.just(1, 2, 3, 4, 4, 5)
                .doOnComplete(() -> System.out.println("doOnComplete: Completed"))
                .subscribe(System.out::println, System.err::println, () -> System.out.println("Completed in " +
                        "Subscription"));
    }

}

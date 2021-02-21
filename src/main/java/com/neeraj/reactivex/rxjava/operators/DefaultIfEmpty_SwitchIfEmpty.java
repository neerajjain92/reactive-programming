package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class DefaultIfEmpty_SwitchIfEmpty {

    public static void main(String[] args) {
        useDefaultIfEmpty();
        useSwitchIfEmpty();
    }

    private static void useDefaultIfEmpty() {
        System.out.println("Use Default if Empty........");
        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item > 10)
                .defaultIfEmpty(-1) // Default value in case previous observable didn't emit anything
                .subscribe(System.out::println);
    }

    private static void useSwitchIfEmpty() {
        System.out.println("Use Switch if Empty........");
        Observable.just(1, 2, 3, 4, 20)
                .filter(item -> item > 10)
                .switchIfEmpty(Observable.just(11, 12, 13, 14))
                .subscribe(System.out::println);
    }
}

package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class Distinct_DistinctUntilChanged {

    public static void main(String[] args) {
        distinctOperator();
        distinctWithKeySelector();
        distinctUntilChangedOperator();
        distinctUntilChangedWithKeySelector();
    }

    /**
     * Return distinct items
     */
    private static void distinctOperator() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinct()
                .subscribe(System.out::println);
    }

    /**
     * Find items with distinct length instead of content.
     */
    private static void distinctWithKeySelector() {
        Observable.just("fool", "foo", "super", "foss", "foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    /**
     * Return distinct items until changed, i.e emits all items that are different from immediate predecessor
     */
    private static void distinctUntilChangedOperator() {
        Observable.just(1, 1, 1, 2, 2, 3, 3, 5, 1, 2)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }

    /**
     * Return distinct length items until changed, i.e emits all items that are different from immediate predecessor
     */
    private static void distinctUntilChangedWithKeySelector() {
        Observable.just("fool", "foo", "poo", "super", "foss", "foil")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }
}

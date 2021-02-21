package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

import java.util.Comparator;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class Sorting {

    public static void main(String[] args) {
        useSorted();
        useSortedWithOwnOperator();
        useSortedOnNonComparator();
    }

    private static void useSorted() {
        Observable.just(3, 4, 5, 2, 1)
                .sorted()
                .subscribe(item -> System.out.print(item + ","), System.err::println, System.out::println);
    }

    private static void useSortedWithOwnOperator() {
        Observable.just(3, 4, 5, 2, 1)
                .sorted(Comparator.reverseOrder())
                .subscribe(item -> System.out.print(item + ","), System.err::println, System.out::println);
    }

    private static void useSortedOnNonComparator() {
        Observable.just("John", "Foo", "Marry")
                .sorted(Comparator.comparingInt(String::length))
                .subscribe(item -> System.out.print(item + ","), System.err::println, System.out::println);
    }
}

package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class MapAndFilterOperator {

    static Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

    public static void main(String[] args) {
        mapOperator();
        mapOperatorReturnDifferentData();
        filterOperator();
        combineMapAndFilter();
    }

    private static void mapOperator() {
        System.out.println("Exploring Map Operator.........");
        observable
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }

    private static void mapOperatorReturnDifferentData() {
        System.out.println("Map Returning different data from source...");
        observable
                .map(item -> "Hello World modified " + item)
                .subscribe(System.out::println);
    }

    private static void filterOperator() {
        System.out.println("Exploring Filter Operator.........");
        observable
                .filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
    }

    private static void combineMapAndFilter() {
        System.out.println("Exploring Combination of Filter and Map Operator.........");
        observable
                .filter(item -> item % 2 == 0)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }
}

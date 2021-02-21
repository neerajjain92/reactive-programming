package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * @author neeraj on 22/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ZipObservables {

    public static void main(String[] args) {
        zip();
        zipWith();
        zipIterable();
    }

    private static void zip() {
        System.out.println("<-------------Zip --------------->");
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(List.of(11, 12, 13, 14, 15));

        Observable.zip(observable, sixToTen, elevenToFifteen, (a, b, c) -> a + b + c)
                .subscribe(System.out::println);
    }

    private static void zipWith() {
        System.out.println("<-------------Zip With --------------->");
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);
        observable.zipWith(sixToTen, Integer::sum).subscribe(System.out::println);
    }

    private static void zipIterable() {
        System.out.println("Zip Iterable.................");
        Observable<Integer> observable = Observable.just(1, 2, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(List.of(11, 12, 13, 14, 15));

        List<Observable<Integer>> observables = List.of(observable, sixToTen, elevenToFifteen);

        Observable.zipIterable(observables, Arrays::toString, true, 1)
                .subscribe(System.out::println);
    }
}

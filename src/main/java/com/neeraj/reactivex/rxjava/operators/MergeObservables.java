package com.neeraj.reactivex.rxjava.operators;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author neeraj on 22/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
@SuppressWarnings({"unused", "DuplicatedCode"})
public class MergeObservables {

    public static void main(String[] args) {
        merge();
        mergeArray();
        mergeIterable();
        mergeWith();
        mergeInfinite();
    }

    private static void merge() {
        System.out.println(">?>>>>>>>>>>Merge<<<<<<<<<<<<<<<<<<");
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        Observable.merge(oneToFive, sixToTen)
                .subscribe(System.out::println);
    }

    private static void mergeArray() {
        System.out.println(">?>>>>>>>>>>Merge-Array<<<<<<<<<<<<<<<<<<");
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        Observable.mergeArray(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive)
                .subscribe(System.out::println);
    }

    private static void mergeIterable() {
        System.out.println(">?>>>>>>>>>>Merge-Iterable<<<<<<<<<<<<<<<<<<");
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        Observable.merge(Arrays.asList(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty,
                twentyOneToTwentyFive))
                .subscribe(System.out::println);
    }

    private static void mergeWith() {
        System.out.println(">?>>>>>>>>>>Merge With<<<<<<<<<<<<<<<<<<");
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        oneToFive.mergeWith(sixToTen).subscribe(System.out::println);
    }

    private static void mergeInfinite() {
        System.out.println(">?>>>>>>>>> Merge Infinite <<<<<<<<<<<<");
        Observable<String> infinite1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> "From infinite1: " + item);
        Observable<String> infinite2 = Observable.interval(2, TimeUnit.SECONDS)
                .map(item -> "From infinite2: " + item);

        infinite1.mergeWith(infinite2).subscribe(System.out::println);
        RxJavaUtils.sleep(6000);
    }
}

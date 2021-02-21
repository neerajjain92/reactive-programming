package com.neeraj.reactivex.rxjava.operators;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class Take_Skip_TakeWhile_SkipWhile {

    public static void main(String[] args) {
        takeOperator();
        takeWithInterval();
        takeWhileOperator();
        skipOperator();
        skipWhileOperator();

    }

    public static void takeOperator() {
        Observable.just(1, 2, 3, 4, 5)
                .take(2)
                .subscribe(System.out::println, System.err::println,
                        () -> System.out.println("Completed with take.."));
    }

    private static void takeWithInterval() {
        System.out.println("take() with time, Returns an Observable that emits those items emitted by source " +
                "ObservableSource before a specified time runs out.");
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println, System.err::println,
                        () -> System.out.println("Completed with take with time.."));
        RxJavaUtils.sleep(3000);
    }

    /**
     * Take the items from the source until certain criteria is matched.
     */
    private static void takeWhileOperator() {
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 9, 10)
                .takeWhile(item -> item <= 3)
                .subscribe(System.out::println, System.err::println,
                        () -> System.out.println("Completed with takeWhile.."));
    }

    private static void skipOperator() {
        Observable.just(1, 2, 3, 4, 5)
                .skip(2)
                .subscribe(System.out::println, System.err::println,
                        () -> System.out.println("Completed with skip.."));
    }

    private static void skipWhileOperator() {
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 9, 10)
                .skipWhile(item -> item <= 3)
                .subscribe(System.out::println, System.err::println,
                        () -> System.out.println("Completed with skipWhile.."));
    }
}

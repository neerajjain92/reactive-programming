package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class RepeatAndScan {

    public static void main(String[] args) {
        useRepeat();
        useScan();
        useScanWithInitialValue();
    }

    private static void useRepeat() {
        System.out.println("Using Repeat...");
        Observable.just(1, 2, 3, 4, 5)
                .repeat(2)
                .subscribe(System.out::println);
    }

    /**
     * Scan will apply a function to each item emitted by an Observable, sequentially, and emit each successive value
     */
    private static void useScan() {
        System.out.println("Using Scan....");
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(System.out::println);
    }

    private static void useScanWithInitialValue() {
        System.out.println("Using Scan with Initial value....");
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .scan(10, (accumulator, next) -> accumulator + next)
                .subscribe(System.out::println);
    }
}

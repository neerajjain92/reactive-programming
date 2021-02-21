package com.neeraj.reactivex.rxjava.errorHandling;

import io.reactivex.Observable;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author neeraj on 21/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class RetryInErrorHandling {

    public static void main(String[] args) {
//        retryWithPredicate();
        retryTill();
        retryUntil();
    }

    /**
     * This will keep on retrying infinite times since we are just mimic IOException
     * if in case it was a real API call and eventually we don't get any IOException then this
     * retry won't retry.
     */
    private static void retryWithPredicate() {
        Observable.error(new IOException("This is an example error"))
                .retry(error -> {
                    if (error instanceof IOException) {
                        System.out.println("Retrying in case of IOException...");
                        return true;
                    }
                    return false; // In Other cases we simply let the error propagate.
                })
                .subscribe(
                        System.out::println,
                        error -> System.err.println("Subscribed Error....." + error),
                        () -> System.out.println("Completed....")
                );
    }

    private static void retryTill() {
        Observable.error(new IOException("This is an example error"))
                .retry(3)
                .subscribe(
                        System.out::println,
                        error -> System.err.println("Subscribed Error even after retrying....." + error),
                        () -> System.out.println("Completed....")
                );
    }

    private static void retryUntil() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Observable.error(new IOException("This is an example error"))
                .doOnError(error -> {
                    System.out.println("Retrying at " + atomicInteger.get() + " time ");
                    atomicInteger.getAndIncrement();
                })
                .retryUntil(() -> atomicInteger.get() >= 3)
                .subscribe(
                        System.out::println,
                        error -> System.err.println("Subscribed Error even after retrying....." + error),
                        () -> System.out.println("Completed....")
                );
    }
}

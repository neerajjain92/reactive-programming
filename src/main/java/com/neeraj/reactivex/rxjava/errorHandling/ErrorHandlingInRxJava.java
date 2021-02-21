package com.neeraj.reactivex.rxjava.errorHandling;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Observable;

import java.io.IOException;

/**
 * @author neeraj on 21/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ErrorHandlingInRxJava {

    public static void main(String[] args) {
        doOnError();
        // This sleep is necessary because doOnError() might not run immediately and the main thread has to wait
        // else you might see different output.
        RxJavaUtils.sleep(1000);
        onErrorResumeNext();
        RxJavaUtils.sleep(1000);
        onErrorReturn();
        RxJavaUtils.sleep(1000);
        onErrorReturnItem();
    }


    private static void doOnError() {
        System.out.println("Exploring doOnError()");
        Observable.error(new Exception("This is an example error"))
                .doOnError(error -> System.out.println("doOnError........" + error.getMessage()))
                .subscribe(
                        System.out::println,
                        error -> System.err.println("Subscribed Error....." + error),
                        () -> System.out.println("Completed....")
                );
    }

    private static void onErrorResumeNext() {
        System.out.println("Exploring onErrorResumeNext()");
        Observable.error(new Exception("This is an example error"))
                .onErrorResumeNext(Observable.just(1, 2, 3, 4, 5))
                .subscribe(
                        System.out::println,
                        error -> System.err.println("Subscribed Error....." + error),
                        () -> System.out.println("Completed....")
                );
    }

    private static void onErrorReturn() {
        System.out.println("Exploring onErrorReturn()");
        Observable.error(new IOException("This is an example error"))
                .onErrorReturn(error -> error instanceof IOException ? 1 : 0)
                .subscribe(
                        System.out::println,
                        error -> System.err.println("Subscribed Error....." + error),
                        () -> System.out.println("Completed....")
                );
    }

    private static void onErrorReturnItem() {
        System.out.println("Exploring onErrorReturnItem()");
        Observable.error(new IOException("This is an example error"))
                .onErrorReturnItem("Hello World")
                .subscribe(
                        System.out::println,
                        error -> System.err.println("Subscribed Error....." + error),
                        () -> System.out.println("Completed....")
                );
    }


}

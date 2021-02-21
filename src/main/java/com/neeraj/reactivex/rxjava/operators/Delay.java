package com.neeraj.reactivex.rxjava.operators;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class Delay {

    public static void main(String[] args) {
//        delay();
        delayError();
    }

    /***
     * Delay will delay the submission of emission by specified delay time,
     * but once the emission starts it doesn't play any role.
     */
    private static void delay() {
        Observable.just(1, 2, 3, 4, 5)
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        RxJavaUtils.sleep(4000);
    }

    private static void delayError() {
        Observable.error(new Exception("Error occurred after 1 seconds delay."))
                .delay(1000, TimeUnit.MILLISECONDS, true)
                .subscribe(System.out::println, System.err::println);
        RxJavaUtils.sleep(1000);
    }
}

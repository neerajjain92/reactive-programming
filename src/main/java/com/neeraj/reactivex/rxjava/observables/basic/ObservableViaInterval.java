package com.neeraj.reactivex.rxjava.observables.basic;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ObservableViaInterval {

    public static void main(String[] args) {
        createObservableViaInterval();
        makeCreateObservableViaIntervalToActAsHotObservable();
    }

    /**
     * Observable via interval is Cold observable and not hot observable.
     */
    private static void createObservableViaInterval() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        RxJavaUtils.sleep(2000);

        observable.subscribe(item -> System.out.println("Observer 2: " + item));
        RxJavaUtils.sleep(3000);
    }

    /**
     * By default interval creates cold observable but we can make it hot observable.
     */
    private static void makeCreateObservableViaIntervalToActAsHotObservable() {
        System.out.println("Making interval act as HotObservable via connectableObservable.......");
        ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).publish();
        connectableObservable.subscribe(item -> System.out.println("Observer 1: " + item));
        connectableObservable.connect();
        RxJavaUtils.sleep(3000);

        connectableObservable.subscribe(item -> System.out.println("Observer 2: " + item));
        RxJavaUtils.sleep(2000);
    }
}

package com.neeraj.reactivex.rxjava.observables.basic;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ColdHotAndConnectableObservable {

    public static void main(String[] args) throws InterruptedException {
        createColdObservable();
        createConnectableObservable();
    }

    /**
     * Any new subscriber will start listening from the start, just like a recorded CD.
     */
    private static void createColdObservable() throws InterruptedException {
        System.out.println("Colds Observable......");
        Observable<Integer> cold = Observable.just(1, 2, 3, 4);

        cold.subscribe(System.out::println);

        Thread.sleep(2000);
        System.out.println("----Another Observable--------");
        cold.subscribe(System.out::println);
    }

    private static void createConnectableObservable() {
        System.out.println("Connectable Observable......");
        ConnectableObservable<Integer> connectableObservable = Observable.just(1, 2, 3, 4, 5).publish();

        final Disposable observableOneDisposable =
                connectableObservable.subscribe(item -> System.out.println("Observable 1: " + item));

        final AtomicInteger counter = new AtomicInteger();
        connectableObservable.subscribe(item -> {
            Thread.sleep(1000);
            if (counter.incrementAndGet() == 3) {
                System.out.println("Cancelling the Observable 1 subscription >>>>>>>>");
                observableOneDisposable.dispose(); // This will cancel the subscription of observable 1.
            }
            System.out.println("Observable 2: " + item);
        });
        connectableObservable.connect();
    }
}

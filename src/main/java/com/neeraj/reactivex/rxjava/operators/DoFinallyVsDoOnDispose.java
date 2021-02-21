package com.neeraj.reactivex.rxjava.operators;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

/**
 * @author neeraj on 21/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class DoFinallyVsDoOnDispose {

    public static void main(String[] args) {
        doFinally();
        doDispose();

    }

    private static void doFinally() {
        /* doOnFinally also runs even when the Observable didn't complete*/
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(10);
            observableEmitter.onNext(20);
            observableEmitter.onNext(30);
            observableEmitter.onNext(40);
            observableEmitter.onNext(null); /*Null values are generally not allowed in 2.x operators and sources */
            observableEmitter.onComplete();
        });

        observable
                .doFinally(() -> System.out.println("doFinally: Completed...."))
                .subscribe(System.out::println,
                        error -> System.err.println("Subscription: Error===>" + error),
                        () -> System.out.println("Completed."));
    }

    private static void doDispose() {
        Observable observable = Observable.just(1, 2, 3, 4, 5)
                .delay(2, TimeUnit.MILLISECONDS) // Intentional delay
                .doOnDispose(() -> System.out.println("Action: Disposed..."));

        Disposable disposable = observable.subscribe(System.out::println);
        RxJavaUtils.sleep(1);
        disposable.dispose();
    }

}

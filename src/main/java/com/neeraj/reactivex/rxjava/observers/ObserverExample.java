package com.neeraj.reactivex.rxjava.observers;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ObserverExample {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(null);
            emitter.onComplete();
        });

        Observer<Integer> observer = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed........");
            }
        };
        observable.subscribe(observer);
    }
}

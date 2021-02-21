package com.neeraj.reactivex.rxjava.observables.special;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class SingleMayBeAndCompletable {

    public static void main(String[] args) {
        createSingle();
        createMayBe();
        createCompletable();
    }

    private static void createSingle() {
        Disposable d = Single.just("Hello World")
                .delay(1, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<String>() {

                    @Override
                    protected void onStart() {
                        System.out.println("Started....");
                    }

                    @Override
                    public void onSuccess(@NonNull String value) {
                        System.out.println("Success: " + value);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });

        RxJavaUtils.sleep(2000);
        d.dispose();
    }

    private static void createMayBe() {
        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Object object) {
                System.out.println("Received value with Maybe observer " + object);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Maybe Completed.....");
            }
        });
    }

    private static void createCompletable() {
        Completable.fromSingle(Single.just("Hello World")).subscribe(() -> System.out.println("Completed from " +
                "Completable...."));
    }
}

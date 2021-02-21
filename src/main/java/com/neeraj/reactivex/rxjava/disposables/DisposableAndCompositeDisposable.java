package com.neeraj.reactivex.rxjava.disposables;

import com.neeraj.reactivex.rxjava.utils.RxJavaUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class DisposableAndCompositeDisposable {

    public static void main(String[] args) {
//        handleDisposable();
//        handleDisposableInObserver();
        handleDisposableOutsideObserver();
        compositeDisposable();
    }

    private static void handleDisposable() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);
        RxJavaUtils.sleep(3000);
        disposable.dispose();
        RxJavaUtils.sleep(1000);
        System.out.println("Is Disposed ? " + disposable.isDisposed());
    }

    private static void handleDisposableInObserver() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8);

        observable.subscribe(new Observer<>() {

            private Disposable disposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
            }

            @Override
            public void onNext(@NonNull Integer value) {
                if (value == 3) {
                    System.out.println("Disposed at value 3");
                    disposable.dispose();
                }
                System.out.println(value);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Completed.....");
            }
        });
    }

    private static void handleDisposableOutsideObserver() {
        Observable<String> observable = Observable.just("Hello World....");
        Disposable disposable = observable.subscribeWith(new ResourceObserver<>() {
            @Override
            public void onNext(@NonNull String s) {
                System.out.println("ResourceObserver received value:: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Resource Observer completed....");
            }
        });

        RxJavaUtils.sleep(1000);
        System.out.println("Disposing now after sleeping for 1 second...");
        disposable.dispose();

    }

    /**
     * Dispose multiple resource...
     */
    private static void compositeDisposable() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe(item -> System.out.println("Observer 1: " + item));
        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2: " + item));

        compositeDisposable.addAll(disposable1, disposable2);
        compositeDisposable.dispose();
    }

}

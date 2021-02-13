package org.example.rxjava;

import io.reactivex.Observable;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ObservableError {

    public static void main(String[] args) {
        throwException();
        throwExceptionUsingCallable();
    }

    /**
     * Will throw same exception instance to every subscriber and doesn't do lazy evaluation of it.
     */
    public static void throwException() {
        Observable observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, error -> System.out.println("Error 1:==>" + error.hashCode() + " , "
                + error.toString()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2:==>" + error.hashCode() + " , "
                + error.toString()));

    }

    /**
     * This will be evaluated lazy
     */
    public static void throwExceptionUsingCallable() {
        Observable observable = Observable.error(() -> {
            return new Exception("A callable exception evaluated at runtime....");
        });
        observable.subscribe(System.out::println,
                error -> System.out.println("Callable Error 1:==>" + error.hashCode() + " , "
                        + error.toString()));
        observable.subscribe(System.out::println,
                error -> System.out.println("Callable Error 2:==>" + error.hashCode() + " , "
                        + error.toString()));
    }
}

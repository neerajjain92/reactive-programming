package org.example.rxjava;

import io.reactivex.Observable;

import java.util.Random;

/**
 * @author neeraj on 13/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ObservableFromCallable {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(() -> getNumber());
        observable.subscribe(System.out::println,
                error -> System.err.println("Error occurred " + error.getLocalizedMessage()));
    }

    private static int getNumber() {
        System.out.println("Generating a number");
        return new Random().nextInt(10) * 5;
    }
}

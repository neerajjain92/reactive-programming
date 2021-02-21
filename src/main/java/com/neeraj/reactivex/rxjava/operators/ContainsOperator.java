package com.neeraj.reactivex.rxjava.operators;

import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class ContainsOperator {

    public static void main(String[] args) {
        containsWithPrimitive();
        containsWithNonPrimitive();
    }

    /**
     * contains() Returns a Single that emits a Boolean that indicates whether the source ObservableSource emitted a
     * specified item
     */
    private static void containsWithPrimitive() {
        System.out.println("Contains return single.....");
        Observable.just(1, 2, 3, 4, 5)
                .contains(2)
                .subscribe(System.out::println);
    }

    private static void containsWithNonPrimitive() {
        User user0 = new User("Neeraj");
        User user1 = new User("Jitu");
        User user2 = new User("Bakshi");
        User user3 = new User("Neeraj");

        Observable.just(user0, user1, user2, user3)
                .contains(new User("jitu"))
                .subscribe(System.out::println);
    }

    @Data
    @AllArgsConstructor
    private static class User {
        String name;
    }
}

package com.neeraj.reactivex.rxjava.utils;

import lombok.SneakyThrows;

/**
 * @author neeraj on 14/02/21
 * Copyright (c) 2019, reactive-programming.
 * All rights reserved.
 */
public class RxJavaUtils {

    @SneakyThrows
    public static void sleep(final int waitTimeInMillis) {
        Thread.sleep(waitTimeInMillis);
    }
}

/*
 * Copyright (c) 2018, PayPal. All Rights Reserved.
 */

package org.acme;

import javax.inject.Singleton;

@Singleton
public class DummyBean {

    public static final String FORMAT = "Hello %s!!";

    public String sayHello(final String name) {
        return String.format(FORMAT, name);
    }
}

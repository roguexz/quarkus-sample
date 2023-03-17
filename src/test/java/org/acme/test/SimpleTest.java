/*
 * Copyright 2020, Harsha Ramesh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acme.test;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.DummyBean;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.net.URL;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class SimpleTest {

    @Inject
    DummyBean bean;

    @ConfigProperty(name = "mock.ssh.username", defaultValue = "not-set")
    Optional<String> username;

    @TestHTTPResource("/")
    URL serverListeningAt;

    @Test
    public void doNothing() {
        System.err.println("Test server is running at: " + serverListeningAt);
        assertTrue(username.isPresent(), "Config property was not injected.");
        assertEquals("unit-test", username.get(), "Test username does not match.");
        assertNotNull(bean);
    }
}

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

package io.rogue.playground.quarkus.consumer.test;

import io.quarkus.test.junit.QuarkusTest;
import io.rogue.playground.quarkus.consumer.MyCache;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class VerifyCacheTest {

    @Inject
    MyCache cache;

    @Test
    public void verifyCacheReference() {
        assertNotNull(cache, "Bean injection isn't working as expected.");
        assertNotNull(cache.getEndPoint(), "Endpoint should not be null.");
        assertNotNull(cache.getAnotherEndPoint(), "Endpoint should not be null.");
        System.err.println(cache.getEndPoint());
        System.err.println(cache.getAnotherEndPoint());
    }
}

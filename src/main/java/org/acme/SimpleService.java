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

package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.time.OffsetDateTime;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/verify")
public class SimpleService {

    @Path("/converter")
    @GET
    @Produces(TEXT_PLAIN)
    public String doSomething(@QueryParam("before") OffsetDateTime before) {
        return before != null ? before.toString() : "No value";
    }
}

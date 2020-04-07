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

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.Provider;
import java.time.OffsetDateTime;

/**
 * Converter for {@link OffsetDateTime} objects.
 */
@Provider
public class OffsetDateTimeParser implements ParamConverter<OffsetDateTime> {

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime fromString(String value) {
        return OffsetDateTime.parse(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString(OffsetDateTime value) {
        return value.toString();
    }
}

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

package io.rogue.playground.quarkus.config;

import io.smallrye.config.PropertiesConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSourceProvider;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Load properties from dependent jar files.
 */
public class JarConfigProperties implements ConfigSourceProvider {

    private static final String CLASS_NAME = JarConfigProperties.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
    private static final String PATH = "application.properties";

    @Override
    public Iterable<ConfigSource> getConfigSources(ClassLoader forClassLoader) {
        final String METHOD_NAME = "getConfigSources";
        Collection<ConfigSource> configurations = new ArrayList<>();
        try {
            Enumeration<URL> files = Thread.currentThread().getContextClassLoader().getResources(PATH);
            while (files.hasMoreElements()) {
                URL packagedFiled = files.nextElement();
                if (!"jar".equals(packagedFiled.getProtocol())) {
                    continue;
                }
                try {
                    configurations.add(new PropertiesConfigSource(packagedFiled));
                } catch (IOException e) {
                    LOGGER.logp(Level.WARNING, CLASS_NAME, METHOD_NAME,
                            "Unable to load configurations from: " + packagedFiled.toExternalForm(), e);
                }
            }
        } catch (IOException e) {
            LOGGER.logp(Level.WARNING, CLASS_NAME, METHOD_NAME, "Unable to lookup configuration files.", e);
        }
        return configurations;
    }
}

/*
 * Copyright 2016 Karl Bennett
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

package shiver.me.timbers.data.random;

import shiver.me.timbers.building.Block;

import java.util.Random;

/**
 * @author Karl Bennett
 */
class LazyGeneratedIterables implements GeneratedIterables {

    private final Random random;
    private final Block defaultGenerator;

    public LazyGeneratedIterables(Random random, Block defaultGenerator) {
        this.random = random;
        this.defaultGenerator = defaultGenerator;
    }

    @Override
    public GeneratedIterable create() {
        return create(Object.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> GeneratedIterable<T> create(Class<T> type) {
        return new LazyGeneratedIterable<>(type, random, defaultGenerator);
    }
}

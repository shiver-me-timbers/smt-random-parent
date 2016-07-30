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

import java.util.List;
import java.util.Random;
import java.util.Set;

import static shiver.me.timbers.data.random.Constants.DEFAULT_MAX_ARRAY_SIZE;

/**
 * @author Karl Bennett
 */
class SomeRandomIterables implements RandomIterables {

    private final Random random;
    private final GeneratedIterables generatedIterables;

    public SomeRandomIterables(Random random, GeneratedIterables generatedIterables) {
        this.random = random;
        this.generatedIterables = generatedIterables;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> RandomIterable<T> thatContainsRandom(T... elements) {
        if (elements.length > 0) {
            return createRandomIterable(new RandomBlock(random, elements));
        }
        return (RandomIterable<T>) createRandomIterable(new SomeRandomBlock(random));
    }

    @Override
    public <T> FixedRandomIterable<T> thatContainsRandomlyOrdered(T... elements) {
        final GeneratedIterable<T> iterable = createGeneratedIterable(
            new RandomOrderBlock<>(random, elements), elements.length
        );
        // We generate the iterator up front because the RandomOrderBlock is not thread safe so we want to make sure the
        // iterator is built and cached and the building cannot be run again in potentially multiple threads.
        iterable.iterator();
        return new DelegateRandomIterable<>(iterable);
    }

    private <T> RandomIterable<T> createRandomIterable(Block<T> defaultBlock) {
        return new DelegateRandomIterable<>(
            createGeneratedIterable(defaultBlock, random.nextInt(DEFAULT_MAX_ARRAY_SIZE))
        );
    }

    private <T> GeneratedIterable<T> createGeneratedIterable(Block<T> defaultBlock, int length) {
        return generatedIterables.create(defaultBlock, length);
    }

    private class DelegateRandomIterable<T> implements RandomIterable<T> {

        private final GeneratedIterable<T> generatedIterable;

        public DelegateRandomIterable(GeneratedIterable<T> generatedIterable) {
            this.generatedIterable = generatedIterable;
        }

        @Override
        public RandomIterable<T> withLength(int length) {
            generatedIterable.withLength(length);
            return this;
        }

        @Override
        public List<T> list() {
            return generatedIterable.list();
        }

        @Override
        public T[] array() {
            return generatedIterable.array();
        }

        @Override
        public Set<T> set() {
            return generatedIterable.set();
        }
    }
}

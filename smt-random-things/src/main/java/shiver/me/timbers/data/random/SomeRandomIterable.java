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

import java.util.List;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class SomeRandomIterable<T> implements RandomIterable<T> {

    private final GeneratedIterable<T> generatedIterable;

    public SomeRandomIterable(GeneratedIterable<T> generatedIterable, Random random, T... elements) {
        this.generatedIterable = generatedIterable;
        if (elements.length > 0) {
            generatedIterable.withGenerator(new RandomBlock<>(random, elements));
        }
    }

    @Override
    public SomeRandomIterable<T> withLength(int length) {
        generatedIterable.withLength(length);
        return this;
    }

    @Override
    public List<T> list() {
        return generatedIterable.list();
    }
}

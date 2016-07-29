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

import java.util.Random;

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
    public <T> RandomIterable<T> thatContains(T... elements) {
        return new SomeRandomIterable<>(generatedIterables.create(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)), random, elements);
    }
}
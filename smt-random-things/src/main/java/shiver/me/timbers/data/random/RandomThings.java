/*
 * Copyright 2015 Karl Bennett
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

import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple helper methods for generating random things.
 *
 * @author Karl Bennett
 */
public class RandomThings {

    private static Things things() {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        return new SomeThings(new SomeRandomIterables(random, new LazyGeneratedIterables()));
    }

    /**
     * Randomly selects one of the supplied objects and returns it.
     */
    @SafeVarargs
    public static <T> T someThing(T... things) {
        return things().someThing(things);
    }

    /**
     * Generates a list with a random length (max 1024) that is populated with random amounts of any of the supplied
     * objects.
     */
    @SafeVarargs
    public static <T> RandomIterable<T> someThings(T... things) {
        return things().someThings(things);
    }

    public static <T> RandomIterable<T> someOrder(T... things) {
        return things().someOrder(things);
    }
}

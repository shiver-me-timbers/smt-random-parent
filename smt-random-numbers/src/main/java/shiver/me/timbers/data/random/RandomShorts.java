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

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static shiver.me.timbers.data.random.Retries.DEFAULT_RETRY_AMOUNT;

/**
 * Simple helper methods for generating random shorts of varying size.
 *
 * @author Karl Bennett
 */
public class RandomShorts {

    private static int retryAmount = DEFAULT_RETRY_AMOUNT;

    static void setRetryAmount(int retryAmount) {
        RandomShorts.retryAmount = retryAmount;
    }

    private static Numbers<Short> shorts() {

        final Random random = ThreadLocalRandom.current();

        return new BoundNumbers<>(Short.class, new ShortOperations(random), retryAmount, random);
    }

    /**
     * Generate a random positive or negative short value of any size.
     */
    public static Short someShort() {
        return shorts().someNumber();
    }

    /**
     * Generate a random positive short value of any size. This includes 0.
     */
    public static Short somePositiveShort() {
        return shorts().somePositiveNumber();
    }

    /**
     * Generate a random negative short value of any size. This includes 0.
     */
    public static Short someNegativeShort() {
        return shorts().someNegativeNumber();
    }

    /**
     * Generate a random short value of any magnitude greater than or equal to the supplied bound.
     */
    public static Short someShortGreaterThan(Short bound) {
        return shorts().someNumberGreaterThan(bound);
    }

    /**
     * Generate a random short value less than or equal to the supplied bound. Could produce a negative value of any
     * magnitude.
     */
    public static Short someShortLessThan(Short bound) {
        return shorts().someNumberLessThan(bound);
    }

    /**
     * Generate a random short value that falls between a min, inclusive, and max, exclusive.
     */
    public static Short someShortBetween(Short min, Short max) {
        return shorts().someNumberBetween(min, max);
    }

    /**
     * Generate an iterable that contains random shorts with a random length.
     */
    public static NumbersIterable<Short> someShorts() {
        return shorts().someNumbers();
    }

    /**
     * Generate an iterable that contains random shorts with a fixed length.
     */
    public static NumbersIterable<Short> someShorts(int length) {
        return shorts().someNumbers(length);
    }
}

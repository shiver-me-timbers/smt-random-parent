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
 * Simple helper methods for generating random longs of varying size.
 *
 * @author Karl Bennett
 */
public class RandomLongs {

    private static int retryAmount = DEFAULT_RETRY_AMOUNT;

    static void setRetryAmount(int retryAmount) {
        RandomLongs.retryAmount = retryAmount;
    }

    private static Numbers<Long> longs() {

        final Random random = ThreadLocalRandom.current();

        return new BoundNumbers<>(Long.class, new LongOperations(random), retryAmount, random);
    }

    /**
     * Generate a random positive or negative long value of any size.
     */
    public static Long someLong() {
        return longs().someNumber();
    }

    /**
     * Generate a random positive long value of any size. This includes 0.
     */
    public static Long somePositiveLong() {
        return longs().somePositiveNumber();
    }

    /**
     * Generate a random negative long value of any size. This includes 0.
     */
    public static Long someNegativeLong() {
        return longs().someNegativeNumber();
    }

    /**
     * Generate a random long value of any magnitude greater than or equal to the supplied bound.
     */
    public static Long someLongGreaterThan(Long bound) {
        return longs().someNumberGreaterThan(bound);
    }

    /**
     * Generate a random long value less than or equal to the supplied bound. Could produce a negative value of any
     * magnitude.
     */
    public static Long someLongLessThan(Long bound) {
        return longs().someNumberLessThan(bound);
    }

    /**
     * Generate a random long value that falls between a min, inclusive, and max, exclusive.
     */
    public static Long someLongBetween(Long min, Long max) {
        return longs().someNumberBetween(min, max);
    }

    /**
     * Generate an iterable that contains random longs with a random length.
     */
    public static NumbersIterable<Long> someLongs() {
        return longs().someNumbers();
    }

    /**
     * Generate an iterable that contains random longs with a fixed length.
     */
    public static NumbersIterable<Long> someLongs(int length) {
        return longs().someNumbers(length);
    }
}

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
 * Simple helper methods for generating random doubles of varying size.
 *
 * @author Karl Bennett
 */
public class RandomDoubles {

    private static int retryAmount = DEFAULT_RETRY_AMOUNT;

    static void setRetryAmount(int retryAmount) {
        RandomDoubles.retryAmount = retryAmount;
    }

    private static Numbers<Double> doubles() {

        final Random random = ThreadLocalRandom.current();

        return new BoundNumbers<>(Double.class, new DoubleOperations(random), retryAmount, random);
    }

    /**
     * Generate a random positive or negative double value of any size.
     */
    public static Double someDouble() {
        return doubles().someNumber();
    }

    /**
     * Generate a random positive double value of any size. This includes 0.
     */
    public static Double somePositiveDouble() {
        return doubles().somePositiveNumber();
    }

    /**
     * Generate a random negative double value of any size. This includes 0.
     */
    public static Double someNegativeDouble() {
        return doubles().someNegativeNumber();
    }

    /**
     * Generate a random double value of any magnitude greater than or equal to the supplied bound.
     */
    public static Double someDoubleGreaterThan(Double bound) {
        return doubles().someNumberGreaterThan(bound);
    }

    /**
     * Generate a random double value less than or equal to the supplied bound. Could produce a negative value of any
     * magnitude.
     */
    public static Double someDoubleLessThan(Double bound) {
        return doubles().someNumberLessThan(bound);
    }

    /**
     * Generate a random double value that falls between a min, inclusive, and max, exclusive.
     */
    public static Double someDoubleBetween(Double min, Double max) {
        return doubles().someNumberBetween(min, max);
    }

    /**
     * Generate an iterable that contains random doubles with a random length.
     */
    public static NumbersIterable<Double> someDoubles() {
        return doubles().someNumbers();
    }

    /**
     * Generate an iterable that contains random doubles with a fixed length.
     */
    public static NumbersIterable<Double> someDoubles(int length) {
        return doubles().someNumbers(length);
    }
}

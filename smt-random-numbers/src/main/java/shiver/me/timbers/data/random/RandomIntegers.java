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
 * Simple helper methods for generating random integers of varying size.
 *
 * @author Karl Bennett
 */
public class RandomIntegers {

    private static int retryAmount = DEFAULT_RETRY_AMOUNT;

    static void setRetryAmount(int retryAmount) {
        RandomIntegers.retryAmount = retryAmount;
    }

    private static Numbers<Integer> integers() {

        final Random random = ThreadLocalRandom.current();

        return new BoundNumbers<>(Integer.class, new IntegerOperations(random), retryAmount, random);
    }

    /**
     * Generate a random positive or negative integer value of any size.
     */
    public static Integer someInteger() {
        return integers().someNumber();
    }

    /**
     * Generate a random positive integer value of any size. This includes 0.
     */
    public static Integer somePositiveInteger() {
        return integers().somePositiveNumber();
    }

    /**
     * Generate a random negative integer value of any size. This includes 0.
     */
    public static Integer someNegativeInteger() {
        return integers().someNegativeNumber();
    }

    /**
     * Generate a random integer value of any magnitude greater than or equal to the supplied bound.
     */
    public static Integer someIntegerGreaterThan(Integer bound) {
        return integers().someNumberGreaterThan(bound);
    }

    /**
     * Generate a random integer value less than or equal to the supplied bound. Could produce a negative value of any
     * magnitude.
     */
    public static Integer someIntegerLessThan(Integer bound) {
        return integers().someNumberLessThan(bound);
    }

    /**
     * Generate a random integer value that falls between the two min and max values inclusive.
     */
    public static Integer someIntegerBetween(Integer min, Integer max) {
        return integers().someNumberBetween(min, max);
    }

    /**
     * Generate a list of integers of a random length that contains random integers.
     */
    public static NumbersIterable<Integer> someIntegers() {
        return integers().someNumbers();
    }

    /**
     * Generate a list of integers of a fixed length that contains random integers.
     */
    public static NumbersIterable<Integer> someIntegers(int length) {
        return integers().someNumbers(length);
    }
}

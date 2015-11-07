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
 * Simple helper methods for generating random floats of varying size.
 *
 * @author Karl Bennett
 */
public class RandomFloats {

    private static int retryAmount = DEFAULT_RETRY_AMOUNT;

    static void setRetryAmount(int retryAmount) {
        RandomFloats.retryAmount = retryAmount;
    }

    private static Numbers<Float> floats() {

        final Random random = ThreadLocalRandom.current();

        return new BoundNumbers<>(Float.class, new FloatOperations(random), retryAmount, random);
    }

    /**
     * Generate a random positive or negative float value of any size.
     */
    public static Float someFloat() {
        return floats().someNumber();
    }

    /**
     * Generate a random positive float value of any size. This includes 0.
     */
    public static Float somePositiveFloat() {
        return floats().somePositiveNumber();
    }

    /**
     * Generate a random negative float value of any size. This includes 0.
     */
    public static Float someNegativeFloat() {
        return floats().someNegativeNumber();
    }

    /**
     * Generate a random float value of any magnitude greater than or equal to the supplied bound.
     */
    public static Float someFloatGreaterThan(Float bound) {
        return floats().someNumberGreaterThan(bound);
    }

    /**
     * Generate a random float value less than or equal to the supplied bound. Could produce a negative value of any
     * magnitude.
     */
    public static Float someFloatLessThan(Float bound) {
        return floats().someNumberLessThan(bound);
    }

    /**
     * Generate a random float value that falls between a min, inclusive, and max, exclusive.
     */
    public static Float someFloatBetween(Float min, Float max) {
        return floats().someNumberBetween(min, max);
    }

    /**
     * Generate a list of floats of a random length that contains random floats.
     */
    public static NumbersIterable<Float> someFloats() {
        return floats().someNumbers();
    }

    /**
     * Generate a list of floats of a fixed length that contains random floats.
     */
    public static NumbersIterable<Float> someFloats(int length) {
        return floats().someNumbers(length);
    }
}

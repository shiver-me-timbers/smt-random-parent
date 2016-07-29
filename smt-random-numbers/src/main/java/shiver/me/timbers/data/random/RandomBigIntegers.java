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

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static shiver.me.timbers.data.random.Retries.DEFAULT_RETRY_AMOUNT;

/**
 * Simple helper methods for generating random BigIntegers of varying size.
 *
 * @author Karl Bennett
 */
public class RandomBigIntegers {

    private static int retryAmount = DEFAULT_RETRY_AMOUNT;

    static void setRetryAmount(int retryAmount) {
        RandomBigIntegers.retryAmount = retryAmount;
    }

    private static Numbers<BigInteger> bigIntegers() {

        final Random random = ThreadLocalRandom.current();

        final BigIntegerOperations operations = new BigIntegerOperations(random, new RandomBigIntegerFactory(),
            retryAmount);

        return new BigNumbers<>(BigInteger.class, operations, random);
    }

    /**
     * Generate a random positive or negative BigInteger value of any size.
     */
    public static BigInteger someBigInteger() {
        return bigIntegers().someNumber();
    }

    /**
     * Generate a random positive BigInteger value of any size. This includes 0.
     */
    public static BigInteger somePositiveBigInteger() {
        return bigIntegers().somePositiveNumber();
    }

    /**
     * Generate a random negative BigInteger value of any size. This includes 0.
     */
    public static BigInteger someNegativeBigInteger() {
        return bigIntegers().someNegativeNumber();
    }

    /**
     * Generate a random BigInteger value of any magnitude greater than or equal to the supplied bound.
     */
    public static BigInteger someBigIntegerGreaterThan(BigInteger bound) {
        return bigIntegers().someNumberGreaterThan(bound);
    }

    /**
     * Generate a random BigInteger value less than or equal to the supplied bound. Could produce a negative value of any
     * magnitude.
     */
    public static BigInteger someBigIntegerLessThan(BigInteger bound) {
        return bigIntegers().someNumberLessThan(bound);
    }

    /**
     * Generate a random BigInteger value that falls between a min, inclusive, and max, exclusive.
     */
    public static BigInteger someBigIntegerBetween(BigInteger min, BigInteger max) {
        return bigIntegers().someNumberBetween(min, max);
    }

    /**
     * Generate an iterable that contains random BigIntegers with a random length.
     */
    public static NumbersIterable<BigInteger> someBigIntegers() {
        return bigIntegers().someNumbers();
    }

    /**
     * Generate an iterable that contains random BigIntegers with a fixed length.
     */
    public static NumbersIterable<BigInteger> someBigIntegers(int length) {
        return bigIntegers().someNumbers(length);
    }
}

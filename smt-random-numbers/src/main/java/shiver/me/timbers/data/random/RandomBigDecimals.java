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

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static shiver.me.timbers.data.random.Retries.DEFAULT_RETRY_AMOUNT;

/**
 * Simple helper methods for generating random BigDecimals of varying size.
 *
 * @author Karl Bennett
 */
public class RandomBigDecimals {

    private static int retryAmount = DEFAULT_RETRY_AMOUNT;

    static void setRetryAmount(int retryAmount) {
        RandomBigDecimals.retryAmount = retryAmount;
    }

    private static Numbers<BigDecimal> bigDecimals() {

        final Random random = ThreadLocalRandom.current();

        final BigDecimalOperations operations = new BigDecimalOperations(random, new RandomBigDecimalFactory(),
            retryAmount);

        return new BigNumbers<>(BigDecimal.class, operations, random);
    }

    /**
     * Generate a random positive or negative BigDecimal value of any size.
     */
    public static BigDecimal someBigDecimal() {
        return bigDecimals().someNumber();
    }

    /**
     * Generate a random positive BigDecimal value of any size. This includes 0.
     */
    public static BigDecimal somePositiveBigDecimal() {
        return bigDecimals().somePositiveNumber();
    }

    /**
     * Generate a random negative BigDecimal value of any size. This includes 0.
     */
    public static BigDecimal someNegativeBigDecimal() {
        return bigDecimals().someNegativeNumber();
    }

    /**
     * Generate a random BigDecimal value of any magnitude greater than or equal to the supplied bound.
     */
    public static BigDecimal someBigDecimalGreaterThan(BigDecimal bound) {
        return bigDecimals().someNumberGreaterThan(bound);
    }

    /**
     * Generate a random BigDecimal value less than or equal to the supplied bound. Could produce a negative value of any
     * magnitude.
     */
    public static BigDecimal someBigDecimalLessThan(BigDecimal bound) {
        return bigDecimals().someNumberLessThan(bound);
    }

    /**
     * Generate a random BigDecimal value that falls between the two min and max values inclusive.
     */
    public static BigDecimal someBigDecimalBetween(BigDecimal min, BigDecimal max) {
        return bigDecimals().someNumberBetween(min, max);
    }

    /**
     * Generate a list of BigDecimals of a random length that contains random BigDecimals.
     */
    public static NumbersIterable<BigDecimal> someBigDecimals() {
        return bigDecimals().someNumbers();
    }

    /**
     * Generate a list of BigDecimals of a fixed length that contains random BigDecimals.
     */
    public static NumbersIterable<BigDecimal> someBigDecimals(int length) {
        return bigDecimals().someNumbers(length);
    }
}

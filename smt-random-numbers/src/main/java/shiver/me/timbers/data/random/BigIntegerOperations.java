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
import java.util.concurrent.Callable;

import static java.lang.String.format;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static shiver.me.timbers.data.random.Retries.retry;

/**
 * @author Karl Bennett
 */
class BigIntegerOperations extends AbstractOperations<BigInteger> implements NumberOperations<BigInteger> {

    private static final BigInteger NEGATIVE_ONE = BigInteger.valueOf(-1);

    private final Random random;
    private final RandomBigNumberFactory<BigInteger> randomBigNumberFactory;
    private final int retryAmount;

    BigIntegerOperations(Random random, RandomBigNumberFactory<BigInteger> randomBigNumberFactory, int retryAmount) {
        super(random);
        this.random = random;
        this.randomBigNumberFactory = randomBigNumberFactory;
        this.retryAmount = retryAmount;
    }

    @Override
    public BigInteger someNumber() {
        return randomBigNumberFactory.create(128, random);
    }

    @Override
    public boolean isPositive(BigInteger number) {
        return 0 < number.compareTo(ZERO);
    }

    @Override
    public boolean isNegative(BigInteger number) {
        return 0 > number.compareTo(ZERO);
    }

    @Override
    public BigInteger someNumber(final BigInteger bound) {

        return retry(retryAmount, new Callable<BigInteger>() {
            @Override
            public BigInteger call() throws Exception {

                final BigInteger number = randomBigNumberFactory.create(bound.bitLength(), random);

                if (0 > number.compareTo(bound)) {
                    return number;
                }

                throw new IllegalStateException(format("Could not generate a BigInteger less than %s.", bound));
            }
        });
    }

    @Override
    public BigInteger switchSign(BigInteger number) {
        return number.multiply(NEGATIVE_ONE);
    }

    @Override
    public BigInteger abs(BigInteger number) {
        return number.abs();
    }

    @Override
    public BigInteger plus(BigInteger left, BigInteger right) {
        return left.add(right);
    }

    @Override
    public BigInteger minus(BigInteger left, BigInteger right) {
        return left.subtract(right);
    }

    @Override
    public BigInteger inc(BigInteger value) {
        return value.add(ONE);
    }

    @Override
    public boolean greaterThan(BigInteger left, BigInteger right) {
        return 0 < left.compareTo(right);
    }

    @Override
    public boolean isInBetween(BigInteger min, BigInteger max, BigInteger value) {
        return !(0 > value.compareTo(min) || 0 < value.compareTo(max));
    }
}

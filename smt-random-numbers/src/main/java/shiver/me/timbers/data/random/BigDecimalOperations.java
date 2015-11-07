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
import java.util.concurrent.Callable;

import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static shiver.me.timbers.data.random.Retries.retry;

/**
 * @author Karl Bennett
 */
class BigDecimalOperations extends AbstractOperations<BigDecimal> implements NumberOperations<BigDecimal> {

    private static final int SCALE = 128;
    private static final BigDecimal NEGATIVE_ONE = BigDecimal.valueOf(-1);

    private final Random random;
    private final RandomBigNumberFactory<BigDecimal> randomBigNumberFactory;
    private final int retryAmount;

    BigDecimalOperations(Random random, RandomBigNumberFactory<BigDecimal> randomBigNumberFactory, int retryAmount) {
        super(random);
        this.random = random;
        this.randomBigNumberFactory = randomBigNumberFactory;
        this.retryAmount = retryAmount;
    }

    @Override
    public BigDecimal someNumber() {
        return randomBigNumberFactory.create(SCALE, random);
    }

    @Override
    public boolean isPositive(BigDecimal number) {
        return 0 < number.compareTo(ZERO);
    }

    @Override
    public boolean isNegative(BigDecimal number) {
        return 0 > number.compareTo(ZERO);
    }

    @Override
    public BigDecimal someNumber(final BigDecimal bound) {

        return retry(retryAmount, new Callable<BigDecimal>() {
            @Override
            public BigDecimal call() throws Exception {

                final int scale = bound.toBigInteger().bitLength();

                final BigDecimal number = randomBigNumberFactory.create(scale, random);

                if (0 > number.compareTo(bound)) {
                    return number;
                }

                throw new IllegalStateException(format("Could not generate a BigDecimal less than %s.", bound));
            }
        });
    }

    @Override
    public BigDecimal switchSign(BigDecimal number) {
        return number.multiply(NEGATIVE_ONE);
    }

    @Override
    public BigDecimal abs(BigDecimal number) {
        return number.abs();
    }

    @Override
    public BigDecimal plus(BigDecimal left, BigDecimal right) {
        return left.add(right);
    }

    @Override
    public BigDecimal minus(BigDecimal left, BigDecimal right) {
        return left.subtract(right);
    }

    @Override
    public boolean greaterThan(BigDecimal left, BigDecimal right) {
        return 0 < left.compareTo(right);
    }

    @Override
    public boolean isInBetween(BigDecimal min, BigDecimal max, BigDecimal value) {
        return !(0 > value.compareTo(min) || 0 < value.compareTo(max));
    }
}

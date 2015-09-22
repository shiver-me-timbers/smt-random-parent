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

import java.util.concurrent.Callable;

import static java.lang.String.format;
import static shiver.me.timbers.data.random.Retries.retry;

/**
 * A generic implementation of the methods that generate different types of random numbers. This logic can be shared
 * across all the built in Java {@link Number}s.
 *
 * @author Karl Bennett
 */
class BoundSingleNumbers<N extends Number> implements SingleNumbers<N> {

    private final BoundNumberOperations<N> ops;
    private final OverflowChecker<N> ofc;
    private final int retryAmount;

    BoundSingleNumbers(BoundNumberOperations<N> ops, OverflowChecker<N> ofc, int retryAmount) {
        this.ops = ops;
        this.ofc = ofc;
        this.retryAmount = retryAmount;
    }

    @Override
    public N someNumber() {
        return ops.someNumber();
    }

    @Override
    public N somePositiveNumber() {

        final N value = ops.someNumber();

        if (ops.isPositive(value)) {
            return value;
        }

        if (ops.min().equals(value)) {
            return ops.max();
        }

        return ops.switchSign(value);
    }

    @Override
    public N someNegativeNumber() {

        final N value = ops.someNumber();

        if (ops.isNegative(value)) {
            return value;
        }

        if (ops.max().equals(value)) {
            return ops.min();
        }

        return ops.switchSign(value);
    }

    @Override
    public N someNumberGreaterThan(final N bound) {

        return retry(retryAmount, new MagnitudeCallable(bound) {
            @Override
            N someFixedSignNumber() {
                return somePositiveNumber();
            }
        });
    }

    @Override
    public N someNumberLessThan(final N bound) {

        return retry(retryAmount, new MagnitudeCallable(bound) {
            @Override
            N someFixedSignNumber() {
                return someNegativeNumber();
            }
        });
    }

    @Override
    public N someNumberBetween(final N min, final N max) {

        if (ops.greaterThan(min, max)) {
            throw new IllegalStateException(format("Min must be less than max. Min: %s, Max: %s.", min, max));
        }

        if (ops.min().equals(min) && ops.max().equals(max)) {
            return ops.someNumber();
        }

        if (ofc.willNotOverflowIfSubtracted(max, min)) {

            final N delta = ops.minus(max, min);

            if (ops.greaterThan(ops.max(), delta)) {

                final N result = ops.someNumber(ops.inc(delta));

                if (ofc.willNotOverflowIfSummed(min, result)) {
                    return ops.plus(min, result);
                }
            }
        }

        return retry(retryAmount,
            new Callable<N>() {
                @Override
                public N call() throws Exception {

                    final N value = ops.someNumber();

                    if (ops.isInBetween(min, max, value)) {
                        return value;
                    }

                    throw new IllegalStateException(format("Could not generate an Integer in between %s and %s.",
                        min, max));
                }
            }
        );
    }

    private abstract class MagnitudeCallable implements Callable<N> {

        private final N size;

        public MagnitudeCallable(N size) {
            this.size = size;
        }

        @Override
        public N call() throws Exception {

            final N result = someFixedSignNumber();

            if (ofc.willNotOverflowIfSummed(size, result)) {
                return ops.plus(size, result);
            }

            throw new IllegalStateException(
                format(
                    "Could not generate an Integer greater than %s without exceeding Integer.MAX_VALUE.",
                    size
                )
            );
        }

        abstract N someFixedSignNumber();
    }
}

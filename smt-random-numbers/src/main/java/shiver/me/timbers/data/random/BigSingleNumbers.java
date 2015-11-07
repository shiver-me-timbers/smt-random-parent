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

import static java.lang.String.format;

/**
 * A generic implementation of the methods that generate different types of random numbers. This logic can be shared
 * across all the built in Java {@link java.math.BigInteger} and {@link java.math.BigDecimal}.
 *
 * @author Karl Bennett
 */
class BigSingleNumbers<N extends Number> implements SingleNumbers<N> {

    private final NumberOperations<N> ops;

    BigSingleNumbers(NumberOperations<N> ops) {
        this.ops = ops;
    }

    public N someNumber() {
        return ops.someNumber();
    }

    public N somePositiveNumber() {

        final N value = ops.someNumber();

        if (ops.isPositive(value)) {
            return value;
        }

        return ops.switchSign(value);
    }

    public N someNegativeNumber() {

        final N value = ops.someNumber();

        if (ops.isNegative(value)) {
            return value;
        }

        return ops.switchSign(value);
    }

    public N someNumberGreaterThan(final N bound) {

        return ops.plus(bound, somePositiveNumber());
    }

    public N someNumberLessThan(final N bound) {

        return ops.plus(bound, someNegativeNumber());
    }

    public N someNumberBetween(final N min, final N max) {

        if (ops.greaterThan(min, max)) {
            throw new IllegalStateException(format("Min must be less than max. Min: %s, Max: %s.", min, max));
        }

        final N delta = ops.minus(max, min);

        final N result = ops.someNumber(delta);

        return ops.plus(min, result);
    }
}

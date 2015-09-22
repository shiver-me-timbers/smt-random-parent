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

package shiver.me.timbers.data.random.test;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class IsANumber<N extends Number> extends TypeSafeMatcher<N> {

    public static IsANumber<Byte> isAByte() {

        return new IsANumber<Byte>() {
            @Override
            protected boolean lessThanOrEqualToMax(Byte value) {
                return value <= Byte.MAX_VALUE;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(Byte value) {
                return value >= Byte.MIN_VALUE;
            }
        };
    }

    public static IsANumber<Short> isAShort() {

        return new IsANumber<Short>() {
            @Override
            protected boolean lessThanOrEqualToMax(Short value) {
                return value <= Short.MAX_VALUE;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(Short value) {
                return value >= Short.MIN_VALUE;
            }
        };
    }

    public static IsANumber<Integer> isAnInteger() {

        return new IsANumber<Integer>() {
            @Override
            protected boolean lessThanOrEqualToMax(Integer value) {
                return value <= Integer.MAX_VALUE;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(Integer value) {
                return value >= Integer.MIN_VALUE;
            }
        };
    }

    public static IsANumber<Float> isAFloat() {

        return new IsANumber<Float>() {
            @Override
            protected boolean lessThanOrEqualToMax(Float value) {
                return value <= Float.MAX_VALUE;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(Float value) {
                return value >= -Float.MAX_VALUE;
            }
        };
    }

    public static IsANumber<Long> isALong() {

        return new IsANumber<Long>() {
            @Override
            protected boolean lessThanOrEqualToMax(Long value) {
                return value <= Long.MAX_VALUE;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(Long value) {
                return value >= Long.MIN_VALUE;
            }
        };
    }

    public static IsANumber<Double> isADouble() {

        return new IsANumber<Double>() {
            @Override
            protected boolean lessThanOrEqualToMax(Double value) {
                return value <= Double.MAX_VALUE;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(Double value) {
                return value >= -Double.MAX_VALUE;
            }
        };
    }

    public static IsANumber<BigInteger> isABigInteger() {

        return new IsANumber<BigInteger>() {
            @Override
            protected boolean lessThanOrEqualToMax(BigInteger value) {
                return value != null;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(BigInteger value) {
                return value != null;
            }
        };
    }

    public static IsANumber<BigDecimal> isABigDecimal() {

        return new IsANumber<BigDecimal>() {
            @Override
            protected boolean lessThanOrEqualToMax(BigDecimal value) {
                return value != null;
            }

            @Override
            protected boolean greaterThanOrEqualToMin(BigDecimal value) {
                return value != null;
            }
        };
    }

    private N value;

    @Override
    protected boolean matchesSafely(N value) {
        this.value = value;
        return greaterThanOrEqualToMin(value) && lessThanOrEqualToMax(value);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Value to be a number. ");
        description.appendValue(value);
    }

    protected abstract boolean lessThanOrEqualToMax(N value);

    protected abstract boolean greaterThanOrEqualToMin(N value);
}

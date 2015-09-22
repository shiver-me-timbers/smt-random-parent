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

/**
 * @author Karl Bennett
 */
class ShortOperations extends AbstractOperations<Short> implements BoundNumberOperations<Short> {

    private final Random random;

    public ShortOperations(Random random) {
        super(random);
        this.random = random;
    }

    @Override
    public Short someNumber() {
        return (short) random.nextInt(Short.MAX_VALUE + 1);
    }

    @Override
    public boolean isPositive(Short number) {
        return NumberUtils.isPositive(number);
    }

    @Override
    public boolean isNegative(Short number) {
        return NumberUtils.isNegative(number);
    }

    @Override
    public Short someNumber(Short bound) {
        return (short) random.nextInt(bound);
    }

    @Override
    public Short min() {
        return Short.MIN_VALUE;
    }

    @Override
    public Short max() {
        return Short.MAX_VALUE;
    }

    @Override
    public Short switchSign(Short number) {
        return (short) NumberUtils.switchSign(number);
    }

    @Override
    public Short abs(Short number) {
        return (short) Math.abs(number);
    }

    @Override
    public Short plus(Short left, Short right) {
        return (short) (left + right);
    }

    @Override
    public Short minus(Short left, Short right) {
        return (short) (left - right);
    }

    @Override
    public Short inc(Short value) {
        return (short) (value + 1);
    }

    @Override
    public boolean greaterThan(Short left, Short right) {
        return left > right;
    }

    @Override
    public boolean isInBetween(Short min, Short max, Short value) {
        return NumberUtils.isInBetween(min, max, value);
    }
}

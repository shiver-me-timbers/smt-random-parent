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
class LongOperations extends AbstractOperations<Long> implements BoundNumberOperations<Long> {

    private final Random random;

    LongOperations(Random random) {
        super(random);
        this.random = random;
    }

    @Override
    public Long someNumber() {
        return random.nextLong();
    }

    @Override
    public boolean isPositive(Long number) {
        return NumberUtils.isPositive(number);
    }

    @Override
    public boolean isNegative(Long number) {
        return NumberUtils.isNegative(number);
    }

    @Override
    public Long someNumber(Long bound) {
        return (long) (random.nextDouble() * bound);
    }

    @Override
    public Long min() {
        return Long.MIN_VALUE;
    }

    @Override
    public Long max() {
        return Long.MAX_VALUE;
    }

    @Override
    public Long switchSign(Long number) {
        return NumberUtils.switchSign(number);
    }

    @Override
    public Long abs(Long number) {
        return Math.abs(number);
    }

    @Override
    public Long plus(Long left, Long right) {
        return left + right;
    }

    @Override
    public Long minus(Long left, Long right) {
        return left - right;
    }

    @Override
    public Long inc(Long value) {
        return value + 1;
    }

    @Override
    public boolean greaterThan(Long left, Long right) {
        return left > right;
    }

    @Override
    public boolean isInBetween(Long min, Long max, Long value) {
        return NumberUtils.isInBetween(min, max, value);
    }
}

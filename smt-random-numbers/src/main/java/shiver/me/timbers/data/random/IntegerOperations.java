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
class IntegerOperations extends AbstractOperations<Integer> implements BoundNumberOperations<Integer> {

    private final Random random;

    IntegerOperations(Random random) {
        super(random);
        this.random = random;
    }

    @Override
    public Integer someNumber() {
        return random.nextInt();
    }

    @Override
    public boolean isPositive(Integer number) {
        return NumberUtils.isPositive(number);
    }

    @Override
    public boolean isNegative(Integer number) {
        return NumberUtils.isNegative(number);
    }

    @Override
    public Integer someNumber(Integer bound) {
        return random.nextInt(bound);
    }

    @Override
    public Integer min() {
        return Integer.MIN_VALUE;
    }

    @Override
    public Integer max() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Integer switchSign(Integer number) {
        return (int) NumberUtils.switchSign(number);
    }

    @Override
    public Integer abs(Integer number) {
        return Math.abs(number);
    }

    @Override
    public Integer plus(Integer left, Integer right) {
        return left + right;
    }

    @Override
    public Integer minus(Integer left, Integer right) {
        return left - right;
    }

    @Override
    public boolean greaterThan(Integer left, Integer right) {
        return left > right;
    }

    @Override
    public boolean isInBetween(Integer min, Integer max, Integer value) {
        return NumberUtils.isInBetween(min, max, value);
    }
}

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
class DoubleOperations extends AbstractOperations<Double> implements BoundNumberOperations<Double> {

    private final Random random;

    DoubleOperations(Random random) {
        super(random);
        this.random = random;
    }

    @Override
    public Double someNumber() {
        return random.nextDouble() * random.nextLong();
    }

    @Override
    public boolean isPositive(Double number) {
        return NumberUtils.isPositive(number);
    }

    @Override
    public boolean isNegative(Double number) {
        return NumberUtils.isNegative(number);
    }

    @Override
    public Double someNumber(Double bound) {
        return random.nextDouble() * bound;
    }

    @Override
    public Double min() {
        return -Double.MAX_VALUE;
    }

    @Override
    public Double max() {
        return Double.MAX_VALUE;
    }

    @Override
    public Double switchSign(Double number) {
        return NumberUtils.switchSign(number);
    }

    @Override
    public Double abs(Double number) {
        return Math.abs(number);
    }

    @Override
    public Double plus(Double left, Double right) {
        return left + right;
    }

    @Override
    public Double minus(Double left, Double right) {
        return left - right;
    }

    @Override
    public Double inc(Double value) {
        return value + 1;
    }

    @Override
    public boolean greaterThan(Double left, Double right) {
        return left > right;
    }

    @Override
    public boolean isInBetween(Double min, Double max, Double value) {
        return NumberUtils.isInBetween(min, max, value);
    }
}

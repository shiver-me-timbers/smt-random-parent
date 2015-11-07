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
class FloatOperations extends AbstractOperations<Float> implements BoundNumberOperations<Float> {

    private final Random random;

    FloatOperations(Random random) {
        super(random);
        this.random = random;
    }

    @Override
    public Float someNumber() {
        return random.nextFloat() * random.nextInt();
    }

    @Override
    public boolean isPositive(Float number) {
        return NumberUtils.isPositive(number);
    }

    @Override
    public boolean isNegative(Float number) {
        return NumberUtils.isNegative(number);
    }

    @Override
    public Float someNumber(Float bound) {
        return random.nextFloat() * bound;
    }

    @Override
    public Float min() {
        return -Float.MAX_VALUE;
    }

    @Override
    public Float max() {
        return Float.MAX_VALUE;
    }

    @Override
    public Float switchSign(Float number) {
        return (float) NumberUtils.switchSign(number);
    }

    @Override
    public Float abs(Float number) {
        return Math.abs(number);
    }

    @Override
    public Float plus(Float left, Float right) {
        return left + right;
    }

    @Override
    public Float minus(Float left, Float right) {
        return left - right;
    }

    @Override
    public boolean greaterThan(Float left, Float right) {
        return left > right;
    }

    @Override
    public boolean isInBetween(Float min, Float max, Float value) {
        return NumberUtils.isInBetween(min, max, value);
    }
}

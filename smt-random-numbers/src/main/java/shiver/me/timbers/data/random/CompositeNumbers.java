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
class CompositeNumbers<N extends Number> implements Numbers<N> {

    private final SingleNumbers<N> singleNumbers;
    private final MultipleNumbers<N> multipleNumbers;

    public CompositeNumbers(Class<N> type, SingleNumbers<N> singleNumbers, Random random) {
        this(singleNumbers, new GenericMultipleNumbers<>(type, singleNumbers, random));
    }

    public CompositeNumbers(SingleNumbers<N> singleNumbers, MultipleNumbers<N> multipleNumbers) {
        this.singleNumbers = singleNumbers;
        this.multipleNumbers = multipleNumbers;
    }

    @Override
    public N someNumber() {
        return singleNumbers.someNumber();
    }

    @Override
    public N somePositiveNumber() {
        return singleNumbers.somePositiveNumber();
    }

    @Override
    public N someNegativeNumber() {
        return singleNumbers.someNegativeNumber();
    }

    @Override
    public N someNumberGreaterThan(N bound) {
        return singleNumbers.someNumberGreaterThan(bound);
    }

    @Override
    public N someNumberLessThan(N bound) {
        return singleNumbers.someNumberLessThan(bound);
    }

    @Override
    public N someNumberBetween(N min, N max) {
        return singleNumbers.someNumberBetween(min, max);
    }

    @Override
    public NumbersIterable<N> someNumbers() {
        return multipleNumbers.someNumbers();
    }

    @Override
    public NumbersIterable<N> someNumbers(int length) {
        return multipleNumbers.someNumbers(length);
    }

}

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

import static shiver.me.timbers.data.random.NumberUtils.DEFAULT_MAX_ARRAY_SIZE;

/**
 * A generic implementation of the methods that generate random {@link java.util.Collection}s or arrays of different
 * types of {@link Number}s.
 *
 * @author Karl Bennett
 */
class GenericMultipleNumbers<N extends Number> implements MultipleNumbers<N> {

    private final Class<N> type;
    private final SingleNumbers<N> singleNumbers;
    private final Random random;

    public GenericMultipleNumbers(Class<N> type, SingleNumbers<N> singleNumbers, Random random) {
        this.type = type;
        this.singleNumbers = singleNumbers;
        this.random = random;
    }

    @Override
    public NumbersIterable<N> someNumbers() {
        return someNumbers(random.nextInt(DEFAULT_MAX_ARRAY_SIZE));
    }

    @Override
    public NumbersIterable<N> someNumbers(int length) {
        return new LazyNumbersIterable<>(type, singleNumbers, length);
    }

}

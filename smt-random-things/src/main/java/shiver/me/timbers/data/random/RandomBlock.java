/*
 * Copyright 2016 Karl Bennett
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

import shiver.me.timbers.building.AtomicBlock;

import java.util.Random;

/**
 * @author Karl Bennett
 */
class RandomBlock<T> extends AtomicBlock<T> {

    private final Random random;
    private T[] randomValues;

    public RandomBlock(Random random, T... randomValues) {
        this.random = random;
        this.randomValues = randomValues;
    }

    @Override
    protected T build() {
        return randomValues[random.nextInt(randomValues.length)];
    }
}

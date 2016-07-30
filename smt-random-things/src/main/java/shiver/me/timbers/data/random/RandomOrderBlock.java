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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * This block maintains an internal state so is not thread safe, which means that if it is added to a
 * {@link shiver.me.timbers.building.Builder} it will then make it so that builder is not thread safe even if it
 * contains a thread safe collection.
 *
 * @author Karl Bennett
 */
class RandomOrderBlock<T> extends AtomicBlock<T> {

    private final Random random;
    private final List<T> randomValues;

    RandomOrderBlock(Random random, T... randomValues) {
        this.random = random;
        this.randomValues = new ArrayList<>(asList(randomValues));
    }

    @Override
    protected T build() {
        return randomValues.remove(random.nextInt(randomValues.size()));
    }
}

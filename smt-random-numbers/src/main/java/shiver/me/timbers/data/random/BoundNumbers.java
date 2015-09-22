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
class BoundNumbers<N extends Number> extends CompositeNumbers<N> {

    public BoundNumbers(Class<N> type, BoundNumberOperations<N> operations, int retryAmount, Random random) {
        super(type, new BoundSingleNumbers<>(operations, new NumbersOverflowChecker<>(operations), retryAmount), random);
    }
}

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

import shiver.me.timbers.data.random.test.BoundNumberValues;

import static org.junit.Assert.assertEquals;

class BoundNumberOperationsTests<N extends Number> extends NumberOperationsTests<N> {

    private final BoundNumberValues<N> values;

    BoundNumberOperationsTests(BoundNumberValues<N> values) {
        super(values);
        this.values = values;
    }

    void The_min_number_value_can_be_retrieved(BoundNumberOperations<N> operations) {

        // When
        final N actual = operations.min();

        // Then
        assertEquals(values.minValue(), actual);
    }

    void The_max_number_value_can_be_retrieved(BoundNumberOperations<N> operations) {

        // When
        final N actual = operations.max();

        // Then
        assertEquals(values.maxValue(), actual);
    }
}

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
import shiver.me.timbers.data.random.test.IsANumber;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

class BoundSingleNumbersTests<N extends Number & Comparable> extends SingleNumbersTests<N> {

    private final BoundNumberValues<N> values;
    private final IsANumber<N> isANumber;

    BoundSingleNumbersTests(BoundNumberValues<N> values, IsANumber<N> aNumber) {
        super(values, aNumber);
        this.values = values;
        isANumber = aNumber;
    }

    void A_random_number_greater_than_the_max_number_value_can_not_be_generated(Numbers<N> nm) {

        // When
        nm.someNumberGreaterThan(values.maxValue());
    }

    void A_random_number_less_than_the_min_number_value_can_not_be_generated(Numbers<N> nm) {

        // When
        nm.someNumberLessThan(values.minValue());
    }

    void A_random_number_between_a_range_the_size_of_the_max_number_value_can_be_generated(Numbers<N> nm) {

        // Given
        final N min = values.negativeJustOverHalfMaxValue();
        final N max = values.positiveJustOverHalfMaxValue();

        // When
        final N actual = nm.someNumberBetween(min, max);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(min));
        assertThat(actual, lessThanOrEqualTo(max));
    }

    void A_random_number_between_the_max_ranges_can_be_generated(Numbers<N> nm) {

        // Given
        final N min = values.minValue();
        final N max = values.maxValue();

        // When
        final N actual = nm.someNumberBetween(min, max);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(min));
        assertThat(actual, lessThanOrEqualTo(max));
    }
}

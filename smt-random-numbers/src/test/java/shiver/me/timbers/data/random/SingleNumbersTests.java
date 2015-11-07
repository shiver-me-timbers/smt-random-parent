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

import shiver.me.timbers.data.random.test.IsANumber;
import shiver.me.timbers.data.random.test.NumberValues;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

class SingleNumbersTests<N extends Number & Comparable> {

    private final NumberValues<N> values;
    private final IsANumber<N> isANumber;

    SingleNumbersTests(NumberValues<N> values, IsANumber<N> isANumber) {
        this.values = values;
        this.isANumber = isANumber;
    }

    void A_random_number_can_be_generated(SingleNumbers<N> nm) {

        // When
        final N actual = nm.someNumber();

        // Then
        assertThat(actual, isANumber);
    }

    void A_random_positive_number_can_be_generated(SingleNumbers<N> nm) {

        // When
        final N actual = nm.somePositiveNumber();

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(values.zero()));
    }

    void A_random_negative_number_can_be_generated(SingleNumbers<N> nm) {

        // When
        final N actual = nm.someNegativeNumber();

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, lessThanOrEqualTo(values.zero()));
    }

    void A_random_number_greater_than_a_positive_number_can_be_generated(SingleNumbers<N> nm) {

        // Given
        final N size = values.positive();

        // When
        final N actual = nm.someNumberGreaterThan(size);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(size));
    }

    void A_random_number_greater_than_a_negative_number_can_be_generated(SingleNumbers<N> nm) {

        // Given
        final N size = values.negative();

        // When
        final N actual = nm.someNumberGreaterThan(size);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(size));
    }

    void A_random_number_less_than_a_positive_number_can_be_generated(SingleNumbers<N> nm) {

        // Given
        final N size = values.positive();

        // When
        final N actual = nm.someNumberLessThan(size);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, lessThanOrEqualTo(size));
    }

    void A_random_number_less_than_a_negative_number_can_be_generated(SingleNumbers<N> nm) {

        // Given
        final N size = values.negative();

        // When
        final N actual = nm.someNumberLessThan(size);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, lessThanOrEqualTo(size));
    }

    void A_random_number_between_two_positive_numbers_can_be_generated(SingleNumbers<N> nm) {

        // Given
        final N min = values.positiveMin();
        final N max = values.positiveMax();

        // When
        final N actual = nm.someNumberBetween(min, max);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(min));
        assertThat(actual, lessThan(max));
    }

    void A_random_number_between_two_negative_numbers_can_be_generated(SingleNumbers<N> nm) {

        // Given
        final N min = values.negativeMin();
        final N max = values.negativeMax();

        // When
        final N actual = nm.someNumberBetween(min, max);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(min));
        assertThat(actual, lessThan(max));
    }

    void A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(SingleNumbers<N> nm) {

        // Given
        final N min = values.negativeMin();
        final N max = values.positiveMax();

        // When
        final N actual = nm.someNumberBetween(min, max);

        // Then
        assertThat(actual, isANumber);
        assertThat(actual, greaterThanOrEqualTo(min));
        assertThat(actual, lessThan(max));
    }
}

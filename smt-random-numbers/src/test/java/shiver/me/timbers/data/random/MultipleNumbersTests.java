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

import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.test.TestUtils.toList;

class MultipleNumbersTests<N extends Number & Comparable> {

    private static final int LENGTH = 2;

    private final NumberValues<N> values;
    private final IsANumber<N> isANumber;

    MultipleNumbersTests(NumberValues<N> values, IsANumber<N> aNumber) {
        this.values = values;
        isANumber = aNumber;
    }

    void A_random_length_iterable_of_random_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // When
        final Iterable<N> actual = mn.someNumbers();

        // Then
        if (!actual.iterator().hasNext()) {
            // The random list has the potential of being empty. This is valid behaviour, but when it isn't empty more
            // assertions can be applied.
            return;
        }
        assertThat(toList(actual), hasSize(greaterThan(0)));
        assertThat(actual, everyItem(isANumber));
    }

    public void A_fixed_length_iterable_of_random_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // When
        final Iterable<N> actual = mn.someNumbers(LENGTH);

        // Then
        assertThat(toList(actual), hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
    }

    @SuppressWarnings("unchecked")
    public void A_random_list_of_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // When
        final List<N> actual = mn.someNumbers(LENGTH).list();

        // Then
        assertThat(actual, hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
    }

    public void A_random_array_of_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // When
        final N[] actual = mn.someNumbers(LENGTH).array();

        // Then
        assertThat(actual, arrayWithSize(LENGTH));
        assertThat(asList(actual), everyItem(isANumber));
    }

    public void A_random_set_of_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // When
        final Set<N> actual = mn.someNumbers(LENGTH).set();

        // Then
        assertThat(actual, hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
    }

    public void A_random_iterable_of_positive_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // When
        final Iterable<N> actual = mn.someNumbers(LENGTH).thatArePositive();

        // Then
        assertThat(toList(actual), hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
        assertThat(actual, everyItem(greaterThanOrEqualTo(values.zero())));
    }

    public void A_random_iterable_of_negative_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // When
        final Iterable<N> actual = mn.someNumbers(LENGTH).thatAreNegative();

        // Then
        assertThat(toList(actual), hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
        assertThat(actual, everyItem(lessThanOrEqualTo(values.zero())));
    }

    public void A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(MultipleNumbers<N> mn) {

        // Given
        final N size = values.positive();

        // When
        final Iterable<N> actual = mn.someNumbers(LENGTH).thatAreGreaterThan(size);

        // Then
        assertThat(toList(actual), hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
        assertThat(actual, everyItem(greaterThanOrEqualTo(size)));
    }

    public void A_random_iterable_of_numbers_less_than_a_number_can_be_generated(MultipleNumbers<N> mn) {

        // Given
        final N size = values.positive();

        // When
        final Iterable<N> actual = mn.someNumbers(LENGTH).thatAreLessThan(size);

        // Then
        assertThat(toList(actual), hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
        assertThat(actual, everyItem(lessThanOrEqualTo(size)));
    }

    public void A_random_iterable_of_numbers_between_two_numbers_can_be_generated(MultipleNumbers<N> mn) {

        // Given
        final N min = values.positiveMin();
        final N max = values.positiveMax();

        // When
        final Iterable<N> actual = mn.someNumbers(LENGTH).thatAreBetween(min, max);

        // Then
        assertThat(toList(actual), hasSize(LENGTH));
        assertThat(actual, everyItem(isANumber));
        assertThat(actual, everyItem(greaterThanOrEqualTo(min)));
        assertThat(actual, everyItem(lessThanOrEqualTo(max)));
    }

    @SuppressWarnings("unchecked")
    public void A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(MultipleNumbers<N> mn) {

        // Given
        final int length = 6;
        final N size = values.positive();
        final N min = values.positiveMin();
        final N max = values.positiveMax();

        // When
        final Iterable<N> actual = mn.someNumbers(length)
            .thatAreRandom()
            .thatArePositive()
            .thatAreNegative()
            .thatAreGreaterThan(size)
            .thatAreLessThan(size)
            .thatAreBetween(min, max);

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, everyItem(isANumber));
        assertThat(actual, hasItems(
            isANumber,
            greaterThanOrEqualTo(values.zero()),
            lessThanOrEqualTo(values.zero()),
            greaterThanOrEqualTo(size),
            lessThanOrEqualTo(size),
            allOf(greaterThanOrEqualTo(min), lessThanOrEqualTo(max))
        ));
    }
}

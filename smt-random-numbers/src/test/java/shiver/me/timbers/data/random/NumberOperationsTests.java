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

import shiver.me.timbers.data.random.test.NumberValues;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

class NumberOperationsTests<N extends Number> {

    private final NumberValues<N> values;

    NumberOperationsTests(NumberValues<N> values) {
        this.values = values;
    }

    void Can_check_if_a_number_is_positive(NumberOperations<N> operations) {

        // When
        final boolean positive = operations.isPositive(values.one());
        final boolean negative = operations.isPositive(values.negativeOne());
        final boolean zero = operations.isPositive(values.zero());

        // Then
        assertTrue(positive);
        assertFalse(negative);
        assertFalse(zero);
    }

    void Can_check_if_a_number_is_negative(NumberOperations<N> operations) {

        // When
        final boolean positive = operations.isNegative(values.one());
        final boolean negative = operations.isNegative(values.negativeOne());
        final boolean zero = operations.isNegative(values.zero());

        // Then
        assertFalse(positive);
        assertTrue(negative);
        assertFalse(zero);
    }

    void The_sign_of_a_number_can_be_switched(NumberOperations<N> operations) {

        // Given
        final N negativeOne = values.negativeOne();
        final N one = values.one();

        // When
        final N switchedToPositive = operations.switchSign(negativeOne);
        final N switchedToNegative = operations.switchSign(one);

        // Then
        assertEquals(one, switchedToPositive);
        assertEquals(negativeOne, switchedToNegative);
    }

    void Can_get_the_absolute_value_of_a_number(NumberOperations<N> operations) {

        // When
        final N positive = operations.abs(values.one());
        final N negative = operations.abs(values.negativeOne());
        final N zero = operations.abs(values.zero());

        // Then
        assertEquals(values.one(), positive);
        assertEquals(values.one(), negative);
        assertEquals(values.zero(), zero);
    }

    void A_number_can_be_checked_if_it_is_greater_than_another_number(NumberOperations<N> operations) {

        // When
        final boolean greaterThan = operations.greaterThan(values.two(), values.one());
        final boolean lessThan = operations.greaterThan(values.one(), values.two());

        // Then
        assertTrue(greaterThan);
        assertFalse(lessThan);
    }

    void Two_numbers_can_be_summed(NumberOperations<N> operations) {

        // When
        final N actual = operations.plus(values.one(), values.two());

        // Then
        assertEquals(values.three(), actual);
    }

    void Two_numbers_can_be_subtracted(NumberOperations<N> operations) {

        // When
        final N actual = operations.minus(values.three(), values.two());

        // Then
        assertEquals(values.one(), actual);
    }

    void A_number_can_be_incremented(NumberOperations<N> operations) {

        // When
        final N actual = operations.inc(values.one());

        // Then
        assertEquals(values.two(), actual);
    }

    void A_number_can_be_checked_if_between_two_numbers(NumberOperations<N> operations) {

        // Given
        final N two = values.two();
        final N four = values.four();

        // When
        final boolean isBetween = operations.isInBetween(two, four, values.three());
        final boolean tooSmall = operations.isInBetween(two, four, values.one());
        final boolean tooLarge = operations.isInBetween(two, four, values.five());

        // Then
        assertTrue(isBetween);
        assertFalse(tooSmall);
        assertFalse(tooLarge);
    }

    void A_next_int_can_be_generated(Random random, NumberOperations<N> operations) {

        final int size = 1;
        final Integer expected = 2;

        // Given
        given(random.nextInt(size)).willReturn(expected);

        // When
        final Integer actual = operations.nextInt(size);

        // Then
        assertEquals(expected, actual);
    }
}

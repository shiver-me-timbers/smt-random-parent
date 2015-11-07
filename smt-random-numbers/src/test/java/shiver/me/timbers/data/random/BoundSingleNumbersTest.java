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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static shiver.me.timbers.data.random.test.TestUtils.TEST_RETRY_AMOUNT;

public class BoundSingleNumbersTest {

    private BoundNumberOperations<Number> ops;
    private OverflowChecker<Number> ofc;
    private BoundSingleNumbers<Number> numbers;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {

        ops = mock(BoundNumberOperations.class);
        ofc = mock(OverflowChecker.class);
        numbers = new BoundSingleNumbers<>(ops, ofc, TEST_RETRY_AMOUNT);
    }

    @Test
    public void A_random_number_can_be_produced() {

        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(expected);

        // When
        final Number actual = numbers.someNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_positive_random_number_can_be_produced() {

        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(expected);
        given(ops.isPositive(expected)).willReturn(true);

        // When
        final Number actual = numbers.somePositiveNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_positive_random_number_can_be_produced_for_a_negative_random_result() {

        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isPositive(value)).willReturn(false);
        given(ops.min()).willReturn(mock(Number.class));
        given(ops.switchSign(value)).willReturn(expected);

        // When
        final Number actual = numbers.somePositiveNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void The_max_number_is_produced_if_the_min_number_is_generated_for_a_random_positive_number() {

        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.min()).willReturn(value);
        given(ops.max()).willReturn(expected);

        // When
        final Number actual = numbers.somePositiveNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_requested_negative_random_number_is_produced() {

        final Number expected = mock(Number.class);

        // Given
        given(ops.isNegative(expected)).willReturn(true);
        given(ops.someNumber()).willReturn(expected);

        // When
        final Number actual = numbers.someNegativeNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_requested_negative_random_number_is_produced_for_a_positive_random_result() {

        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isNegative(value)).willReturn(false);
        given(ops.max()).willReturn(mock(Number.class));
        given(ops.switchSign(value)).willReturn(expected);

        // When
        final Number actual = numbers.someNegativeNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void The_min_number_is_produced_if_the_max_number_is_generated_for_a_random_positive_number() {

        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isNegative(value)).willReturn(false);
        given(ops.max()).willReturn(value);
        given(ops.min()).willReturn(expected);

        // When
        final Number actual = numbers.someNegativeNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_number_greater_than_a_requested_size_is_produced() {

        final Number size = mock(Number.class);
        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isPositive(value)).willReturn(true);
        given(ofc.willNotOverflowIfSummed(size, value)).willReturn(true);
        given(ops.plus(size, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberGreaterThan(size);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_number_greater_than_a_requested_size_is_produced_even_if_the_max_number_size_is_exceeded() {

        final Number size = mock(Number.class);
        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isPositive(value)).willReturn(true);
        given(ofc.willNotOverflowIfSummed(size, value)).willReturn(false, true);
        given(ops.plus(size, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberGreaterThan(size);

        // Then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void A_request_for_a_number_greater_than_a_size_may_only_generate_numbers_greater_than_max_integer() {

        final Number size = mock(Number.class);
        final Number value = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isPositive(value)).willReturn(true);
        given(ofc.willNotOverflowIfSummed(size, value)).willReturn(false);

        // When
        numbers.someNumberGreaterThan(size);
    }

    @Test
    public void A_number_less_than_a_requested_size_is_produced() {

        final Number size = mock(Number.class);
        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isNegative(value)).willReturn(true);
        given(ofc.willNotOverflowIfSummed(size, value)).willReturn(true);
        given(ops.plus(size, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberLessThan(size);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_number_less_than_a_requested_size_is_produced_even_if_the_min_number_size_is_exceeded() {

        final Number size = mock(Number.class);
        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isNegative(value)).willReturn(true);
        given(ofc.willNotOverflowIfSummed(size, value)).willReturn(false, true);
        given(ops.plus(size, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberLessThan(size);

        // Then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void A_request_for_a_number_less_than_a_size_may_only_generate_numbers_less_than_min_integer() {

        final Number size = mock(Number.class);
        final Number value = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isNegative(value)).willReturn(true);
        given(ofc.willNotOverflowIfSummed(size, value)).willReturn(false);

        // When
        numbers.someNumberLessThan(size);
    }

    @Test(expected = IllegalStateException.class)
    public void A_number_request_within_a_range_with_the_min_greater_than_the_max_cannot_be_produced() {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);

        // Given
        given(ops.greaterThan(min, max)).willReturn(true);

        // When
        numbers.someNumberBetween(min, max);
    }

    @Test
    public void A_number_within_a_range_is_produced() {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number maxValue = mock(Number.class);
        final Number delta = mock(Number.class);
        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.greaterThan(min, max)).willReturn(false);
        given(ops.min()).willReturn(mock(Number.class));

        given(ofc.willNotOverflowIfSubtracted(max, min)).willReturn(true);

        given(ops.minus(max, min)).willReturn(delta);
        given(ops.max()).willReturn(maxValue);
        given(ops.greaterThan(maxValue, delta)).willReturn(true);

        given(ops.someNumber(delta)).willReturn(value);
        given(ofc.willNotOverflowIfSummed(min, value)).willReturn(true);

        given(ops.plus(min, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberBetween(min, max);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_number_within_a_range_may_produce_a_number_greater_than_the_max_value() {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number maxValue = mock(Number.class);
        final Number delta = mock(Number.class);
        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.greaterThan(min, max)).willReturn(false);
        given(ops.min()).willReturn(min);
        given(ofc.willNotOverflowIfSubtracted(max, min)).willReturn(true);

        given(ops.minus(max, min)).willReturn(delta);
        given(ops.max()).willReturn(maxValue);
        given(ops.greaterThan(maxValue, delta)).willReturn(true);

        given(ops.someNumber(delta)).willReturn(value);
        given(ofc.willNotOverflowIfSummed(min, value)).willReturn(false);

        given(ops.someNumber()).willReturn(expected);
        given(ops.isInBetween(min, max, expected)).willReturn(true);

        // When
        final Number actual = numbers.someNumberBetween(min, max);

        // Then
        assertEquals(expected, actual);
        verify(ofc).willNotOverflowIfSummed(min, value);
    }

    @Test
    public void A_number_within_a_range_greater_than_the_max_value_is_produced() {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.greaterThan(min, max)).willReturn(false);
        given(ops.min()).willReturn(mock(Number.class));
        given(ofc.willNotOverflowIfSubtracted(max, min)).willReturn(false);

        given(ops.someNumber()).willReturn(expected);
        given(ops.isInBetween(min, max, expected)).willReturn(true);

        // When
        final Number actual = numbers.someNumberBetween(min, max);

        // Then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void A_number_request_within_a_range_may_only_generate_numbers_outside_the_range() {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.greaterThan(min, max)).willReturn(false);
        given(ops.min()).willReturn(mock(Number.class));
        given(ofc.willNotOverflowIfSubtracted(max, min)).willReturn(false);

        given(ops.someNumber()).willReturn(expected);
        given(ops.isInBetween(min, max, expected)).willReturn(false);

        // When
        numbers.someNumberBetween(min, max);
    }

    @Test
    public void A_number_within_a_range_that_is_equal_to_the_max_value_can_be_produced() {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number maxValue = mock(Number.class);
        final Number delta = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.greaterThan(min, max)).willReturn(false);

        given(ofc.willNotOverflowIfSubtracted(max, min)).willReturn(true);

        given(ops.minus(max, min)).willReturn(delta);
        given(ops.min()).willReturn(mock(Number.class));
        given(ops.max()).willReturn(maxValue);
        given(ops.greaterThan(maxValue, delta)).willReturn(false);

        given(ops.someNumber()).willReturn(expected);
        given(ops.isInBetween(min, max, expected)).willReturn(true);

        // When
        final Number actual = numbers.someNumberBetween(min, max);

        // Then
        assertEquals(expected, actual);
        verify(ofc, never()).willNotOverflowIfSummed(any(Number.class), any(Number.class));
    }

    @Test
    public void A_number_within_a_range_between_both_max_values_can_be_produced() {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.greaterThan(min, max)).willReturn(false);

        given(ops.min()).willReturn(min);
        given(ops.max()).willReturn(max);

        given(ops.someNumber()).willReturn(expected);

        // When
        final Number actual = numbers.someNumberBetween(min, max);

        // Then
        assertEquals(expected, actual);
    }
}

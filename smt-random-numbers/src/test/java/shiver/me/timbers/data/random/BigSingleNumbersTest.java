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

public class BigSingleNumbersTest {

    private NumberOperations<Number> ops;
    private BigSingleNumbers<Number> numbers;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {

        ops = mock(NumberOperations.class);
        numbers = new BigSingleNumbers<>(ops);
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
        given(ops.switchSign(value)).willReturn(expected);

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
        given(ops.switchSign(value)).willReturn(expected);

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
        given(ops.plus(size, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberGreaterThan(size);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_number_less_than_a_requested_size_is_produced() {

        final Number size = mock(Number.class);
        final Number value = mock(Number.class);
        final Number expected = mock(Number.class);

        // Given
        given(ops.someNumber()).willReturn(value);
        given(ops.isNegative(value)).willReturn(true);
        given(ops.plus(size, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberLessThan(size);

        // Then
        assertEquals(expected, actual);
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

        given(ops.minus(max, min)).willReturn(delta);
        given(ops.greaterThan(maxValue, delta)).willReturn(true);

        given(ops.someNumber(delta)).willReturn(value);

        given(ops.plus(min, value)).willReturn(expected);

        // When
        final Number actual = numbers.someNumberBetween(min, max);

        // Then
        assertEquals(expected, actual);
    }
}

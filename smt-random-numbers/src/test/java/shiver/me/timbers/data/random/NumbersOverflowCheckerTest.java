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
import static org.mockito.Mockito.mock;

public class NumbersOverflowCheckerTest {

    private BoundNumberOperations<Number> ops;
    private NumbersOverflowChecker<Number> checker;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        ops = mock(BoundNumberOperations.class);
        checker = new NumbersOverflowChecker<>(ops);
    }

    @Test
    public void Summing_will_not_overflow_if_left_is_positive_and_right_is_negative() {

        final Number left = mock(Number.class);
        final Number right = mock(Number.class);
        final boolean expected = true;

        // Given
        given(ops.isPositive(left)).willReturn(true);
        given(ops.isNegative(right)).willReturn(true);

        // When
        final boolean actual = checker.willNotOverflowIfSummed(left, right);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Summing_will_not_overflow_if_left_is_negative_and_right_is_positive() {

        final Number left = mock(Number.class);
        final Number right = mock(Number.class);
        final boolean expected = true;

        // Given
        given(ops.isNegative(left)).willReturn(true);
        given(ops.isPositive(right)).willReturn(true);

        // When
        final boolean actual = checker.willNotOverflowIfSummed(left, right);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Summing_will_overflow_if_both_values_are_negative_and_the_left_is_the_min_value() {

        final Number left = mock(Number.class);
        final Number right = mock(Number.class);
        final boolean expected = false;

        // Given
        given(ops.isNegative(left)).willReturn(true);
        given(ops.isNegative(right)).willReturn(true);
        given(ops.min()).willReturn(left);

        // When
        final boolean actual = checker.willNotOverflowIfSummed(left, right);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Summing_will_overflow_if_both_values_are_negative_and_the_right_is_the_min_value() {

        final Number left = mock(Number.class);
        final Number right = mock(Number.class);
        final boolean expected = false;

        // Given
        given(ops.isNegative(left)).willReturn(true);
        given(ops.isNegative(right)).willReturn(true);
        given(ops.min()).willReturn(right);

        // When
        final boolean actual = checker.willNotOverflowIfSummed(left, right);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Summing_will_overflow_if_both_values_are_positive_and_the_left_is_the_max_value() {

        final Number left = mock(Number.class);
        final Number right = mock(Number.class);
        final boolean expected = false;

        // Given
        given(ops.isPositive(left)).willReturn(true);
        given(ops.isPositive(right)).willReturn(true);
        given(ops.min()).willReturn(mock(Number.class));
        given(ops.max()).willReturn(left);

        // When
        final boolean actual = checker.willNotOverflowIfSummed(left, right);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Summing_will_overflow_if_both_values_are_positive_and_the_right_is_the_max_value() {

        final Number left = mock(Number.class);
        final Number right = mock(Number.class);
        final boolean expected = false;

        // Given
        given(ops.isPositive(left)).willReturn(true);
        given(ops.isPositive(right)).willReturn(true);
        given(ops.min()).willReturn(mock(Number.class));
        given(ops.max()).willReturn(right);

        // When
        final boolean actual = checker.willNotOverflowIfSummed(left, right);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_check_if_a_number_will_overflow_if_summed_when_left_an_right_signs_are_different() {

        final Number left = mock(Number.class);
        final Number absLeft = mock(Number.class);
        final Number right = mock(Number.class);
        final Number absRight = mock(Number.class);
        final Number max = mock(Number.class);
        final Number delta = mock(Number.class);
        final boolean expected = true;

        // Given
        given(ops.isPositive(left)).willReturn(true);
        given(ops.isPositive(right)).willReturn(true);
        given(ops.abs(left)).willReturn(absLeft);
        given(ops.abs(right)).willReturn(absRight);
        given(ops.min()).willReturn(mock(Number.class));
        given(ops.max()).willReturn(max);
        given(ops.minus(max, absLeft)).willReturn(delta);
        given(ops.greaterThan(delta, absRight)).willReturn(expected);

        // When
        final boolean actual = checker.willNotOverflowIfSummed(left, right);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_check_if_a_number_will_overflow_if_subtracted() {

        final Number left = mock(Number.class);
        final Number absLeft = mock(Number.class);
        final Number right = mock(Number.class);
        final Number switchSignRight = mock(Number.class);
        final Number absRight = mock(Number.class);
        final Number max = mock(Number.class);
        final Number delta = mock(Number.class);
        final boolean expected = true;

        // Given
        given(ops.switchSign(right)).willReturn(switchSignRight);
        given(ops.isPositive(left)).willReturn(true);
        given(ops.isPositive(switchSignRight)).willReturn(true);
        given(ops.abs(left)).willReturn(absLeft);
        given(ops.abs(switchSignRight)).willReturn(absRight);
        given(ops.min()).willReturn(mock(Number.class));
        given(ops.max()).willReturn(max);
        given(ops.minus(max, absLeft)).willReturn(delta);
        given(ops.greaterThan(delta, absRight)).willReturn(expected);

        // When
        final boolean actual = checker.willNotOverflowIfSubtracted(left, right);

        // Then
        assertEquals(expected, actual);
    }
}

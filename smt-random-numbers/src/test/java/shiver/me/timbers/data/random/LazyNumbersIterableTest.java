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

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyZeroInteractions;
import static shiver.me.timbers.data.random.test.TestUtils.toList;

public class LazyNumbersIterableTest {

    private Class<Number> type;
    private SingleNumbers<Number> singleNumbers;
    private int length;

    private LazyNumbersIterable<Number> iterable;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {

        type = Number.class;
        singleNumbers = mock(SingleNumbers.class);
        length = 2;

        iterable = new LazyNumbersIterable<>(type, singleNumbers, length);
    }

    @Test
    public void Can_create_a_lazy_iterable() throws Exception {

        // Given
        @SuppressWarnings("unchecked")
        final SingleNumbers<Number> singleNumbers = mock(SingleNumbers.class);

        // When
        new LazyNumbersIterable<>(type, singleNumbers, length);

        // Then
        verifyZeroInteractions(singleNumbers);
    }

    @Test
    public void The_iterator_is_only_created_once() throws Exception {

        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumber()).willReturn(one, two);

        // When
        iterable.iterator();
        iterable.iterator();

        // Then
        verify(singleNumbers, times(2)).someNumber();
    }

    @Test
    public void The_same_iterator_is_always_returned() throws Exception {

        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumber()).willReturn(one, two);

        // When
        final List<Number> actual1 = toList(iterable);
        final List<Number> actual2 = toList(iterable);

        // Then
        assertThat(actual1, hasSize(length));
        assertThat(actual1, hasItems(one, two));
        assertEquals(actual1, actual2);
    }

    @Test
    public void Can_convert_to_list() throws Exception {

        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumber()).willReturn(one, two);

        // When
        final List<Number> actual = iterable.list();

        // Then
        assertThat(actual, hasSize(length));
        assertThat(actual, hasItems(one, two));
    }

    @Test
    public void Can_convert_to_array() throws Exception {

        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumber()).willReturn(one, two);

        // When
        final Number[] actual = iterable.array();

        // Then
        assertThat(actual, arrayWithSize(length));
        assertThat(actual, arrayContaining(one, two));
    }

    @Test
    public void Can_convert_to_set() throws Exception {

        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumber()).willReturn(one, two);

        // When
        final Set<Number> actual = iterable.set();

        // Then
        assertThat(actual, hasSize(length));
        assertThat(actual, hasItems(one, two));
    }

    @Test
    public void Can_create_an_iterable_that_only_contains_positive_number() throws Exception {

        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.somePositiveNumber()).willReturn(one, two);

        // When
        final Iterable<Number> actual = iterable.thatArePositive();

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, hasItems(one, two));
    }

    @Test
    public void Can_create_an_iterable_that_only_contains_negative_number() throws Exception {

        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNegativeNumber()).willReturn(one, two);

        // When
        final Iterable<Number> actual = iterable.thatAreNegative();

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, hasItems(one, two));
    }

    @Test
    public void Can_create_an_iterable_that_only_contains_numbers_greater_than_a_number() throws Exception {

        final Number size = mock(Number.class);
        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumberGreaterThan(size)).willReturn(one, two);

        // When
        final Iterable<Number> actual = iterable.thatAreGreaterThan(size);

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, hasItems(one, two));
    }

    @Test
    public void Can_create_an_iterable_that_only_contains_numbers_less_than_a_number() throws Exception {

        final Number size = mock(Number.class);
        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumberLessThan(size)).willReturn(one, two);

        // When
        final Iterable<Number> actual = iterable.thatAreLessThan(size);

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, hasItems(one, two));
    }

    @Test
    public void Can_create_an_iterable_that_only_contains_numbers_between_two_numbers() throws Exception {

        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number one = mock(Number.class);
        final Number two = mock(Number.class);

        // Given
        given(singleNumbers.someNumberBetween(min, max)).willReturn(one, two);

        // When
        final Iterable<Number> actual = iterable.thatAreBetween(min, max);

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, hasItems(one, two));
    }

    @Test
    public void Can_create_an_iterable_that_contains_different_limited_numbers() throws Exception {

        final int length = 6;
        final Number size = mock(Number.class);
        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number one = mock(Number.class);
        final Number two = mock(Number.class);
        final Number three = mock(Number.class);
        final Number four = mock(Number.class);
        final Number five = mock(Number.class);
        final Number six = mock(Number.class);

        // Given
        given(singleNumbers.someNumber()).willReturn(one);
        given(singleNumbers.somePositiveNumber()).willReturn(two);
        given(singleNumbers.someNegativeNumber()).willReturn(three);
        given(singleNumbers.someNumberGreaterThan(size)).willReturn(four);
        given(singleNumbers.someNumberLessThan(size)).willReturn(five);
        given(singleNumbers.someNumberBetween(min, max)).willReturn(six);

        // When
        final Iterable<Number> actual = new LazyNumbersIterable<>(type, singleNumbers, length)
            .thatAreRandom()
            .thatArePositive()
            .thatAreNegative()
            .thatAreGreaterThan(size)
            .thatAreLessThan(size)
            .thatAreBetween(min, max);

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, hasItems(one, two, three, four, five, six));
    }

    @Test
    public void Can_create_an_iterable_that_contains_rotating_number_limitations() throws Exception {

        final int length = 3;
        final Number min = mock(Number.class);
        final Number max = mock(Number.class);
        final Number one = mock(Number.class);
        final Number two = mock(Number.class);
        final Number three = mock(Number.class);

        // Given
        given(singleNumbers.someNumber()).willReturn(one, three);
        given(singleNumbers.someNumberBetween(min, max)).willReturn(two);

        // When
        final Iterable<Number> actual = new LazyNumbersIterable<>(type, singleNumbers, length)
            .thatAreRandom()
            .thatAreBetween(min, max);

        // Then
        assertThat(toList(actual), hasSize(length));
        assertThat(actual, hasItems(one, two, three));
    }
}

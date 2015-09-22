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
import shiver.me.timbers.data.random.test.DoubleValues;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class DoubleOperationsTest {

    private static final BoundNumberOperationsTests<Double> TESTS = new BoundNumberOperationsTests<>(new DoubleValues());

    private Random random;
    private DoubleOperations operations;

    @Before
    public void setUp() {

        random = mock(Random.class);
        operations = new DoubleOperations(random);
    }

    @Test
    public void A_random_integer_can_be_produced() {

        final Double expected = 1.0D;

        // Given
        given(random.nextDouble()).willReturn(0.5D);
        given(random.nextLong()).willReturn(2L);

        // When
        final Double actual = operations.someNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_check_if_an_integer_is_positive() {

        TESTS.Can_check_if_a_number_is_positive(operations);
    }

    @Test
    public void Can_check_if_an_integer_is_negative() {

        TESTS.Can_check_if_a_number_is_negative(operations);
    }

    @Test
    public void A_random_integer_less_than_an_amount_can_be_produced() {

        final Double value = 2.0D;
        final Double expected = 1.0D;

        // Given
        given(random.nextDouble()).willReturn(0.5D);

        // When
        final Double actual = operations.someNumber(value);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void The_min_integer_value_can_be_retrieved() {

        TESTS.The_min_number_value_can_be_retrieved(operations);
    }

    @Test
    public void The_max_integer_value_can_be_retrieved() {

        TESTS.The_max_number_value_can_be_retrieved(operations);
    }

    @Test
    public void The_sign_of_an_integer_can_be_switched() {

        TESTS.The_sign_of_a_number_can_be_switched(operations);
    }

    @Test
    public void Can_get_the_absolute_value_of_an_integer() {

        TESTS.Can_get_the_absolute_value_of_a_number(operations);
    }

    @Test
    public void An_integer_can_be_checked_if_it_is_greater_than_another_integer() {

        TESTS.A_number_can_be_checked_if_it_is_greater_than_another_number(operations);
    }

    @Test
    public void Two_integers_can_be_summed() {

        TESTS.Two_numbers_can_be_summed(operations);
    }

    @Test
    public void Two_integers_can_be_subtracted() {

        TESTS.Two_numbers_can_be_subtracted(operations);
    }

    @Test
    public void An_integer_can_be_incremented() {

        TESTS.A_number_can_be_incremented(operations);
    }

    @Test
    public void An_integer_can_be_checked_if_between_two_integers() {

        TESTS.A_number_can_be_checked_if_between_two_numbers(operations);
    }

    @Test
    public void A_next_int_can_be_generated() {

        TESTS.A_next_int_can_be_generated(random, operations);
    }
}

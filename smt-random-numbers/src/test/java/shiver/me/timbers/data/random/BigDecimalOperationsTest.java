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
import shiver.me.timbers.data.random.test.BigDecimalValues;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BigDecimalOperationsTest {

    private static final NumberOperationsTests<BigDecimal> TESTS = new NumberOperationsTests<>(new BigDecimalValues());

    private Random random;
    private RandomBigNumberFactory<BigDecimal> randomBigNumberFactory;

    private BigDecimalOperations operations;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {

        random = mock(Random.class);

        randomBigNumberFactory = mock(RandomBigNumberFactory.class);

        operations = new BigDecimalOperations(random, randomBigNumberFactory, 1);
    }

    @Test
    public void A_random_integer_can_be_produced() {

        final BigDecimal expected = mock(BigDecimal.class);

        // Given
        given(randomBigNumberFactory.create(128, random)).willReturn(expected);

        // When
        final BigDecimal actual = operations.someNumber();

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

        final int numBits = 1;
        final BigInteger bigInteger = mock(BigInteger.class);
        final BigDecimal range = mock(BigDecimal.class);
        final BigDecimal expected = mock(BigDecimal.class);

        // Given
        given(bigInteger.bitLength()).willReturn(numBits);
        given(range.toBigInteger()).willReturn(bigInteger);
        given(randomBigNumberFactory.create(numBits, random)).willReturn(expected);
        given(expected.compareTo(range)).willReturn(-1);

        // When
        final BigDecimal actual = operations.someNumber(range);

        // Then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_integer_less_than_an_amount_may_fail_to_be_produced() {

        final int numBits = 1;
        final BigInteger bigInteger = mock(BigInteger.class);
        final BigDecimal range = mock(BigDecimal.class);
        final BigDecimal expected = mock(BigDecimal.class);

        // Given
        given(bigInteger.bitLength()).willReturn(numBits);
        given(range.toBigInteger()).willReturn(bigInteger);
        given(randomBigNumberFactory.create(numBits, random)).willReturn(expected);
        given(expected.compareTo(range)).willReturn(1);

        // When
        operations.someNumber(range);
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

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
import shiver.me.timbers.data.random.test.BigIntegerValues;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class BigIntegerOperationsTest {

    private static final NumberOperationsTests<BigInteger> TESTS = new NumberOperationsTests<>(new BigIntegerValues());

    private Random random;
    private RandomBigNumberFactory<BigInteger> randomBigNumberFactory;

    private BigIntegerOperations operations;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {

        random = mock(Random.class);

        randomBigNumberFactory = mock(RandomBigNumberFactory.class);

        operations = new BigIntegerOperations(random, randomBigNumberFactory, 1);
    }

    @Test
    public void A_random_big_big_integer_can_be_produced() {

        final BigInteger expected = mock(BigInteger.class);

        // Given
        given(randomBigNumberFactory.create(128, random)).willReturn(expected);

        // When
        final BigInteger actual = operations.someNumber();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_check_if_a_big_big_integer_is_positive() {

        TESTS.Can_check_if_a_number_is_positive(operations);
    }

    @Test
    public void Can_check_if_a_big_big_integer_is_negative() {

        TESTS.Can_check_if_a_number_is_negative(operations);
    }

    @Test
    public void A_random_big_big_integer_less_than_an_amount_can_be_produced() {

        final int numBits = 1;
        final BigInteger range = mock(BigInteger.class);
        final BigInteger expected = mock(BigInteger.class);

        // Given
        given(range.bitLength()).willReturn(numBits);
        given(randomBigNumberFactory.create(numBits, random)).willReturn(expected);
        given(expected.compareTo(range)).willReturn(-1);

        // When
        final BigInteger actual = operations.someNumber(range);

        // Then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_big_big_integer_less_than_an_amount_may_fail_to_be_produced() {

        final int numBits = 1;
        final BigInteger range = mock(BigInteger.class);
        final BigInteger expected = mock(BigInteger.class);

        // Given
        given(range.bitLength()).willReturn(numBits);
        given(randomBigNumberFactory.create(numBits, random)).willReturn(expected);
        given(expected.compareTo(range)).willReturn(1);

        // When
        operations.someNumber(range);
    }

    @Test
    public void The_sign_of_a_big_big_integer_can_be_switched() {

        TESTS.The_sign_of_a_number_can_be_switched(operations);
    }

    @Test
    public void Can_get_the_absolute_value_of_an_big_integer() {

        TESTS.Can_get_the_absolute_value_of_a_number(operations);
    }

    @Test
    public void A_big_big_integer_can_be_checked_if_it_is_greater_than_another_big_integer() {

        TESTS.A_number_can_be_checked_if_it_is_greater_than_another_number(operations);
    }

    @Test
    public void Two_big_integers_can_be_summed() {

        TESTS.Two_numbers_can_be_summed(operations);
    }

    @Test
    public void Two_big_integers_can_be_subtracted() {

        TESTS.Two_numbers_can_be_subtracted(operations);
    }

    @Test
    public void A_big_big_integer_can_be_checked_if_between_two_big_integers() {

        TESTS.A_number_can_be_checked_if_between_two_numbers(operations);
    }

    @Test
    public void A_next_int_can_be_generated() {

        TESTS.A_next_int_can_be_generated(random, operations);
    }
}

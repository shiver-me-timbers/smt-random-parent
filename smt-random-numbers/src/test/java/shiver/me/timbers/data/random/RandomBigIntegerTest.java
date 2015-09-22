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

import org.junit.Test;
import shiver.me.timbers.data.random.test.BigIntegerValues;

import java.math.BigInteger;

import static shiver.me.timbers.data.random.RandomBigIntegers.someBigInteger;
import static shiver.me.timbers.data.random.RandomBigIntegers.someBigIntegerBetween;
import static shiver.me.timbers.data.random.RandomBigIntegers.someBigIntegerGreaterThan;
import static shiver.me.timbers.data.random.RandomBigIntegers.someBigIntegerLessThan;
import static shiver.me.timbers.data.random.RandomBigIntegers.someBigIntegers;
import static shiver.me.timbers.data.random.RandomBigIntegers.someNegativeBigInteger;
import static shiver.me.timbers.data.random.RandomBigIntegers.somePositiveBigInteger;
import static shiver.me.timbers.data.random.test.IsANumber.isABigInteger;

public class RandomBigIntegerTest {

    private static final BigIntegerValues VALUES = new BigIntegerValues();
    private static final SingleNumbersTests<BigInteger> SNT = new SingleNumbersTests<>(VALUES, isABigInteger());
    private static final MultipleNumbersTests<BigInteger> MNT = new MultipleNumbersTests<>(VALUES, isABigInteger());

    private static final Numbers<BigInteger> BIG_INTEGERS_METHODS = new BigIntegersMethods();

    static {
        RandomBigIntegers.setRetryAmount(100);
    }

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomBigIntegers();
    }

    @Test
    public void A_random_big_integer_can_be_generated() {

        SNT.A_random_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_positive_big_integer_can_be_generated() {

        SNT.A_random_positive_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_negative_big_integer_can_be_generated() {

        SNT.A_random_negative_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_big_integer_greater_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_positive_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_big_integer_greater_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_negative_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_big_integer_less_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_less_than_a_positive_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_big_integer_less_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_less_than_a_negative_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_big_integer_between_two_positive_numbers_can_be_generated() {

        SNT.A_random_number_between_two_positive_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_big_integer_between_two_negative_numbers_can_be_generated() {

        SNT.A_random_number_between_two_negative_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_big_integer_between_a_negative_number_and_a_positive_number_can_be_generated() {

        SNT.A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_length_iterable_of_random_big_integers_can_be_generated() {

        MNT.A_random_length_iterable_of_random_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_fixed_length_iterable_of_random_big_integers_can_be_generated() {

        MNT.A_fixed_length_iterable_of_random_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_list_of_big_integers_can_be_generated() {

        MNT.A_random_list_of_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_array_of_big_integers_can_be_generated() {

        MNT.A_random_array_of_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_set_of_big_integers_can_be_generated() {

        MNT.A_random_set_of_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_iterable_of_positive_big_integers_can_be_generated() {

        MNT.A_random_iterable_of_positive_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_iterable_of_negative_big_integers_can_be_generated() {

        MNT.A_random_iterable_of_negative_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_integers_greater_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_integers_less_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_less_than_a_number_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_integers_between_two_numbers_can_be_generated() {

        MNT.A_random_iterable_of_numbers_between_two_numbers_can_be_generated(BIG_INTEGERS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_integers_with_multiple_restrictions_can_be_generated() {

        MNT.A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(BIG_INTEGERS_METHODS);
    }

    private static class BigIntegersMethods implements Numbers<BigInteger> {

        @Override
        public BigInteger someNumber() {
            return someBigInteger();
        }

        @Override
        public BigInteger somePositiveNumber() {
            return somePositiveBigInteger();
        }

        @Override
        public BigInteger someNegativeNumber() {
            return someNegativeBigInteger();
        }

        @Override
        public BigInteger someNumberGreaterThan(BigInteger size) {
            return someBigIntegerGreaterThan(size);
        }

        @Override
        public BigInteger someNumberLessThan(BigInteger size) {
            return someBigIntegerLessThan(size);
        }

        @Override
        public BigInteger someNumberBetween(BigInteger min, BigInteger max) {
            return someBigIntegerBetween(min, max);
        }

        @Override
        public NumbersIterable<BigInteger> someNumbers() {
            return someBigIntegers();
        }

        @Override
        public NumbersIterable<BigInteger> someNumbers(int length) {
            return someBigIntegers(length);
        }

    }
}

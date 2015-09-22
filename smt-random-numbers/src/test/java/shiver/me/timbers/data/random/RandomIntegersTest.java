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
import shiver.me.timbers.data.random.test.IntegerValues;

import static shiver.me.timbers.data.random.RandomIntegers.someInteger;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerBetween;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerGreaterThan;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegerLessThan;
import static shiver.me.timbers.data.random.RandomIntegers.someIntegers;
import static shiver.me.timbers.data.random.RandomIntegers.someNegativeInteger;
import static shiver.me.timbers.data.random.RandomIntegers.somePositiveInteger;
import static shiver.me.timbers.data.random.test.IsANumber.isAnInteger;
import static shiver.me.timbers.data.random.test.TestUtils.TEST_RETRY_AMOUNT;

public class RandomIntegersTest {

    private static final IntegerValues VALUES = new IntegerValues();
    private static final BoundSingleNumbersTests<Integer> SNT = new BoundSingleNumbersTests<>(VALUES, isAnInteger());
    private static final MultipleNumbersTests<Integer> MNT = new MultipleNumbersTests<>(VALUES, isAnInteger());

    private static final Numbers<Integer> INTEGER_METHODS = new IntegersMethods();

    static {
        RandomIntegers.setRetryAmount(TEST_RETRY_AMOUNT);
    }

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomIntegers();
    }

    @Test
    public void A_random_integer_can_be_generated() {

        SNT.A_random_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_positive_integer_can_be_generated() {

        SNT.A_random_positive_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_negative_integer_can_be_generated() {

        SNT.A_random_negative_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_greater_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_positive_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_greater_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_negative_number_can_be_generated(INTEGER_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_integer_greater_than_the_max_integer_value_can_not_be_generated() {

        SNT.A_random_number_greater_than_the_max_number_value_can_not_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_less_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_less_than_a_positive_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_less_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_less_than_a_negative_number_can_be_generated(INTEGER_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_integer_less_than_the_min_integer_value_can_not_be_generated() {

        SNT.A_random_number_less_than_the_min_number_value_can_not_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_between_two_positive_numbers_can_be_generated() {

        SNT.A_random_number_between_two_positive_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_between_two_negative_numbers_can_be_generated() {

        SNT.A_random_number_between_two_negative_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_between_a_negative_number_and_a_positive_number_can_be_generated() {

        SNT.A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_between_a_range_the_size_of_the_max_integer_value_can_be_generated() {

        SNT.A_random_number_between_a_range_the_size_of_the_max_number_value_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_integer_between_the_max_ranges_can_be_generated() {

        SNT.A_random_number_between_the_max_ranges_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_length_iterable_of_random_integers_can_be_generated() {

        MNT.A_random_length_iterable_of_random_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_fixed_length_iterable_of_random_integers_can_be_generated() {

        MNT.A_fixed_length_iterable_of_random_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_list_of_integers_can_be_generated() {

        MNT.A_random_list_of_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_array_of_integers_can_be_generated() {

        MNT.A_random_array_of_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_set_of_integers_can_be_generated() {

        MNT.A_random_set_of_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_iterable_of_positive_integers_can_be_generated() {

        MNT.A_random_iterable_of_positive_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_iterable_of_negative_integers_can_be_generated() {

        MNT.A_random_iterable_of_negative_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_iterable_of_integers_greater_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_iterable_of_integers_less_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_less_than_a_number_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_iterable_of_integers_between_two_numbers_can_be_generated() {

        MNT.A_random_iterable_of_numbers_between_two_numbers_can_be_generated(INTEGER_METHODS);
    }

    @Test
    public void A_random_iterable_of_integers_with_multiple_restrictions_can_be_generated() {

        MNT.A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(INTEGER_METHODS);
    }

    private static class IntegersMethods implements Numbers<Integer> {

        @Override
        public Integer someNumber() {
            return someInteger();
        }

        @Override
        public Integer somePositiveNumber() {
            return somePositiveInteger();
        }

        @Override
        public Integer someNegativeNumber() {
            return someNegativeInteger();
        }

        @Override
        public Integer someNumberGreaterThan(Integer size) {
            return someIntegerGreaterThan(size);
        }

        @Override
        public Integer someNumberLessThan(Integer size) {
            return someIntegerLessThan(size);
        }

        @Override
        public Integer someNumberBetween(Integer min, Integer max) {
            return someIntegerBetween(min, max);
        }

        @Override
        public NumbersIterable<Integer> someNumbers() {
            return someIntegers();
        }

        @Override
        public NumbersIterable<Integer> someNumbers(int length) {
            return someIntegers(length);
        }

    }
}

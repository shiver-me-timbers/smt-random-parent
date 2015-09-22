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
import shiver.me.timbers.data.random.test.DoubleValues;

import static shiver.me.timbers.data.random.RandomDoubles.someDouble;
import static shiver.me.timbers.data.random.RandomDoubles.someDoubleBetween;
import static shiver.me.timbers.data.random.RandomDoubles.someDoubleGreaterThan;
import static shiver.me.timbers.data.random.RandomDoubles.someDoubleLessThan;
import static shiver.me.timbers.data.random.RandomDoubles.someDoubles;
import static shiver.me.timbers.data.random.RandomDoubles.someNegativeDouble;
import static shiver.me.timbers.data.random.RandomDoubles.somePositiveDouble;
import static shiver.me.timbers.data.random.test.IsANumber.isADouble;
import static shiver.me.timbers.data.random.test.TestUtils.TEST_RETRY_AMOUNT;

public class RandomDoublesTest {

    private static final DoubleValues VALUES = new DoubleValues();
    private static final BoundSingleNumbersTests<Double> SNT = new BoundSingleNumbersTests<>(VALUES, isADouble());
    private static final MultipleNumbersTests<Double> MNT = new MultipleNumbersTests<>(VALUES, isADouble());
    private static final Numbers<Double> DOUBLES_METHODS = new DoublesMethods();

    static {
        RandomDoubles.setRetryAmount(TEST_RETRY_AMOUNT);
    }

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomDoubles();
    }

    @Test
    public void A_random_double_can_be_generated() {

        SNT.A_random_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_positive_double_can_be_generated() {

        SNT.A_random_positive_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_negative_double_can_be_generated() {

        SNT.A_random_negative_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_greater_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_positive_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_greater_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_negative_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_double_greater_than_the_max_double_value_can_not_be_generated() {

        SNT.A_random_number_greater_than_the_max_number_value_can_not_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_less_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_less_than_a_positive_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_less_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_less_than_a_negative_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_double_less_than_the_min_double_value_can_not_be_generated() {

        SNT.A_random_number_less_than_the_min_number_value_can_not_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_between_two_positive_numbers_can_be_generated() {

        SNT.A_random_number_between_two_positive_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_between_two_negative_numbers_can_be_generated() {

        SNT.A_random_number_between_two_negative_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_between_a_negative_number_and_a_positive_number_can_be_generated() {

        SNT.A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_between_a_range_the_size_of_the_max_double_value_can_be_generated() {

        SNT.A_random_number_between_a_range_the_size_of_the_max_number_value_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_double_between_the_max_ranges_can_be_generated() {

        SNT.A_random_number_between_the_max_ranges_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_length_iterable_of_random_doubles_can_be_generated() {

        MNT.A_random_length_iterable_of_random_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_fixed_length_iterable_of_random_doubles_can_be_generated() {

        MNT.A_fixed_length_iterable_of_random_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_list_of_doubles_can_be_generated() {

        MNT.A_random_list_of_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_array_of_doubles_can_be_generated() {

        MNT.A_random_array_of_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_set_of_doubles_can_be_generated() {

        MNT.A_random_set_of_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_iterable_of_positive_doubles_can_be_generated() {

        MNT.A_random_iterable_of_positive_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_iterable_of_negative_doubles_can_be_generated() {

        MNT.A_random_iterable_of_negative_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_iterable_of_doubles_greater_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_iterable_of_doubles_less_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_less_than_a_number_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_iterable_of_doubles_between_two_numbers_can_be_generated() {

        MNT.A_random_iterable_of_numbers_between_two_numbers_can_be_generated(DOUBLES_METHODS);
    }

    @Test
    public void A_random_iterable_of_doubles_with_multiple_restrictions_can_be_generated() {

        MNT.A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(DOUBLES_METHODS);
    }

    private static class DoublesMethods implements Numbers<Double> {

        @Override
        public Double someNumber() {
            return someDouble();
        }

        @Override
        public Double somePositiveNumber() {
            return somePositiveDouble();
        }

        @Override
        public Double someNegativeNumber() {
            return someNegativeDouble();
        }

        @Override
        public Double someNumberGreaterThan(Double size) {
            return someDoubleGreaterThan(size);
        }

        @Override
        public Double someNumberLessThan(Double size) {
            return someDoubleLessThan(size);
        }

        @Override
        public Double someNumberBetween(Double min, Double max) {
            return someDoubleBetween(min, max);
        }

        @Override
        public NumbersIterable<Double> someNumbers() {
            return someDoubles();
        }

        @Override
        public NumbersIterable<Double> someNumbers(int length) {
            return someDoubles(length);
        }

    }
}

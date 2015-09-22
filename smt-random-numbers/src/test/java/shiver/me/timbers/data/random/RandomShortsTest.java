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
import shiver.me.timbers.data.random.test.ShortValues;
import shiver.me.timbers.data.random.test.TestUtils;

import static shiver.me.timbers.data.random.RandomShorts.someNegativeShort;
import static shiver.me.timbers.data.random.RandomShorts.somePositiveShort;
import static shiver.me.timbers.data.random.RandomShorts.someShort;
import static shiver.me.timbers.data.random.RandomShorts.someShortBetween;
import static shiver.me.timbers.data.random.RandomShorts.someShortGreaterThan;
import static shiver.me.timbers.data.random.RandomShorts.someShortLessThan;
import static shiver.me.timbers.data.random.RandomShorts.someShorts;
import static shiver.me.timbers.data.random.test.IsANumber.isAShort;

public class RandomShortsTest {

    private static final ShortValues VALUES = new ShortValues();
    private static final BoundSingleNumbersTests<Short> SNT = new BoundSingleNumbersTests<>(VALUES, isAShort());
    private static final MultipleNumbersTests<Short> MNT = new MultipleNumbersTests<>(VALUES, isAShort());

    private static final Numbers<Short> SHORT_METHODS = new ShortsMethods();

    static {
        RandomShorts.setRetryAmount(TestUtils.TEST_RETRY_AMOUNT);
    }

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomShorts();
    }

    @Test
    public void A_random_short_can_be_generated() {

        SNT.A_random_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_positive_short_can_be_generated() {

        SNT.A_random_positive_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_negative_short_can_be_generated() {

        SNT.A_random_negative_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_greater_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_positive_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_greater_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_negative_number_can_be_generated(SHORT_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_short_greater_than_the_max_short_value_can_not_be_generated() {

        SNT.A_random_number_greater_than_the_max_number_value_can_not_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_less_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_less_than_a_positive_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_less_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_less_than_a_negative_number_can_be_generated(SHORT_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_short_less_than_the_min_short_value_can_not_be_generated() {

        SNT.A_random_number_less_than_the_min_number_value_can_not_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_between_two_positive_numbers_can_be_generated() {

        SNT.A_random_number_between_two_positive_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_between_two_negative_numbers_can_be_generated() {

        SNT.A_random_number_between_two_negative_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_between_a_negative_number_and_a_positive_number_can_be_generated() {

        SNT.A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_between_a_range_the_size_of_the_max_short_value_can_be_generated() {

        SNT.A_random_number_between_a_range_the_size_of_the_max_number_value_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_short_between_the_max_ranges_can_be_generated() {

        SNT.A_random_number_between_the_max_ranges_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_length_iterable_of_random_shorts_can_be_generated() {

        MNT.A_random_length_iterable_of_random_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_fixed_length_iterable_of_random_shorts_can_be_generated() {

        MNT.A_fixed_length_iterable_of_random_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_list_of_shorts_can_be_generated() {

        MNT.A_random_list_of_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_array_of_shorts_can_be_generated() {

        MNT.A_random_array_of_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_set_of_shorts_can_be_generated() {

        MNT.A_random_set_of_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_iterable_of_positive_shorts_can_be_generated() {

        MNT.A_random_iterable_of_positive_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_iterable_of_negative_shorts_can_be_generated() {

        MNT.A_random_iterable_of_negative_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_iterable_of_shorts_greater_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_iterable_of_shorts_less_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_less_than_a_number_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_iterable_of_shorts_between_two_numbers_can_be_generated() {

        MNT.A_random_iterable_of_numbers_between_two_numbers_can_be_generated(SHORT_METHODS);
    }

    @Test
    public void A_random_iterable_of_shorts_with_multiple_restrictions_can_be_generated() {

        MNT.A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(SHORT_METHODS);
    }

    private static class ShortsMethods implements Numbers<Short> {

        @Override
        public Short someNumber() {
            return someShort();
        }

        @Override
        public Short somePositiveNumber() {
            return somePositiveShort();
        }

        @Override
        public Short someNegativeNumber() {
            return someNegativeShort();
        }

        @Override
        public Short someNumberGreaterThan(Short size) {
            return someShortGreaterThan(size);
        }

        @Override
        public Short someNumberLessThan(Short size) {
            return someShortLessThan(size);
        }

        @Override
        public Short someNumberBetween(Short min, Short max) {
            return someShortBetween(min, max);
        }

        @Override
        public NumbersIterable<Short> someNumbers() {
            return someShorts();
        }

        @Override
        public NumbersIterable<Short> someNumbers(int length) {
            return someShorts(length);
        }

    }
}

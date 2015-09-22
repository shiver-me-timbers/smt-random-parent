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
import shiver.me.timbers.data.random.test.LongValues;

import static shiver.me.timbers.data.random.RandomLongs.someLong;
import static shiver.me.timbers.data.random.RandomLongs.someLongBetween;
import static shiver.me.timbers.data.random.RandomLongs.someLongGreaterThan;
import static shiver.me.timbers.data.random.RandomLongs.someLongLessThan;
import static shiver.me.timbers.data.random.RandomLongs.someLongs;
import static shiver.me.timbers.data.random.RandomLongs.someNegativeLong;
import static shiver.me.timbers.data.random.RandomLongs.somePositiveLong;
import static shiver.me.timbers.data.random.test.IsANumber.isALong;
import static shiver.me.timbers.data.random.test.TestUtils.TEST_RETRY_AMOUNT;

public class RandomLongsTest {

    private static final LongValues VALUES = new LongValues();
    private static final BoundSingleNumbersTests<Long> SNT = new BoundSingleNumbersTests<>(VALUES, isALong());
    private static final MultipleNumbersTests<Long> MNT = new MultipleNumbersTests<>(VALUES, isALong());

    private static final Numbers<Long> LONGS_METHODS = new LongsMethods();

    static {
        RandomLongs.setRetryAmount(TEST_RETRY_AMOUNT);
    }

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomLongs();
    }

    @Test
    public void A_random_long_can_be_generated() {

        SNT.A_random_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_positive_long_can_be_generated() {

        SNT.A_random_positive_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_negative_long_can_be_generated() {

        SNT.A_random_negative_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_greater_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_positive_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_greater_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_negative_number_can_be_generated(LONGS_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_long_greater_than_the_max_long_value_can_not_be_generated() {

        SNT.A_random_number_greater_than_the_max_number_value_can_not_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_less_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_less_than_a_positive_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_less_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_less_than_a_negative_number_can_be_generated(LONGS_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_long_less_than_the_min_long_value_can_not_be_generated() {

        SNT.A_random_number_less_than_the_min_number_value_can_not_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_between_two_positive_numbers_can_be_generated() {

        SNT.A_random_number_between_two_positive_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_between_two_negative_numbers_can_be_generated() {

        SNT.A_random_number_between_two_negative_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_between_a_negative_number_and_a_positive_number_can_be_generated() {

        SNT.A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_between_a_range_the_size_of_the_max_long_value_can_be_generated() {

        SNT.A_random_number_between_a_range_the_size_of_the_max_number_value_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_long_between_the_max_ranges_can_be_generated() {

        SNT.A_random_number_between_the_max_ranges_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_length_iterable_of_random_longs_can_be_generated() {

        MNT.A_random_length_iterable_of_random_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_fixed_length_iterable_of_random_longs_can_be_generated() {

        MNT.A_fixed_length_iterable_of_random_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_list_of_longs_can_be_generated() {

        MNT.A_random_list_of_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_array_of_longs_can_be_generated() {

        MNT.A_random_array_of_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_set_of_longs_can_be_generated() {

        MNT.A_random_set_of_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_iterable_of_positive_longs_can_be_generated() {

        MNT.A_random_iterable_of_positive_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_iterable_of_negative_longs_can_be_generated() {

        MNT.A_random_iterable_of_negative_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_iterable_of_longs_greater_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_iterable_of_longs_less_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_less_than_a_number_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_iterable_of_longs_between_two_numbers_can_be_generated() {

        MNT.A_random_iterable_of_numbers_between_two_numbers_can_be_generated(LONGS_METHODS);
    }

    @Test
    public void A_random_iterable_of_longs_with_multiple_restrictions_can_be_generated() {

        MNT.A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(LONGS_METHODS);
    }

    private static class LongsMethods implements Numbers<Long> {

        @Override
        public Long someNumber() {
            return someLong();
        }

        @Override
        public Long somePositiveNumber() {
            return somePositiveLong();
        }

        @Override
        public Long someNegativeNumber() {
            return someNegativeLong();
        }

        @Override
        public Long someNumberGreaterThan(Long size) {
            return someLongGreaterThan(size);
        }

        @Override
        public Long someNumberLessThan(Long size) {
            return someLongLessThan(size);
        }

        @Override
        public Long someNumberBetween(Long min, Long max) {
            return someLongBetween(min, max);
        }

        @Override
        public NumbersIterable<Long> someNumbers() {
            return someLongs();
        }

        @Override
        public NumbersIterable<Long> someNumbers(int length) {
            return someLongs(length);
        }

    }
}

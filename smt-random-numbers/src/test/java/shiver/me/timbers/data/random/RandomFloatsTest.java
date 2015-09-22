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
import shiver.me.timbers.data.random.test.FloatValues;

import static shiver.me.timbers.data.random.RandomFloats.someFloat;
import static shiver.me.timbers.data.random.RandomFloats.someFloatBetween;
import static shiver.me.timbers.data.random.RandomFloats.someFloatGreaterThan;
import static shiver.me.timbers.data.random.RandomFloats.someFloatLessThan;
import static shiver.me.timbers.data.random.RandomFloats.someFloats;
import static shiver.me.timbers.data.random.RandomFloats.someNegativeFloat;
import static shiver.me.timbers.data.random.RandomFloats.somePositiveFloat;
import static shiver.me.timbers.data.random.test.IsANumber.isAFloat;
import static shiver.me.timbers.data.random.test.TestUtils.TEST_RETRY_AMOUNT;

public class RandomFloatsTest {

    private static final FloatValues VALUES = new FloatValues();
    private static final BoundSingleNumbersTests<Float> SNT = new BoundSingleNumbersTests<>(VALUES, isAFloat());
    private static final MultipleNumbersTests<Float> MNT = new MultipleNumbersTests<>(VALUES, isAFloat());

    private static final Numbers<Float> FLOATS_METHODS = new FloatsMethods();

    static {
        RandomFloats.setRetryAmount(TEST_RETRY_AMOUNT);
    }

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomFloats();
    }

    @Test
    public void A_random_float_can_be_generated() {

        SNT.A_random_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_positive_float_can_be_generated() {

        SNT.A_random_positive_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_negative_float_can_be_generated() {

        SNT.A_random_negative_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_greater_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_positive_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_greater_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_negative_number_can_be_generated(FLOATS_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_float_greater_than_the_max_float_value_can_not_be_generated() {

        SNT.A_random_number_greater_than_the_max_number_value_can_not_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_less_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_less_than_a_positive_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_less_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_less_than_a_negative_number_can_be_generated(FLOATS_METHODS);
    }

    @Test(expected = IllegalStateException.class)
    public void A_random_float_less_than_the_min_float_value_can_not_be_generated() {

        SNT.A_random_number_less_than_the_min_number_value_can_not_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_between_two_positive_numbers_can_be_generated() {

        SNT.A_random_number_between_two_positive_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_between_two_negative_numbers_can_be_generated() {

        SNT.A_random_number_between_two_negative_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_between_a_negative_number_and_a_positive_number_can_be_generated() {

        SNT.A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_between_a_range_the_size_of_the_max_float_value_can_be_generated() {

        SNT.A_random_number_between_a_range_the_size_of_the_max_number_value_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_float_between_the_max_ranges_can_be_generated() {

        SNT.A_random_number_between_the_max_ranges_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_length_iterable_of_random_floats_can_be_generated() {

        MNT.A_random_length_iterable_of_random_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_fixed_length_iterable_of_random_floats_can_be_generated() {

        MNT.A_fixed_length_iterable_of_random_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_list_of_floats_can_be_generated() {

        MNT.A_random_list_of_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_array_of_floats_can_be_generated() {

        MNT.A_random_array_of_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_set_of_floats_can_be_generated() {

        MNT.A_random_set_of_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_iterable_of_positive_floats_can_be_generated() {

        MNT.A_random_iterable_of_positive_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_iterable_of_negative_floats_can_be_generated() {

        MNT.A_random_iterable_of_negative_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_iterable_of_floats_greater_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_iterable_of_floats_less_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_less_than_a_number_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_iterable_of_floats_between_two_numbers_can_be_generated() {

        MNT.A_random_iterable_of_numbers_between_two_numbers_can_be_generated(FLOATS_METHODS);
    }

    @Test
    public void A_random_iterable_of_floats_with_multiple_restrictions_can_be_generated() {

        MNT.A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(FLOATS_METHODS);
    }

    private static class FloatsMethods implements Numbers<Float> {

        @Override
        public Float someNumber() {
            return someFloat();
        }

        @Override
        public Float somePositiveNumber() {
            return somePositiveFloat();
        }

        @Override
        public Float someNegativeNumber() {
            return someNegativeFloat();
        }

        @Override
        public Float someNumberGreaterThan(Float size) {
            return someFloatGreaterThan(size);
        }

        @Override
        public Float someNumberLessThan(Float size) {
            return someFloatLessThan(size);
        }

        @Override
        public Float someNumberBetween(Float min, Float max) {
            return someFloatBetween(min, max);
        }

        @Override
        public NumbersIterable<Float> someNumbers() {
            return someFloats();
        }

        @Override
        public NumbersIterable<Float> someNumbers(int length) {
            return someFloats(length);
        }

    }
}

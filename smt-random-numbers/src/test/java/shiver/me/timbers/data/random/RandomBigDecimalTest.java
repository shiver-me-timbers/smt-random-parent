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
import shiver.me.timbers.data.random.test.BigDecimalValues;

import java.math.BigDecimal;

import static shiver.me.timbers.data.random.RandomBigDecimals.someBigDecimal;
import static shiver.me.timbers.data.random.RandomBigDecimals.someBigDecimalBetween;
import static shiver.me.timbers.data.random.RandomBigDecimals.someBigDecimalGreaterThan;
import static shiver.me.timbers.data.random.RandomBigDecimals.someBigDecimalLessThan;
import static shiver.me.timbers.data.random.RandomBigDecimals.someBigDecimals;
import static shiver.me.timbers.data.random.RandomBigDecimals.someNegativeBigDecimal;
import static shiver.me.timbers.data.random.RandomBigDecimals.somePositiveBigDecimal;
import static shiver.me.timbers.data.random.test.IsANumber.isABigDecimal;

public class RandomBigDecimalTest {

    private static final BigDecimalValues VALUES = new BigDecimalValues();
    private static final SingleNumbersTests<BigDecimal> SNT = new SingleNumbersTests<>(VALUES, isABigDecimal());
    private static final MultipleNumbersTests<BigDecimal> MNT = new MultipleNumbersTests<>(VALUES, isABigDecimal());

    private static final Numbers<BigDecimal> BIG_DECIMALS_METHODS = new BigDecimalsMethods();

    static {
        RandomBigDecimals.setRetryAmount(100);
    }

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomBigDecimals();
    }

    @Test
    public void A_random_big_decimal_can_be_generated() {

        SNT.A_random_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_positive_big_decimal_can_be_generated() {

        SNT.A_random_positive_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_negative_big_decimal_can_be_generated() {

        SNT.A_random_negative_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_big_decimal_greater_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_positive_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_big_decimal_greater_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_greater_than_a_negative_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_big_decimal_less_than_a_positive_number_can_be_generated() {

        SNT.A_random_number_less_than_a_positive_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_big_decimal_less_than_a_negative_number_can_be_generated() {

        SNT.A_random_number_less_than_a_negative_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_big_decimal_between_two_positive_numbers_can_be_generated() {

        SNT.A_random_number_between_two_positive_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_big_decimal_between_two_negative_numbers_can_be_generated() {

        SNT.A_random_number_between_two_negative_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_big_decimal_between_a_negative_number_and_a_positive_number_can_be_generated() {

        SNT.A_random_number_between_a_negative_number_and_a_positive_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_length_iterable_of_random_big_decimals_can_be_generated() {

        MNT.A_random_length_iterable_of_random_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_fixed_length_iterable_of_random_big_decimals_can_be_generated() {

        MNT.A_fixed_length_iterable_of_random_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_list_of_big_decimals_can_be_generated() {

        MNT.A_random_list_of_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_array_of_big_decimals_can_be_generated() {

        MNT.A_random_array_of_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_set_of_big_decimals_can_be_generated() {

        MNT.A_random_set_of_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_iterable_of_positive_big_decimals_can_be_generated() {

        MNT.A_random_iterable_of_positive_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_iterable_of_negative_big_decimals_can_be_generated() {

        MNT.A_random_iterable_of_negative_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_decimals_greater_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_greater_than_a_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_decimals_less_than_a_number_can_be_generated() {

        MNT.A_random_iterable_of_numbers_less_than_a_number_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_decimals_between_two_numbers_can_be_generated() {

        MNT.A_random_iterable_of_numbers_between_two_numbers_can_be_generated(BIG_DECIMALS_METHODS);
    }

    @Test
    public void A_random_iterable_of_big_decimals_with_multiple_restrictions_can_be_generated() {

        MNT.A_random_iterable_of_numbers_with_multiple_restrictions_can_be_generated(BIG_DECIMALS_METHODS);
    }

    private static class BigDecimalsMethods implements Numbers<BigDecimal> {

        @Override
        public BigDecimal someNumber() {
            return someBigDecimal();
        }

        @Override
        public BigDecimal somePositiveNumber() {
            return somePositiveBigDecimal();
        }

        @Override
        public BigDecimal someNegativeNumber() {
            return someNegativeBigDecimal();
        }

        @Override
        public BigDecimal someNumberGreaterThan(BigDecimal size) {
            return someBigDecimalGreaterThan(size);
        }

        @Override
        public BigDecimal someNumberLessThan(BigDecimal size) {
            return someBigDecimalLessThan(size);
        }

        @Override
        public BigDecimal someNumberBetween(BigDecimal min, BigDecimal max) {
            return someBigDecimalBetween(min, max);
        }

        @Override
        public NumbersIterable<BigDecimal> someNumbers() {
            return someBigDecimals();
        }

        @Override
        public NumbersIterable<BigDecimal> someNumbers(int length) {
            return someBigDecimals(length);
        }

    }
}

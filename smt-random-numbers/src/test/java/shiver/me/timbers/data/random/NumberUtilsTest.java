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

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static shiver.me.timbers.data.random.NumberUtils.isInBetween;
import static shiver.me.timbers.data.random.NumberUtils.isNegative;
import static shiver.me.timbers.data.random.NumberUtils.isPositive;
import static shiver.me.timbers.data.random.NumberUtils.switchSign;

public class NumberUtilsTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new NumberUtils();
    }

    @Test
    public void Can_check_a_number_is_between_two_other_numbers() throws Exception {

        // When
        final boolean isInBetween = isInBetween(2, 4, 3);
        final boolean tooSmall = isInBetween(2, 4, 1);
        final boolean tooLarge = isInBetween(2, 4, 5);

        // Then
        assertTrue(isInBetween);
        assertFalse(tooSmall);
        assertFalse(tooLarge);
    }

    @Test
    public void Can_check_if_a_number_is_positive() throws Exception {

        // When
        final boolean isPositive = isPositive(1);
        final boolean isNegative = isPositive(-1);

        // Then
        assertTrue(isPositive);
        assertFalse(isNegative);
    }

    @Test
    public void Can_check_if_a_number_is_negative() throws Exception {

        // When
        final boolean isPositive = isNegative(1);
        final boolean isNegative = isNegative(-1);

        // Then
        assertFalse(isPositive);
        assertTrue(isNegative);
    }

    @Test
    public void Can_switch_the_sign_of_a_number() throws Exception {

        // When
        final long swithToPositive = switchSign(-1);
        final long swithToNegative = switchSign(1);

        // Then
        assertThat(swithToPositive, greaterThan((long) 0));
        assertThat(swithToNegative, lessThan((long) 0));
    }
}

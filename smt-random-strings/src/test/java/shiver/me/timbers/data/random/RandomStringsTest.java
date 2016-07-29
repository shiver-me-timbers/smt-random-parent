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

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomStrings.buildSomeString;
import static shiver.me.timbers.data.random.RandomStrings.someAlphaString;
import static shiver.me.timbers.data.random.RandomStrings.someAlphanumericString;
import static shiver.me.timbers.data.random.RandomStrings.someNumericString;
import static shiver.me.timbers.data.random.RandomStrings.someString;
import static shiver.me.timbers.data.random.test.StringMatchers.eachChar;
import static shiver.me.timbers.data.random.test.StringMatchers.hasLength;
import static shiver.me.timbers.data.random.test.StringMatchers.isAlpha;
import static shiver.me.timbers.data.random.test.StringMatchers.isAlphanumeric;
import static shiver.me.timbers.data.random.test.StringMatchers.isNumeric;
import static shiver.me.timbers.data.random.test.StringMatchers.isOneOf;
import static shiver.me.timbers.data.random.test.StringMatchers.isPrintableAscii;

public class RandomStringsTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomStrings();
    }

    @Test
    public void A_random_string_can_be_generated() {

        // When
        final String actual = someString();

        // Then
        assertNotNull(actual);
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void A_random_string_can_be_generated_with_a_specific_length() {

        // Given
        final int length = 32;

        // When
        final String actual = someString(length);

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void A_random_string_can_be_generated_with_a_length_between_a_range() {

        // Given
        final int minLength = 202;
        final int maxLength = 212;

        // When
        final String actual = someString(minLength, maxLength);

        // Then
        assertThat(actual, hasLength(allOf(greaterThanOrEqualTo(minLength), lessThanOrEqualTo(maxLength))));
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void A_random_string_can_be_generated_from_specific_characters() {

        // Given
        final String characters = "abcde";

        // When
        final String actual = someString(characters);

        // Then
        assertThat(actual, eachChar(isOneOf(characters)));
    }

    @Test
    public void A_random_string_can_be_generated_from_specific_characters_and_with_a_specific_length() {

        // Given
        final int length = 42;
        final String characters = "fghij";

        // When
        final String actual = someString(length, characters);

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isOneOf(characters)));
    }

    @Test
    public void A_random_string_can_be_generated_from_specific_characters_and_with_a_length_between_a_range() {

        // Given
        final int minLength = 202;
        final int maxLength = 212;
        final String characters = "fghij";

        // When
        final String actual = someString(minLength, maxLength, characters);

        // Then
        assertThat(actual, hasLength(allOf(greaterThanOrEqualTo(minLength), lessThanOrEqualTo(maxLength))));
        assertThat(actual, eachChar(isOneOf(characters)));
    }

    @Test
    public void A_random_alpha_string_can_be_generated() {

        // When
        final String actual = someAlphaString();

        // Then
        assertThat(actual, eachChar(isAlpha()));
    }

    @Test
    public void A_random_alpha_string_can_be_generated_with_a_specific_length() {

        // Given
        final int length = 52;

        // When
        final String actual = someAlphaString(length);

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isAlpha()));
    }

    @Test
    public void A_random_alpha_string_can_be_generated_with_a_length_between_a_range() {

        // Given
        final int minLength = 222;
        final int maxLength = 232;

        // When
        final String actual = someAlphaString(minLength, maxLength);

        // Then
        assertThat(actual, hasLength(allOf(greaterThanOrEqualTo(minLength), lessThanOrEqualTo(maxLength))));
        assertThat(actual, eachChar(isAlpha()));
    }

    @Test
    public void A_random_numeric_string_can_be_generated() {

        // When
        final String actual = someNumericString();

        // Then
        assertThat(actual, eachChar(isNumeric()));
    }

    @Test
    public void A_random_numeric_string_can_be_generated_with_a_specific_length() {

        // Given
        final int length = 62;

        // When
        final String actual = someNumericString(length);

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isNumeric()));
    }

    @Test
    public void A_random_numeric_string_can_be_generated_with_a_length_between_a_range() {

        // Given
        final int minLength = 242;
        final int maxLength = 252;

        // When
        final String actual = someNumericString(minLength, maxLength);

        // Then
        assertThat(actual, hasLength(allOf(greaterThanOrEqualTo(minLength), lessThanOrEqualTo(maxLength))));
        assertThat(actual, eachChar(isNumeric()));
    }

    @Test
    public void A_random_alpha_numeric_string_can_be_generated() {

        // When
        final String actual = someAlphanumericString();

        // Then
        assertThat(actual, eachChar(isAlphanumeric()));
    }

    @Test
    public void A_random_alpha_numeric_string_can_be_generated_with_a_specific_length() {

        // Given
        final int length = 72;

        // When
        final String actual = someAlphanumericString(length);

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isAlphanumeric()));
    }

    @Test
    public void A_random_alpha_numeric_string_can_be_generated_with_a_length_between_a_range() {

        // Given
        final int minLength = 262;
        final int maxLength = 272;

        // When
        final String actual = someAlphanumericString(minLength, maxLength);

        // Then
        assertThat(actual, hasLength(allOf(greaterThanOrEqualTo(minLength), lessThanOrEqualTo(maxLength))));
        assertThat(actual, eachChar(isAlphanumeric()));
    }

    @Test
    public void A_random_string_can_be_built() {

        // When
        final String actual = buildSomeString().build();

        // Then
        assertNotNull(actual);
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void A_random_string_can_be_built_with_a_specific_length() {

        // Given
        final int length = 82;

        // When
        final String actual = buildSomeString().withLength(length).build();

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void A_random_string_can_be_built_that_contains_specific_characters() {

        // Given
        final String characters = "klmno";

        // When
        final String actual = buildSomeString().thatContains(characters).build();

        // Then
        assertThat(actual, eachChar(isOneOf(characters)));
    }

    @Test
    public void A_random_string_can_be_built_that_contains_alpha_characters() {

        // When
        final String actual = buildSomeString().thatContainsAlphaCharacters().build();

        // Then
        assertThat(actual, eachChar(isAlpha()));
    }

    @Test
    public void A_random_string_can_be_built_that_contains_alpha_characters_and_some_other_characters() {

        // Given
        final String characters = "!@#$";

        // When
        final String actual = buildSomeString().thatContainsAlphaCharacters().thatContains(characters).build();

        // Then
        assertThat(actual, eachChar(anyOf(isAlpha(), isOneOf(characters))));
    }

    @Test
    public void A_random_string_can_be_built_that_contains_numeric_characters() {

        // When
        final String actual = buildSomeString().thatContainsNumericCharacters().build();

        // Then
        assertThat(actual, eachChar(isNumeric()));
    }

    @Test
    public void A_random_string_can_be_built_that_contains_numeric_characters_and_some_other_characters() {

        // Given
        final String characters = "%^&*";

        // When
        final String actual = buildSomeString().thatContainsNumericCharacters().thatContains(characters).build();

        // Then
        assertThat(actual, eachChar(anyOf(isNumeric(), isOneOf(characters))));
    }

    @Test
    public void A_random_string_can_be_built_that_contains_alphanumeric_characters() {

        // When
        final String actual = buildSomeString().thatContainsAlphanumericCharacters().build();

        // Then
        assertThat(actual, eachChar(isAlphanumeric()));
    }

    @Test
    public void A_random_string_can_be_built_that_contains_alphanumeric_characters_and_some_other_characters() {

        // Given
        final String characters = "%^&*";

        // When
        final String actual = buildSomeString().thatContainsAlphanumericCharacters().thatContains(characters).build();

        // Then
        assertThat(actual, eachChar(anyOf(isAlpha(), isNumeric(), isOneOf(characters))));
    }

    @Test
    public void A_random_string_can_be_built_with_a_length_less_than_a_specified_value() {

        // Given
        final int length = 92;

        // When
        final String actual = buildSomeString().withLengthLessThan(length).build();

        // Then
        assertThat(actual, hasLength(lessThanOrEqualTo(length)));
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void A_random_string_can_be_built_with_a_length_greater_than_a_specified_value() {

        // Given
        final int length = 102;

        // When
        final String actual = buildSomeString().withLengthGreaterThan(length).build();

        // Then
        assertThat(actual, hasLength(greaterThanOrEqualTo(length)));
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void Length_can_be_set_to_be_between_a_range() {

        // Given
        final int minLength = 112;
        final int maxLength = 122;

        // When
        final String actual = buildSomeString().withLengthBetween(minLength, maxLength).build();

        // Then
        assertThat(actual, hasLength(allOf(greaterThanOrEqualTo(minLength), lessThanOrEqualTo(maxLength))));
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test(expected = IllegalStateException.class)
    public void Length_cannot_be_set_to_be_between_an_invalid_range() {

        // Given
        final int minLength = 132;
        final int maxLength = 131;

        // When
        buildSomeString().withLengthBetween(minLength, maxLength).build();
    }

    @Test
    public void Specific_length_takes_precedence() {

        // Given
        final int length = 142;
        final int lengthLessThan = 141;

        // When
        final String actual = buildSomeString().withLengthLessThan(lengthLessThan).withLength(length).build();

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isPrintableAscii()));
    }

    @Test
    public void A_random_string_can_be_built_with_a_length_less_than_a_specified_value_that_contains_specific_characters() {

        // Given
        final int length = 152;
        final String characters = "pqrst";

        // When
        final String actual = buildSomeString().withLengthLessThan(length).thatContains(characters).build();

        // Then
        assertThat(actual, hasLength(lessThanOrEqualTo(length)));
        assertThat(actual, eachChar(isOneOf(characters)));
    }

    @Test
    public void A_random_string_can_be_built_with_a_length_greater_than_a_specified_value_that_contains_specific_characters() {

        // Given
        final int length = 162;
        final String characters = "uvwxy";

        // When
        final String actual = buildSomeString().withLengthGreaterThan(length).thatContains(characters).build();

        // Then
        assertThat(actual, hasLength(greaterThanOrEqualTo(length)));
        assertThat(actual, eachChar(isOneOf(characters)));
    }

    @Test
    public void A_random_string_can_be_built_with_a_length_within_a_range_that_contains_specific_characters() {

        // Given
        final int minLength = 172;
        final int maxLength = 182;
        final String characters = "z1234";

        // When
        final String actual = buildSomeString().withLengthBetween(minLength, maxLength).thatContains(characters).build();

        // Then
        assertThat(actual, hasLength(allOf(greaterThanOrEqualTo(minLength), lessThanOrEqualTo(maxLength))));
        assertThat(actual, eachChar(isOneOf(characters)));
    }

    @Test
    public void A_random_string_can_be_built_with_a_specific_length_that_contains_specific_characters() {

        // Given
        final int length = 192;
        final String characters = "56789";

        // When
        final String actual = buildSomeString().withLength(length).thatContains(characters).build();

        // Then
        assertThat(actual, hasLength(length));
        assertThat(actual, eachChar(isOneOf(characters)));
    }
}

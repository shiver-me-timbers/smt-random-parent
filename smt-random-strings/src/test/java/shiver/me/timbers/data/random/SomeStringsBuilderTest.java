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

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.verifyZeroInteractions;
import static shiver.me.timbers.data.random.Constants.MAX_STRING_LENGTH;
import static shiver.me.timbers.data.random.test.StringMatchers.sameChars;

public class SomeStringsBuilderTest {

    private static final String ALPHAS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERICS = "0123456789";

    private StringsFactory stringsFactory;
    private Strings strings;
    private SomeStringsBuilder builder;
    private Random random;

    @Before
    public void setUp() {
        stringsFactory = mock(StringsFactory.class);
        strings = mock(Strings.class);
        random = mock(Random.class);

        builder = new SomeStringsBuilder(random, stringsFactory);
    }

    @Test
    public void Can_build_a_random_string() {

        final String expected = "random string";

        // Given
        given(stringsFactory.strings()).willReturn(strings);
        given(strings.someString()).willReturn(expected);

        // When
        final String actual = builder.build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_with_to_string() {

        final String expected = "random string";

        // Given
        given(stringsFactory.strings()).willReturn(strings);
        given(strings.someString()).willReturn(expected);

        // When
        final String actual = builder.toString();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_string_with_a_length_less_than_a_specific_value() {

        final int length = 32;
        final int randomLength = 31;
        final String expected = "random string";

        // Given
        given(random.nextInt(length + 1)).willReturn(randomLength);
        given(stringsFactory.strings()).willReturn(strings);
        given(strings.someString(randomLength)).willReturn(expected);

        // When
        final String actual = builder.withLengthLessThan(length).build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_string_with_a_length_greater_than_a_specific_value() {

        final int length = 32;
        final int randomLength = 1;
        final String expected = "random string";

        // Given
        given(random.nextInt(MAX_STRING_LENGTH)).willReturn(randomLength);
        given(stringsFactory.strings()).willReturn(strings);
        given(strings.someString(length + randomLength)).willReturn(expected);

        // When
        final String actual = builder.withLengthGreaterThan(length).build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_with_a_specific_length() {

        final int length = 42;
        final String expected = "random string";

        // Given
        given(stringsFactory.strings()).willReturn(strings);
        given(strings.someString(length)).willReturn(expected);

        // When
        final String actual = builder.withLength(length).build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Length_can_be_set_to_be_between_a_range() {

        final int minLength = 52;
        final int maxLength = 62;
        final int increment = 55;
        final String expected = "random string";

        // Given
        given(stringsFactory.strings()).willReturn(strings);
        given(random.nextInt((maxLength - minLength) + 1)).willReturn(increment);
        given(strings.someString(minLength + increment)).willReturn(expected);

        // When
        final String actual = builder.withLengthBetween(minLength, maxLength).build();

        // Then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void Length_cannot_be_set_to_be_between_an_invalid_range() {

        // Given
        final int minLength = 72;
        final int maxLength = 62;

        // When
        builder.withLengthBetween(minLength, maxLength).build();
    }

    @Test
    public void Specific_length_takes_precedence() {

        final int length = 72;
        final String expected = "random string";

        // Given
        given(stringsFactory.strings()).willReturn(strings);
        given(strings.someString(length)).willReturn(expected);

        // When
        final String actual = builder.withLengthGreaterThan(71).withLength(length).build();

        // Then
        assertEquals(expected, actual);
        verifyZeroInteractions(random);
    }

    @Test
    public void Can_build_a_random_string_that_contains_specific_characters() {

        final String characters = "abcde";
        final String expected = "random string";

        // Given
        given(strings.someString()).willReturn(expected);
        given(stringsFactory.strings(argThat(sameChars(characters)))).willReturn(strings);

        // When
        final String actual = builder.thatContains(characters).build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_that_contains_alpha_characters() {

        final String expected = "random string";

        // Given
        given(strings.someString()).willReturn(expected);
        given(stringsFactory.strings(argThat(sameChars(ALPHAS)))).willReturn(strings);

        // When
        final String actual = builder.thatContainsAlphaCharacters().build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_that_contains_alpha_characters_plus_some_others() {

        final String characters = "!@#$";
        final String expected = "random string";

        // Given
        given(strings.someString()).willReturn(expected);
        given(stringsFactory.strings(argThat(sameChars(ALPHAS + characters)))).willReturn(strings);

        // When
        final String actual = builder.thatContainsAlphaCharacters().thatContains(characters).build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_that_contains_numeric_characters() {

        final String expected = "random string";

        // Given
        given(strings.someString()).willReturn(expected);
        given(stringsFactory.strings(argThat(sameChars(NUMERICS)))).willReturn(strings);

        // When
        final String actual = builder.thatContainsNumericCharacters().build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_that_contains_numeric_characters_plus_some_others() {

        final String characters = "%^&*";
        final String expected = "random string";

        // Given
        given(strings.someString()).willReturn(expected);
        given(stringsFactory.strings(argThat(sameChars(NUMERICS + characters)))).willReturn(strings);

        // When
        final String actual = builder.thatContainsNumericCharacters().thatContains(characters).build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_that_contains_alphanumeric_characters() {

        final String expected = "random string";

        // Given
        given(strings.someString()).willReturn(expected);
        given(stringsFactory.strings(argThat(sameChars(ALPHAS + NUMERICS)))).willReturn(strings);

        // When
        final String actual = builder.thatContainsAlphanumericCharacters().build();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void Can_build_a_random_string_that_contains_alphanumeric_characters_plus_some_others() {

        final String characters = "()_+";
        final String expected = "random string";

        // Given
        given(strings.someString()).willReturn(expected);
        given(stringsFactory.strings(argThat(sameChars(ALPHAS + NUMERICS + characters)))).willReturn(strings);

        // When
        final String actual = builder.thatContainsAlphanumericCharacters().thatContains(characters).build();

        // Then
        assertEquals(expected, actual);
    }
}

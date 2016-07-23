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

import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple helper methods for generating random strings of varying size and content.
 *
 * @author Karl Bennett
 */
public class RandomStrings {

    private static StringsBuilder stringsBuilder() {

        final ThreadLocalRandom random = ThreadLocalRandom.current();

        return new SomeStringsBuilder(
            random,
            new LoopGenerationStringsFactory(random, new RandomCharacterGeneratorFactory(random))
        );
    }

    /**
     * Generate a random string with a random length no longer than 1024 characters. It can contain any of the printable
     * ASCII characters: Decimal 32 - 126
     */
    public static String someString() {
        return buildSomeString().build();
    }

    /**
     * Generate a random string with a specific length. It can contain any of the printable ASCII characters:
     * Decimal 32 - 126
     */
    public static String someString(int length) {
        return buildSomeString().withLength(length).build();
    }

    /**
     * Generate a random string with a length between the provided range, inclusive of the min and max values. It can
     * contain any of the printable ASCII characters: Decimal 32 - 126
     */
    public static String someString(int min, int max) {
        return stringsBuilder().withLengthBetween(min, max).build();
    }

    /**
     * Generate a random string from a specific set of characters with a random length no longer than 1024 characters.
     */
    public static String someString(CharSequence characters) {
        return buildSomeString().thatContains(characters).build();
    }

    /**
     * Generate a random string from a specific set of characters with a specific length.
     */
    public static String someString(int length, CharSequence characters) {
        return buildSomeString().withLength(length).thatContains(characters).build();
    }

    /**
     * Generate a random alpha string.
     */
    public static String someAlphaString() {
        return buildSomeString().thatContainsAlphaCharacters().build();
    }

    /**
     * Generate a random alpha string with a specific length.
     */
    public static String someAlphaString(int length) {
        return buildSomeString().thatContainsAlphaCharacters().withLength(length).build();
    }

    /**
     * Generate a random alpha string with a length between the provided range, inclusive of the min and max values.
     */
    public static String someAlphaString(int min, int max) {
        return stringsBuilder().withLengthBetween(min, max).thatContainsAlphaCharacters().build();
    }

    /**
     * Generate a random numeric string.
     */
    public static String someNumericString() {
        return buildSomeString().thatContainsNumericCharacters().build();
    }

    /**
     * Generate a random numeric string with a specific length.
     */
    public static String someNumericString(int length) {
        return buildSomeString().thatContainsNumericCharacters().withLength(length).build();
    }

    /**
     * Generate a random numeric string with a length between the provided range, inclusive of the min and max values.
     */
    public static String someNumericString(int min, int max) {
        return stringsBuilder().withLengthBetween(min, max).thatContainsNumericCharacters().build();
    }

    /**
     * Generate a random alphanumeric string.
     */
    public static String someAlphanumericString() {
        return buildSomeString().thatContainsAlphanumericCharacters().build();
    }

    /**
     * Generate a random alphanumeric string with a specific length.
     */
    public static String someAlphanumericString(int length) {
        return buildSomeString().thatContainsAlphanumericCharacters().withLength(length).build();
    }

    /**
     * Generate a random alphanumeric string with a specific length.
     */
    public static String someAlphanumericString(int min, int max) {
        return stringsBuilder().withLengthBetween(min, max).thatContainsAlphanumericCharacters().build();
    }

    /**
     * Build a complex random string.
     */
    public static StringsBuilder buildSomeString() {
        return stringsBuilder();
    }
}

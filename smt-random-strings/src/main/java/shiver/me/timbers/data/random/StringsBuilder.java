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

/**
 * This class allows the building of complex random strings.
 *
 * @author Karl Bennett
 */
public interface StringsBuilder {

    /**
     * Build a string with a length between the provided range, inclusive of the min and max values.
     */
    StringsBuilder withLengthBetween(int min, int max);

    /**
     * Build a string with a length less than or equal to the provided length.
     */
    StringsBuilder withLengthLessThan(int length);

    /**
     * Build a string with a length greater than or equal to the provided length.
     */
    StringsBuilder withLengthGreaterThan(int length);

    /**
     * Build a string with a length equal to the provided length.
     */
    StringsBuilder withLength(int length);

    /**
     * Build a string that contains only alphanumeric characters.
     */
    StringsBuilder thatContainsAlphanumericCharacters();

    /**
     * Build a string that contains only alpha characters.
     */
    StringsBuilder thatContainsAlphaCharacters();

    /**
     * Build a string that contains only numeric characters.
     */
    StringsBuilder thatContainsNumericCharacters();

    /**
     * Build a string that contains only the supplied characters.
     */
    StringsBuilder thatContains(CharSequence characters);

    /**
     * Build the final string.
     */
    String build();

    /**
     * Build the final string.
     */
    String toString();
}

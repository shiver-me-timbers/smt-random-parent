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

import java.util.Random;

import static java.lang.String.format;
import static shiver.me.timbers.data.random.Constants.MAX_STRING_LENGTH;

/**
 * @author Karl Bennett
 */
class SomeStringsBuilder implements StringsBuilder {

    private static final String ALPHAS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERICS = "0123456789";

    private final Random random;
    private final StringsFactory stringsFactory;
    private final StringBuilder characters;
    private Integer lessThanLength;
    private Integer greaterThanLength;
    private Integer length;

    public SomeStringsBuilder(Random random, StringsFactory stringsFactory) {
        this.random = random;
        this.stringsFactory = stringsFactory;
        this.characters = new StringBuilder();
    }

    @Override
    public StringsBuilder withLengthBetween(int min, int max) {
        return withLengthGreaterThan(min).withLengthLessThan(max);
    }

    @Override
    public StringsBuilder withLengthLessThan(int length) {
        this.lessThanLength = length;
        return this;
    }

    @Override
    public StringsBuilder withLengthGreaterThan(int length) {
        this.greaterThanLength = length;
        return this;
    }

    @Override
    public StringsBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    @Override
    public StringsBuilder thatContainsAlphanumericCharacters() {
        return thatContainsAlphaCharacters().thatContainsNumericCharacters();
    }

    @Override
    public StringsBuilder thatContainsAlphaCharacters() {
        return thatContains(ALPHAS);
    }

    @Override
    public StringsBuilder thatContainsNumericCharacters() {
        return thatContains(NUMERICS);
    }

    @Override
    public StringsBuilder thatContains(CharSequence characters) {
        this.characters.append(characters);
        return this;
    }

    @Override
    public String build() {

        final Strings strings = strings();
        final Integer length = length();

        if (length != null) {
            return strings.someString(length);
        }

        return strings.someString();
    }

    @Override
    public String toString() {
        return build();
    }

    private Strings strings() {

        if (characters.length() > 0) {
            return stringsFactory.strings(characters);
        }

        return stringsFactory.strings();
    }

    private Integer length() {

        if (length != null) {
            return length;
        }

        if (lessThanLength != null && greaterThanLength != null) {
            return rangeLength();
        }

        if (lessThanLength != null) {
            return lessThanLength();
        }

        if (greaterThanLength != null) {
            return greaterThanLength();
        }

        return null;
    }

    private Integer rangeLength() {
        if (lessThanLength < greaterThanLength) {
            throw new IllegalStateException(
                format(
                    "Cannot generate a string with a length greater than: %d and less than: %d",
                    greaterThanLength,
                    lessThanLength
                )
            );
        }

        final int increment = random.nextInt((lessThanLength - greaterThanLength) + 1);

        return greaterThanLength + increment;
    }

    private Integer lessThanLength() {
        return random.nextInt(lessThanLength + 1);
    }

    private Integer greaterThanLength() {
        return greaterThanLength + random.nextInt(MAX_STRING_LENGTH);
    }
}

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

package shiver.me.timbers.data.random.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

public class StringMatchers {

    public static Matcher<String> hasLength(int length) {
        return hasLength(equalTo(length));
    }

    public static Matcher<String> hasLength(Matcher<Integer> matcher) {
        return new StringLengthMatcher(matcher);
    }

    public static Matcher<String> eachChar(Matcher<Character> stringMatcher) {
        return new EachCharacterMatcher(stringMatcher);
    }

    public static Matcher<Character> isPrintableAscii() {
        return new PrintableAsciiMatcher();
    }

    public static Matcher<Character> isAlpha() {
        return new AlphaAsciiMatcher();
    }

    public static Matcher<Character> isNumeric() {
        return new NumericAsciiMatcher();
    }

    public static Matcher<Character> isAlphanumeric() {
        return anyOf(isAlpha(), isNumeric());
    }

    public static Matcher<Character> isOneOf(String characters) {
        return new IsOneOfCharactersMatcher(characters);
    }

    public static Matcher<CharSequence> sameChars(CharSequence characters) {
        return new SameCharsMatcher(characters);
    }

    private static class StringLengthMatcher extends TypeSafeMatcher<String> {

        private final Matcher<Integer> matcher;
        private String string;

        public StringLengthMatcher(Matcher<Integer> matcher) {
            this.matcher = matcher;
        }

        @Override
        protected boolean matchesSafely(String string) {
            this.string = string;
            return matcher.matches(string.length());
        }

        @Override
        public void describeTo(Description description) {
            matcher.describeTo(description);
            description.appendText(" actual length was ");
            description.appendValue(string.length());
        }
    }

    private static class EachCharacterMatcher extends TypeSafeMatcher<String> {

        private final Matcher<Character> matcher;
        private String string;

        public EachCharacterMatcher(Matcher<Character> matcher) {
            this.matcher = matcher;
        }

        @Override
        protected boolean matchesSafely(String string) {

            this.string = string;

            for (char c : string.toCharArray()) {
                if (!matcher.matches(c)) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public void describeTo(Description description) {
            description.appendDescriptionOf(matcher);
            description.appendValue(string);
        }
    }

    private static class AsciiRangeMatcher extends TypeSafeMatcher<Character> {

        private final int min;
        private final int max;
        private Character character;

        private AsciiRangeMatcher(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        protected boolean matchesSafely(Character character) {
            this.character = character;
            return (min <= character) && (character <= max);
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(character);
        }
    }

    private static class PrintableAsciiMatcher extends AsciiRangeMatcher {
        private PrintableAsciiMatcher() {
            super(32, 126);
        }
    }

    private static class AlphaAsciiMatcher extends AsciiRangeMatcher {
        private AlphaAsciiMatcher() {
            super(65, 122);
        }
    }

    private static class NumericAsciiMatcher extends AsciiRangeMatcher {
        private NumericAsciiMatcher() {
            super(48, 57);
        }
    }

    private static class IsOneOfCharactersMatcher extends TypeSafeMatcher<Character> {

        private final String characters;
        private Character character;

        public IsOneOfCharactersMatcher(String characters) {
            this.characters = characters;
        }

        @Override
        protected boolean matchesSafely(Character character) {
            this.character = character;
            return -1 != characters.indexOf(character);
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(characters);
            description.appendValue(character);
        }
    }

    private static class SameCharsMatcher extends TypeSafeMatcher<CharSequence> {

        private final CharSequence expected;

        public SameCharsMatcher(CharSequence expected) {
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(CharSequence actual) {
            return expected.toString().equals(actual.toString());
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(expected);
        }
    }
}

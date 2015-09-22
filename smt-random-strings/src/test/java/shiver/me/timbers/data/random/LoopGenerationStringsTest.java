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

public class LoopGenerationStringsTest {

    private Random random;
    private CharacterGenerator characterGenerator;
    private LoopGenerationStrings strings;

    @Before
    public void setUp() {
        random = mock(Random.class);
        characterGenerator = mock(CharacterGenerator.class);
        strings = new LoopGenerationStrings(random, characterGenerator);
    }

    @Test
    public void Can_generate_a_string() {

        // Given
        given(random.nextInt(1025)).willReturn(2);
        given(characterGenerator.generate()).willReturn('a', 'b');

        // When
        final String actual = strings.someString();

        // Then
        assertEquals("ab", actual);
    }

    @Test
    public void Can_generate_a_string_with_a_specific_length() {

        final int length = 3;

        // Given
        given(characterGenerator.generate()).willReturn('a', 'b', 'c');

        // When
        final String actual = strings.someString(length);

        // Then
        assertEquals("abc", actual);
    }
}

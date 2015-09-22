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

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyReflectionEquals;

public class LoopGenerationStringsFactoryTest {

    private Random random;
    private LoopGenerationStringsFactory factory;
    private CharacterGeneratorFactory characterGeneratorFactory;

    @Before
    public void setUp() {
        random = mock(Random.class);
        characterGeneratorFactory = mock(CharacterGeneratorFactory.class);
        factory = new LoopGenerationStringsFactory(random, characterGeneratorFactory);
    }

    @Test
    public void Can_create_a_random_strings() {

        final CharacterGenerator characterGenerator = mock(CharacterGenerator.class);

        // Given
        given(characterGeneratorFactory.generator()).willReturn(characterGenerator);

        // When
        final Strings actual = factory.strings();

        // Then
        assertThat(actual, instanceOf(LoopGenerationStrings.class));
        assertPropertyReflectionEquals("random", random, actual);
        assertPropertyReflectionEquals("characterGenerator", characterGenerator, actual);
    }

    @Test
    public void Can_create_a_random_limited_character_strings() {

        final String characters = "abcde";
        final CharacterGenerator characterGenerator = mock(CharacterGenerator.class);

        // Given
        given(characterGeneratorFactory.generator(characters)).willReturn(characterGenerator);

        // When
        final Strings actual = factory.strings(characters);

        // Then
        assertThat(actual, instanceOf(LoopGenerationStrings.class));
        assertPropertyReflectionEquals("random", random, actual);
        assertPropertyReflectionEquals("characterGenerator", characterGenerator, actual);
    }
}

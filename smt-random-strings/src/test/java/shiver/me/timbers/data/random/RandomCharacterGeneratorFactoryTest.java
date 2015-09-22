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

import java.util.Random;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyReflectionEquals;

public class RandomCharacterGeneratorFactoryTest {

    @Test
    public void Can_create_a_random_character_generator() {

        // Given
        final Random random = mock(Random.class);

        // When
        final CharacterGenerator actual = new RandomCharacterGeneratorFactory(random).generator();

        // Then
        assertThat(actual, instanceOf(RandomCharacterGenerator.class));
        assertPropertyReflectionEquals("random", random, actual);
    }

    @Test
    public void Can_create_a_random_limited_character_generator() {

        // Given
        final Random random = mock(Random.class);
        final String characters = "adcbe";

        // When
        final CharacterGenerator actual = new RandomCharacterGeneratorFactory(random).generator(characters);

        // Then
        assertThat(actual, instanceOf(RandomLimitedCharacterGenerator.class));
        assertPropertyReflectionEquals("random", random, actual);
        assertPropertyReflectionEquals("characters", characters, actual);
    }
}

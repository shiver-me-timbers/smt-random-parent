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

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class RandomLimitedCharacterFactoryTest {

    @Test
    public void Can_generate_a_random_character_from_a_specific_set_of_characters() {

        final Random random = mock(Random.class);
        final String characters = "abcde";

        // Given
        given(random.nextInt(characters.length())).willReturn(1);

        // When
        final Character actual = new RandomLimitedCharacterGenerator(random, characters).generate();

        // Then
        assertEquals((Character) 'b', actual);
    }
}

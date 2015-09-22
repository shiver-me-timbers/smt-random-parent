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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class SomeBooleansTest {

    @Test
    public void Can_generate_a_random_true_value() {

        final Random random = mock(Random.class);

        // Given
        given(random.nextInt(100)).willReturn(49);

        // When
        final Boolean actual = new SomeBooleans(random).someBoolean();

        // Then
        assertTrue(actual);
    }

    @Test
    public void Can_generate_a_random_false_value() {

        final Random random = mock(Random.class);

        // Given
        given(random.nextInt(100)).willReturn(50);

        // When
        final Boolean actual = new SomeBooleans(random).someBoolean();

        // Then
        assertFalse(actual);
    }
}

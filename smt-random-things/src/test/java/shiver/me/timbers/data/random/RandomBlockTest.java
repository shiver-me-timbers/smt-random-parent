/*
 * Copyright 2016 Karl Bennett
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

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class RandomBlockTest {

    @Test
    public void Can_build_a_random_block() {

        final Random random = mock(Random.class);
        final int zero = 0;
        final double one = 1.0;
        final String two = "two";
        final Object three = new Object();
        final Object[] randomValues = {zero, one, two, three};
        final int randomIndex = new Random().nextInt(randomValues.length);

        // Given
        given(random.nextInt(randomValues.length)).willReturn(randomIndex);

        // When
        final Object actual = new RandomBlock<>(random, randomValues).build();

        // Then
        assertThat(actual, anyOf(is(randomValues[randomIndex]), isA(Object.class)));
    }
}
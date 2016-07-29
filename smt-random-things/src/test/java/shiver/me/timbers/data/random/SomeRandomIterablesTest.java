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

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static shiver.me.timbers.data.random.Constants.DEFAULT_MAX_ARRAY_SIZE;
import static shiver.me.timbers.data.random.TestUtils.extractField;

public class SomeRandomIterablesTest {

    private Random random;
    private GeneratedIterables generatedIterables;
    private SomeRandomIterables iterables;

    @Before
    public void setUp() {
        random = mock(Random.class);
        generatedIterables = mock(GeneratedIterables.class);
        iterables = new SomeRandomIterables(random, generatedIterables);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_create_a_random_iterable_that_contains_some_random_things()
        throws NoSuchFieldException, IllegalAccessException {

        final int length = 5;
        final GeneratedIterable<Object> generatedIterable = mock(GeneratedIterable.class);

        // Given
        given(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)).willReturn(length);
        given(generatedIterables.create(length)).willReturn(generatedIterable);

        // When
        final RandomIterable<Object> actual = iterables.thatContains();

        // Then
        assertThat(actual, not(nullValue()));
        verifyZeroInteractions(generatedIterable);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_create_a_random_iterable_that_contains_some_specific_things()
        throws NoSuchFieldException, IllegalAccessException {

        final Object one = new Object();
        final int two = 2;
        final String three = "two";

        final int length = 5;
        final GeneratedIterable<Object> generatedIterable = mock(GeneratedIterable.class);
        final ArgumentCaptor<RandomBlock> captor = ArgumentCaptor.forClass(RandomBlock.class);

        // Given
        given(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)).willReturn(length);
        given(generatedIterables.create(length)).willReturn(generatedIterable);

        // When
        final RandomIterable<Object> actual = iterables.thatContains(one, two, three);

        // Then
        assertThat(actual, not(nullValue()));
        verify(generatedIterable).withGenerator(captor.capture());
        final RandomBlock randomBlock = captor.getValue();
        final Object randomBlockRandom = extractField(randomBlock, "random");
        final Object randomBlockRandomValues = extractField(randomBlock, "randomValues");
        assertThat(random, equalTo(randomBlockRandom));
        assertThat(new Object[]{one, two, three}, equalTo(randomBlockRandomValues));
    }
}
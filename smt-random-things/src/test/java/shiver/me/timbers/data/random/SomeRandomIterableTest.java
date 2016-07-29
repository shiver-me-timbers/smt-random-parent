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

import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SomeRandomIterableTest {

    private GeneratedIterable<Object> generatedIterable;
    private Random random;
    private SomeRandomIterable<Object> iterable;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        generatedIterable = mock(GeneratedIterable.class);
        random = mock(Random.class);
        iterable = new SomeRandomIterable<>(generatedIterable, random);
    }

    @Test
    public void Can_create_a_random_iterable_with_a_length() {

        // Given
        final int length = 5;

        // When
        final SomeRandomIterable<Object> actual = iterable.withLength(length);

        // Then
        assertThat(actual, is(iterable));
        verify(generatedIterable).withLength(length);
    }

    @Test
    public void Can_create_a_list_from_the_random_iterable() {

        @SuppressWarnings("unchecked")
        final List<Object> expected = mock(List.class);

        // Given
        given(generatedIterable.list()).willReturn(expected);

        // When
        final List<Object> actual = iterable.list();

        // Then
        assertThat(actual, is(expected));
    }
}
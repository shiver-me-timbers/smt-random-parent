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

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SomeThingsTest {

    private SomeThings someThings;
    private RandomIterables randomIterables;

    @Before
    public void setUp() {
        randomIterables = mock(RandomIterables.class);
        someThings = new SomeThings(randomIterables);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_generate_a_random_thing() {

        final RandomIterable<Object> randomIterable = mock(RandomIterable.class);
        final RandomIterable<Object> randomIterableWithLength = mock(RandomIterable.class);
        final List<Object> randomList = mock(List.class);

        final Object expected = new Object();

        // Given
        given(randomIterables.thatContainsRandom()).willReturn(randomIterable);
        given(randomIterable.withLength(1)).willReturn(randomIterableWithLength);
        given(randomIterableWithLength.list()).willReturn(randomList);
        given(randomList.get(0)).willReturn(expected);

        // When
        final Object actual = someThings.someThing();

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_generate_a_single_thing_from_some_things() {

        final Object[] things = {1, 2.0, "three", new Object()};

        final RandomIterable<Object> randomIterable = mock(RandomIterable.class);
        final RandomIterable<Object> randomIterableWithLength = mock(RandomIterable.class);
        final List<Object> randomList = mock(List.class);

        final Object expected = new Object();

        // Given
        given(randomIterables.thatContainsRandom(things)).willReturn(randomIterable);
        given(randomIterable.withLength(1)).willReturn(randomIterableWithLength);
        given(randomIterableWithLength.list()).willReturn(randomList);
        given(randomList.get(0)).willReturn(expected);

        // When
        final Object actual = someThings.someThing(things);

        // Then
        assertThat(actual, equalTo(expected));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_generate_some_random_things() {

        final RandomIterable<Object> expected = mock(RandomIterable.class);

        // Given
        given(randomIterables.thatContainsRandom()).willReturn(expected);

        // When
        final RandomIterable<Object> actual = someThings.someThings();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_generate_some_things_from_some_things() {

        final Object[] things = {};

        final RandomIterable<Object> expected = mock(RandomIterable.class);

        // Given
        given(randomIterables.thatContainsRandom(things)).willReturn(expected);

        // When
        final RandomIterable<Object> actual = someThings.someThings(things);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_generate_some_things_in_a_random_order() {

        final Object[] things = {};

        final RandomIterable<Object> expected = mock(RandomIterable.class);

        // Given
        given(randomIterables.thatContainsRandomlyOrdered(things)).willReturn(expected);

        // When
        final RandomIterable<Object> actual = someThings.someOrder(things);

        // Then
        assertThat(actual, is(expected));
    }
}
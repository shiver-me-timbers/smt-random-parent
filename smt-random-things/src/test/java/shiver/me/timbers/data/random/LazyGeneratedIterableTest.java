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
import shiver.me.timbers.building.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static shiver.me.timbers.data.random.Constants.DEFAULT_MAX_ARRAY_SIZE;

public class LazyGeneratedIterableTest {

    private Class<Object> type;
    private Random random;
    private Block<Object> defaultGenerator;
    private GeneratedIterable<Object> iterable;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        type = Object.class;
        random = mock(Random.class);
        defaultGenerator = mock(Block.class);
        iterable = new LazyGeneratedIterable<>(type, random, defaultGenerator);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_create_a_lazy_iterable() throws Exception {

        // Given
        final Random random = mock(Random.class);
        final Block<Object> block = mock(Block.class);

        // When
        new LazyGeneratedIterable<>(type, random, block);

        // Then
        verify(random).nextInt(DEFAULT_MAX_ARRAY_SIZE);
        verifyZeroInteractions(block);
    }

    @Test
    public void The_iterator_is_only_created_once() throws Exception {

        final Object element = new Object();

        // Given
        given(defaultGenerator.build(null)).willReturn(element);
        iterable.withLength(1);

        // When
        iterable.iterator();
        iterable.iterator();

        // Then
        verify(defaultGenerator).build(null);
    }

    @Test
    public void The_same_iterator_is_always_returned() throws Exception {

        final Object one = new Object();
        final Object two = new Object();

        // Given
        given(defaultGenerator.build(null)).willReturn(one);
        given(defaultGenerator.build(one)).willReturn(two);
        iterable.withLength(2);

        // When
        final List<Object> actual1 = toList(iterable);
        final List<Object> actual2 = toList(iterable);

        // Then
        assertThat(actual1, contains(one, two));
        assertThat(actual1, equalTo(actual2));
    }

    @Test
    public void Can_convert_to_list() throws Exception {

        final Object one = new Object();
        final Object two = new Object();

        // Given
        given(defaultGenerator.build(null)).willReturn(one);
        given(defaultGenerator.build(one)).willReturn(two);
        iterable.withLength(2);

        // When
        final List<Object> actual = iterable.list();

        // Then
        assertThat(actual, contains(one, two));
    }

    @Test
    public void Can_convert_to_array() throws Exception {

        final Object one = new Object();
        final Object two = new Object();

        // Given
        given(defaultGenerator.build(null)).willReturn(one);
        given(defaultGenerator.build(one)).willReturn(two);
        iterable.withLength(2);

        // When
        final Object[] actual = iterable.array();

        // Then
        assertThat(actual, arrayContaining(one, two));
    }

    @Test
    public void Can_convert_to_set() throws Exception {

        final Object one = new Object();
        final Object two = new Object();

        // Given
        given(defaultGenerator.build(null)).willReturn(one);
        given(defaultGenerator.build(one)).willReturn(two);
        iterable.withLength(2);

        // When
        final Set<Object> actual = iterable.set();

        // Then
        assertThat(actual, containsInAnyOrder(one, two));
    }

    @Test
    public void Can_add_a_custom_generator() throws Exception {

        final Object one = new Object();
        @SuppressWarnings("unchecked")
        final Block<Object> generator = mock(Block.class);

        // Given
        iterable.withLength(1);
        iterable.withGenerator(generator);
        given(generator.build(null)).willReturn(one);

        // When
        final Set<Object> actual = iterable.set();

        // Then
        assertThat(actual, contains(one));
        verifyZeroInteractions(defaultGenerator);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Will_rotate_through_generators() throws Exception {

        final Object one = new Object();
        final Object two = new Object();
        final Object three = new Object();
        final Block<Object> generator1 = mock(Block.class);
        final Block<Object> generator2 = mock(Block.class);

        // Given
        iterable.withLength(3);
        iterable.withGenerator(generator1);
        iterable.withGenerator(generator2);
        given(generator1.build(null)).willReturn(one);
        given(generator2.build(one)).willReturn(two);
        given(generator1.build(two)).willReturn(three);

        // When
        final List<Object> actual = toList(iterable);

        // Then
        assertThat(actual, contains(one, two, three));
        verifyZeroInteractions(defaultGenerator);
    }

    private static List<Object> toList(Iterable<Object> iterable) {
        final List<Object> list = new ArrayList<>();
        for (Object element : iterable) {
            list.add(element);
        }
        return list;
    }
}

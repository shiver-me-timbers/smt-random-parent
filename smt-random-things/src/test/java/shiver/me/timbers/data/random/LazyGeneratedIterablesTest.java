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

import java.lang.reflect.Field;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.Constants.DEFAULT_MAX_ARRAY_SIZE;

public class LazyGeneratedIterablesTest {

    private Random random;
    private Block block;
    private LazyGeneratedIterables iterables;

    @Before
    public void setUp() {
        random = mock(Random.class);
        block = mock(Block.class);
        iterables = new LazyGeneratedIterables(random, block);
    }

    @Test
    public void Can_create_a_typed_lazy_generated_iterable() throws NoSuchFieldException, IllegalAccessException {

        final Class<String> type = String.class;

        final int size = 5;

        // Given
        given(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)).willReturn(size);

        // When
        final GeneratedIterable<String> actual = iterables.create(type);

        // Then
        final Class<? extends GeneratedIterable> actualClass = actual.getClass();
        final Object actualType = extractField(actual, actualClass, "type");
        final Object actualSize = extractField(actual, actualClass, "size");
        final Object actualBlock = extractField(actual, actualClass, "defaultGenerator");

        assertThat(type, is(actualType));
        assertThat(size, is(actualSize));
        assertThat(block, is(actualBlock));
    }

    @Test
    public void Can_create_a_lazy_generated_iterable() throws NoSuchFieldException, IllegalAccessException {

        final int size = 8;

        // Given
        given(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)).willReturn(size);

        // When
        final GeneratedIterable actual = iterables.create();

        // Then
        final Class<? extends GeneratedIterable> actualClass = actual.getClass();
        final Object actualType = extractField(actual, actualClass, "type");
        final Object actualSize = extractField(actual, actualClass, "size");
        final Object actualBlock = extractField(actual, actualClass, "defaultGenerator");

        assertThat(Object.class, is(actualType));
        assertThat(size, is(actualSize));
        assertThat(block, is(actualBlock));
    }

    private Object extractField(Object actual, Class type, String name)
        throws IllegalAccessException, NoSuchFieldException {
        final Field field = type.getDeclaredField(name);
        field.setAccessible(true);
        return field.get(actual);
    }
}
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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.TestUtils.extractField;

public class LazyGeneratedIterablesTest {

    private Block block;
    private LazyGeneratedIterables iterables;

    @Before
    public void setUp() {
        block = mock(Block.class);
        iterables = new LazyGeneratedIterables(block);
    }

    @Test
    public void Can_create_a_typed_lazy_generated_iterable() throws NoSuchFieldException, IllegalAccessException {

        // Given
        final int length = 5;
        final Class<String> type = String.class;

        // When
        final GeneratedIterable<String> actual = iterables.create(length, type);

        // Then
        final Object actualType = extractField(actual, "type");
        final Object actualLength = extractField(actual, "length");
        final Object actualBlock = extractField(actual, "defaultGenerator");

        assertThat(type, is(actualType));
        assertThat(length, is(actualLength));
        assertThat(block, is(actualBlock));
    }

    @Test
    public void Can_create_a_lazy_generated_iterable() throws NoSuchFieldException, IllegalAccessException {

        // Given
        final int length = 8;

        // When
        final GeneratedIterable actual = iterables.create(length);

        // Then
        final Object actualType = extractField(actual, "type");
        final Object actualLength = extractField(actual, "length");
        final Object actualBlock = extractField(actual, "defaultGenerator");

        assertThat(Object.class, is(actualType));
        assertThat(length, is(actualLength));
        assertThat(block, is(actualBlock));
    }
}
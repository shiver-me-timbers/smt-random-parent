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
import org.mockito.InOrder;
import shiver.me.timbers.building.ItemBlock;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class SomeRandomIterablesTest {

    private GeneratedIterables generatedIterables;
    private SomeRandomIterables iterables;

    @Before
    public void setUp() {
        generatedIterables = mock(GeneratedIterables.class);
        iterables = new SomeRandomIterables(generatedIterables);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_create_a_random_iterable_that_contains_some_specific_things() {

        final Object one = new Object();
        final int two = 2;
        final String three = "two";

        final GeneratedIterable<Object> generatedIterable = mock(GeneratedIterable.class);

        // Given
        given(generatedIterables.create()).willReturn(generatedIterable);

        // When
        final RandomIterable<Object> actual = iterables.thatContains(one, two, three);

        // Then
        assertThat(actual, not(nullValue()));
        final InOrder order = inOrder(generatedIterable);
        order.verify(generatedIterable).withGenerator(new ItemBlock<>(one));
        order.verify(generatedIterable).withGenerator(new ItemBlock<Object>(two));
        order.verify(generatedIterable).withGenerator(new ItemBlock<Object>(three));
    }
}
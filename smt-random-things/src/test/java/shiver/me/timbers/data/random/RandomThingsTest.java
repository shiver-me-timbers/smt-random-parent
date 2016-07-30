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

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomThings.someOrder;
import static shiver.me.timbers.data.random.RandomThings.someThing;
import static shiver.me.timbers.data.random.RandomThings.someThings;

public class RandomThingsTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomThings();
    }

    @Test
    public void Can_generate_some_random_thing() {

        // When
        final Object actual = someThing();

        // Then
        assertThat(actual, not(nullValue()));
    }

    @Test
    public void Can_generate_some_specific_thing() {

        // Given
        final Object zero = new Object();
        final Object one = 1;
        final Object two = "two";

        // When
        final Object actual = someThing(zero, one, two);

        // Then
        assertThat(actual, isOneOf(zero, one, two));
    }

    @Test
    public void Can_generate_some_random_things_as_a_list() {

        // When
        final List<Object> actual = someThings().list();

        // Then
        assertThat(actual, not(nullValue()));
        assertThat(actual, hasSize(greaterThan(0)));
    }

    @Test
    public void Can_generate_some_random_things_as_an_array() {

        // When
        final Object[] actual = someThings().array();

        // Then
        assertThat(actual, not(nullValue()));
        assertThat(actual.length, greaterThan(0));
    }

    @Test
    public void Can_generate_some_random_things_as_a_set() {

        // When
        final Set<Object> actual = someThings().set();

        // Then
        assertThat(actual, not(nullValue()));
        assertThat(actual, hasSize(greaterThan(0)));
    }

    @Test
    public void Can_generate_some_specific_things() {

        // Given
        final Object zero = new Object();
        final Object one = 1;
        final Object two = "two";

        // When
        final List<Object> actual = someThings(zero, one, two).list();

        // Then
        assertThat(actual, anyOf(hasItem(zero), hasItem(one), hasItem(two)));
    }

    @Test
    public void Can_generate_some_things_with_a_fixed_length() {

        // Given
        final int size = 5;
        final Object zero = new Object();
        final int one = 1;
        final String two = "two";

        // When
        final List<Object> actual = someThings(zero, one, two).withLength(size).list();

        // Then
        assertThat(actual, hasSize(size));
        assertThat(actual, anyOf(hasItem(zero), hasItem(one), hasItem(two)));
    }

    @Test
    public void Can_generate_a_randomised_order_of_things() {

        // Given
        final Object zero = new Object();
        final int one = 1;
        final float two = 2.0F;
        final String three = "three";

        // When
        final List<Object> actual = someOrder(zero, one, two, three).list();

        // Then
        assertThat(actual, hasSize(4));
        assertThat(actual, containsInAnyOrder(zero, one, two, three));
        assertThat(actual, not(contains(zero, one, two, three)));
    }
}
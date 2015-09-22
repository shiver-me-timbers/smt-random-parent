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

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.apache.commons.io.IOUtils.toByteArray;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomBytes.someByte;
import static shiver.me.timbers.data.random.RandomBytes.someByteInputStream;
import static shiver.me.timbers.data.random.RandomBytes.someBytes;
import static shiver.me.timbers.data.random.test.IsANumber.isAByte;
import static shiver.me.timbers.data.random.test.TestUtils.assertThatAll;
import static shiver.me.timbers.data.random.test.TestUtils.cast;

public class RandomBytesTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new RandomBytes();
    }

    @Test
    public void A_random_byte_can_be_generated() {

        // When
        final byte actual = someByte();

        // Then
        assertThat(actual, isAByte());
    }

    @Test
    public void Some_random_bytes_can_be_generated() {

        // When
        final byte[] actual = someBytes();

        // Then
        assertThat(actual.length, greaterThan(0));
        assertThatAll(isAByte(), cast(Byte.class, actual));
    }

    @Test
    public void A_specific_number_of_random_bytes_can_be_generated() {

        // Given
        final int length = 6;

        // When
        final byte[] actual = RandomBytes.someBytes(length);

        // Then
        assertEquals(length, actual.length);
        assertThatAll(isAByte(), cast(Byte.class, actual));
    }

    @Test
    public void A_random_byte_input_stream_can_be_generated() throws IOException {

        // When
        final ByteArrayInputStream actual = someByteInputStream();

        // Then
        final byte[] bytes = toByteArray(actual);
        assertThat(bytes.length, greaterThan(0));
        assertThatAll(isAByte(), cast(Byte.class, bytes));
    }

    @Test
    public void A_random_byte_input_stream_of_a_specific_length_can_be_generated() throws IOException {

        // Given
        final int length = 7;

        // When
        final ByteArrayInputStream actual = RandomBytes.someByteInputStream(length);

        // Then
        final byte[] bytes = toByteArray(actual);
        assertEquals(length, bytes.length);
        assertThatAll(isAByte(), cast(Byte.class, bytes));
    }
}

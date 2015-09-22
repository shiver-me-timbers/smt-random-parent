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
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

import static java.lang.System.arraycopy;
import static org.apache.commons.io.IOUtils.toByteArray;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalMatchers.aryEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.NumberUtils.DEFAULT_MAX_ARRAY_SIZE;

public class BytesTest {

    @Test
    public void A_random_byte_can_be_produced() {

        final Random random = mock(Random.class);
        final byte expected = 1;

        // Given
        willAnswer(new CopyBytes(new byte[]{expected})).given(random).nextBytes(aryEq(new byte[]{0}));

        // When
        final byte actual = new Bytes(random).aByte();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void A_random_byte_array_can_be_produced() {

        final Random random = mock(Random.class);
        final int length = 2;
        final byte[] expected = {1, 2};

        // Given
        given(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)).willReturn(length);
        willAnswer(new CopyBytes(expected)).given(random).nextBytes(new byte[]{0, 0});

        // When
        final byte[] actual = new Bytes(random).aByteArray();

        // Then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void A_random_byte_array_of_a_specific_size_can_be_produced() {

        final Random random = mock(Random.class);
        final int length = 3;
        final byte[] expected = {1, 2, 3};

        // Given
        willAnswer(new CopyBytes(expected)).given(random).nextBytes(new byte[]{0, 0, 0});

        // When
        final byte[] actual = new Bytes(random).aByteArray(length);

        // Then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void A_random_byte_input_stream_can_be_produced() throws IOException {

        final Random random = mock(Random.class);
        final int length = 4;
        final byte[] expected = {1, 2, 3, 4};

        // Given
        given(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)).willReturn(length);
        willAnswer(new CopyBytes(expected)).given(random).nextBytes(new byte[]{0, 0, 0, 0});

        // When
        final ByteArrayInputStream actual = new Bytes(random).aByteInputStream();

        // Then
        assertArrayEquals(expected, toByteArray(actual));
    }

    @Test
    public void A_random_byte_input_stream_of_a_specific_size_can_be_produced() throws IOException {

        final Random random = mock(Random.class);
        final int length = 5;
        final byte[] expected = {1, 2, 3, 4, 5};

        // Given
        willAnswer(new CopyBytes(expected)).given(random).nextBytes(new byte[]{0, 0, 0, 0, 0});

        // When
        final ByteArrayInputStream actual = new Bytes(random).aByteInputStream(length);

        // Then
        assertArrayEquals(expected, toByteArray(actual));
    }

    private static class CopyBytes implements Answer {

        private final byte[] expected;

        public CopyBytes(byte[] expected) {
            this.expected = expected;
        }

        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            arraycopy(expected, 0, invocation.getArguments()[0], 0, expected.length);
            return null;
        }
    }
}

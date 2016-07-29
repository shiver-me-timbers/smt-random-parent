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

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.Constants.DEFAULT_MAX_ARRAY_SIZE;

public class SomeRandomBlockTest {

    @Test
    public void Can_build_a_random_block() {

        final Random random = mock(Random.class);

        final Object object = new Object();
        final byte[] bytesValue = Arrays.copyOf(new byte[]{1, 2, 3}, DEFAULT_MAX_ARRAY_SIZE);
        final boolean booleanValue = true;
        final int intValue = 5;
        final float floatValue = 8F;
        final long longValue = 13L;
        final double doubleValue = 21D;
        final String string = "a random string";

        final Object[] randomValues =
            {object, booleanValue, bytesValue, intValue, floatValue, longValue, doubleValue, string};
        final int randomIndex = new Random().nextInt(randomValues.length);

        // Given
        given(random.nextBoolean()).willReturn(booleanValue);
        willAnswer(populateBytes(bytesValue)).given(random).nextBytes(any(byte[].class));
        given(random.nextInt()).willReturn(intValue);
        given(random.nextFloat()).willReturn(floatValue);
        given(random.nextLong()).willReturn(longValue);
        given(random.nextDouble()).willReturn(doubleValue);
        given(random.nextInt(randomValues.length)).willReturn(randomIndex);

        // When
        final Object actual = new SomeRandomBlock(random).build();

        // Then
        assertThat(actual, anyOf(is(randomValues[randomIndex]), isA(Object.class)));
    }

    private Answer<byte[]> populateBytes(final byte[] bytesValue) {
        return new Answer<byte[]>() {
            @Override
            public byte[] answer(InvocationOnMock invocation) throws Throwable {
                final byte[] bytes = invocation.getArgumentAt(0, byte[].class);
                System.arraycopy(bytesValue, 0, bytes, 0, bytesValue.length);
                return null;
            }
        };
    }
}
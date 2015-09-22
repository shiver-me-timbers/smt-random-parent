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

import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyReflectionEquals;
import static shiver.me.timbers.data.random.NumberUtils.DEFAULT_MAX_ARRAY_SIZE;

public class GenericMultipleNumbersTest {

    private Class<Number> type;
    private SingleNumbers<Number> singleNumbers;
    private Random random;

    private GenericMultipleNumbers<Number> multipleNumbers;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {

        type = Number.class;
        singleNumbers = mock(SingleNumbers.class);
        random = mock(Random.class);

        multipleNumbers = new GenericMultipleNumbers<>(type, singleNumbers, random);
    }

    @Test
    public void A_random_length_iterable_of_numbers_can_be_produced() {

        final int length = 1;

        // Given
        given(random.nextInt(DEFAULT_MAX_ARRAY_SIZE)).willReturn(length);

        // When
        final Iterable<Number> actual = multipleNumbers.someNumbers();

        // Then
        assertPropertyReflectionEquals("type", type, actual);
        assertPropertyReflectionEquals("singleNumbers", singleNumbers, actual);
        assertPropertyReflectionEquals("length", length, actual);
    }

    @Test
    public void A_fixed_length_iterable_of_numbers_can_be_produced() {

        // Given
        final int length = 1;

        // When
        final Iterable<Number> actual = multipleNumbers.someNumbers(length);

        // Then
        assertPropertyReflectionEquals("type", type, actual);
        assertPropertyReflectionEquals("singleNumbers", singleNumbers, actual);
        assertPropertyReflectionEquals("length", length, actual);
    }
}

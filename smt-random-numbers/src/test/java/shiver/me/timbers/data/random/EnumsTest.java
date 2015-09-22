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
import shiver.me.timbers.data.random.test.TEST_ENUM;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class EnumsTest {

    @Test
    public void A_random_enum_can_be_generated() throws Exception {

        final Random random = mock(Random.class);
        final Class<TEST_ENUM> enumClass = TEST_ENUM.class;

        // Given
        given(random.nextInt(TEST_ENUM.values().length)).willReturn(1);

        // When
        final Enum actual = new Enums<>(random, enumClass).someEnum();

        // Then
        assertEquals(TEST_ENUM.TWO, actual);
    }
}

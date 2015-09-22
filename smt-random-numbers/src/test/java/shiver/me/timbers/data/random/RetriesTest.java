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

import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.Retries.retry;

public class RetriesTest {

    @Test
    public void Instantiation_to_get_full_coverage() {

        new Retries();
    }

    @Test
    public void Can_retry_until_a_success() throws Exception {

        final Callable callable = mock(Callable.class);
        final Object expected = mock(Object.class);

        // Given
        given(callable.call()).willThrow(new Exception()).willReturn(expected);

        // When
        final Object actual = retry(2, callable);

        // Then
        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void Can_throw_exception_from_retry() throws Exception {

        final Callable callable = mock(Callable.class);

        // Given
        given(callable.call()).willThrow(new Exception());

        // When
        retry(1, callable);
    }
}

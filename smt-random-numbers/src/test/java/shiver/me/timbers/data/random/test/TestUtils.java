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

package shiver.me.timbers.data.random.test;

import org.hamcrest.Matcher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class TestUtils {

    public static final int TEST_RETRY_AMOUNT = 10;

    @SafeVarargs
    public static <T extends Comparable> void assertThatAll(Matcher<T> matcher, T... values) {

        for (T value : values) {
            assertThat(value, matcher);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] cast(Class<T> type, Object array) {

        final int length = Array.getLength(array);

        final T[] cast = (T[]) Array.newInstance(type, length);

        for (int i = 0; i < length; i++) {
            cast[i] = (T) Array.get(array, i);
        }

        return cast;
    }

    public static <N extends Number> List<N> toList(Iterable<N> iterable) {

        final List<N> list = new ArrayList<>();

        for (N number : iterable) {
            list.add(number);
        }

        return list;
    }
}

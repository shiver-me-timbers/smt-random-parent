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

import shiver.me.timbers.building.Block;

import java.util.List;
import java.util.Set;

/**
 * An extension of {@link Iterable} that adds some extra converters, element generators, and the ability to set the
 * number of elements it contains.
 * <p>
 * The generators are added in order and then cycled in order to populate the iterable.
 * <pre>
 * {@code
 * System.out.println(someShorts(5).thatArePositive().thatAreLessThan(4));
 * // [ somePositiveShort(), someShortLessThan(4), somePositiveShort(), someShortLessThan(4), somePositiveShort() ]
 * }
 * </pre>
 *
 * @author Karl Bennett
 */
interface GeneratedIterable<T> extends Iterable<T> {

    List<T> list();

    T[] array();

    Set<T> set();

    GeneratedIterable<T> withGenerator(Block<T> generator);

    GeneratedIterable<T> withLength(int length);
}

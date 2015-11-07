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

/**
 * This interface is used to apply generic operations of {@link Number}s of different types.
 *
 * @author Karl Bennett
 */
interface NumberOperations<N extends Number> {

    N someNumber();

    boolean isPositive(N number);

    boolean isNegative(N number);

    N someNumber(N bound);

    N switchSign(N number);

    N abs(N value);

    N plus(N left, N right);

    N minus(N left, N right);

    boolean greaterThan(N left, N right);

    boolean isInBetween(N min, N max, N value);

    Integer nextInt(Integer bound);
}

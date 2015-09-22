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
 * This interface provides methods for checking if two numbers are going to exceed the numbers maximum value when summed
 * or subtracted.
 *
 * @author Karl Bennett
 */
interface OverflowChecker<N extends Number> {

    boolean willNotOverflowIfSummed(N left, N right);

    boolean willNotOverflowIfSubtracted(N left, N right);
}

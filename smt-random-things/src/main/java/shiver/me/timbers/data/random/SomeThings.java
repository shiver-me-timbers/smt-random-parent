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
 * @author Karl Bennett
 */
class SomeThings implements Things {

    private final RandomIterables randomIterables;

    public SomeThings(RandomIterables randomIterables) {
        this.randomIterables = randomIterables;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T someThing(T... things) {
        return someThings(things).withLength(1).list().get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> RandomIterable<T> someThings(T... things) {
        return randomIterables.thatContains(things);
    }
}

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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class SomeThings implements Things {

    private final Random random;

    public SomeThings(Random random) {
        this.random = random;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T someThing(T... things) {
        return things[random.nextInt(things.length)];
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> someThings(T... things) {
        return someThings(random.nextInt(1024), things);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> someThings(int length, T... things) {

        final List<T> someThings = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            someThings.add(things[random.nextInt(things.length)]);
        }

        return someThings;
    }
}

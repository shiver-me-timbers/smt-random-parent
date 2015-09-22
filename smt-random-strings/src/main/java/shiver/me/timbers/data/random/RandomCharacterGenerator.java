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

import java.util.Random;

/**
 * @author Karl Bennett
 */
class RandomCharacterGenerator implements CharacterGenerator {

    private final Random random;

    public RandomCharacterGenerator(Random random) {
        this.random = random;
    }

    @Override
    public Character generate() {

        // Generate a number in the range of 32 to 126. These are the values for all the printable ASCII characters.
        return (char) (32 + random.nextInt(95));
    }
}

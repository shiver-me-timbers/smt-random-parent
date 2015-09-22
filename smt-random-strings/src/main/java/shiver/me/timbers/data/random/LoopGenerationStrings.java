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

import static shiver.me.timbers.data.random.Constants.MAX_STRING_LENGTH;

/**
 * @author Karl Bennett
 */
class LoopGenerationStrings implements Strings {

    private final Random random;
    private final CharacterGenerator characterGenerator;

    LoopGenerationStrings(Random random, CharacterGenerator characterGenerator) {
        this.random = random;
        this.characterGenerator = characterGenerator;
    }

    @Override
    public String someString() {
        return someString(random.nextInt(MAX_STRING_LENGTH));
    }

    @Override
    public String someString(int length) {

        final StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            builder.append(characterGenerator.generate());
        }

        return builder.toString();
    }
}

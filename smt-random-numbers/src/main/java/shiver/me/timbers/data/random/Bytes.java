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

import java.io.ByteArrayInputStream;
import java.util.Random;

import static shiver.me.timbers.data.random.NumberUtils.DEFAULT_MAX_ARRAY_SIZE;

/**
 * Simple helper methods for generating random byte values.
 *
 * @author Karl Bennett
 */
class Bytes {

    private final Random random;

    Bytes(Random random) {
        this.random = random;
    }

    byte aByte() {
        return aByteArray(1)[0];
    }

    byte[] aByteArray() {
        return aByteArray(random.nextInt(DEFAULT_MAX_ARRAY_SIZE));
    }

    byte[] aByteArray(int length) {

        final byte[] bytes = new byte[length];

        random.nextBytes(bytes);

        return bytes;
    }

    ByteArrayInputStream aByteInputStream() {
        return aByteInputStream(random.nextInt(DEFAULT_MAX_ARRAY_SIZE));
    }

    ByteArrayInputStream aByteInputStream(int length) {
        return new ByteArrayInputStream(aByteArray(length));
    }
}

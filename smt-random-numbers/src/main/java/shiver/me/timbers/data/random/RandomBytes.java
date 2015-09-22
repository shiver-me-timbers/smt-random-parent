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
import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple helper methods for generating random byte values.
 *
 * @author Karl Bennett
 */
public class RandomBytes {

    private static Bytes bytes() {
        return new Bytes(ThreadLocalRandom.current());
    }

    /**
     * Generate a random byte value.
     */
    public static byte someByte() {
        return bytes().aByte();
    }

    /**
     * Generate a byte array of a random size that contains random byte values.
     */
    public static byte[] someBytes() {
        return bytes().aByteArray();
    }

    /**
     * Generate a byte array of a specific size that contains random byte values.
     */
    public static byte[] someBytes(int length) {
        return bytes().aByteArray(length);
    }

    /**
     * Generate a byte input stream of a random length that contains random byte values.
     */
    public static ByteArrayInputStream someByteInputStream() {
        return bytes().aByteInputStream();
    }

    /**
     * Generate a byte input stream of a specific length that contains random byte values.
     */
    public static ByteArrayInputStream someByteInputStream(int length) {
        return bytes().aByteInputStream(length);
    }
}

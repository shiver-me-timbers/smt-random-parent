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
class NumberUtils {

    static final int DEFAULT_MAX_ARRAY_SIZE = 2048;

    static boolean isInBetween(long min, long max, long value) {
        return !(value < min || value > max);
    }

    static boolean isInBetween(double min, double max, double value) {
        return !(value < min || value > max);
    }

    static boolean isPositive(long value) {
        return value > 0;
    }

    static boolean isPositive(double value) {
        return value > 0;
    }

    static boolean isNegative(long value) {
        return value < 0;
    }

    static boolean isNegative(double value) {
        return value < 0;
    }

    static long switchSign(long value) {
        return value * -1L;
    }

    static double switchSign(double value) {
        return value * -1;
    }
}

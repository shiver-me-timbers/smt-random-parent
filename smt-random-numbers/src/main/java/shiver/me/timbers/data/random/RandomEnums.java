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

import java.util.concurrent.ThreadLocalRandom;

/**
 * Simple helper methods for generating random enums.
 *
 * @author Karl Bennett
 */
public class RandomEnums {

    static <E extends Enum> Enums<E> enums(Class<E> enumClass) {

        return new Enums<>(ThreadLocalRandom.current(), enumClass);
    }

    /**
     * Generate a random enum.
     */
    public static <E extends Enum> E someEnum(Class<E> enumClass) {
        return enums(enumClass).someEnum();
    }
}

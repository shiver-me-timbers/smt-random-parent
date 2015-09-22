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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 * @author Karl Bennett
 */
class RandomBigDecimalFactory implements RandomBigNumberFactory<BigDecimal> {

    @Override
    public BigDecimal create(int numBits, Random random) {
        return new BigDecimal(new BigInteger(numBits, random), numBits);
    }
}

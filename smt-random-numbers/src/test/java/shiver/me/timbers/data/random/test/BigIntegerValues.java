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

package shiver.me.timbers.data.random.test;

import java.math.BigInteger;

public class BigIntegerValues implements NumberValues<BigInteger> {

    @Override
    public BigInteger negativeOne() {
        return BigInteger.valueOf(-1);
    }

    @Override
    public BigInteger zero() {
        return BigInteger.ZERO;
    }

    @Override
    public BigInteger one() {
        return BigInteger.ONE;
    }

    @Override
    public BigInteger two() {
        return BigInteger.valueOf(2);
    }

    @Override
    public BigInteger three() {
        return BigInteger.valueOf(3);
    }

    @Override
    public BigInteger four() {
        return BigInteger.valueOf(4);
    }

    @Override
    public BigInteger five() {
        return BigInteger.valueOf(5);
    }

    @Override
    public BigInteger positive() {
        return BigInteger.valueOf(9999);
    }

    @Override
    public BigInteger negative() {
        return BigInteger.valueOf(-9999);
    }

    @Override
    public BigInteger negativeMin() {
        return BigInteger.valueOf(-9999);
    }

    @Override
    public BigInteger negativeMax() {
        return BigInteger.valueOf(-99);
    }

    @Override
    public BigInteger positiveMin() {
        return BigInteger.valueOf(99);
    }

    @Override
    public BigInteger positiveMax() {
        return positive();
    }
}

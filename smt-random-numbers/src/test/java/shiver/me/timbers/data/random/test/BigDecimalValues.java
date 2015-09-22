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

import java.math.BigDecimal;

public class BigDecimalValues implements NumberValues<BigDecimal> {

    @Override
    public BigDecimal negativeOne() {
        return BigDecimal.valueOf(-1);
    }

    @Override
    public BigDecimal zero() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal one() {
        return BigDecimal.ONE;
    }

    @Override
    public BigDecimal two() {
        return BigDecimal.valueOf(2);
    }

    @Override
    public BigDecimal three() {
        return BigDecimal.valueOf(3);
    }

    @Override
    public BigDecimal four() {
        return BigDecimal.valueOf(4);
    }

    @Override
    public BigDecimal five() {
        return BigDecimal.valueOf(5);
    }

    @Override
    public BigDecimal positive() {
        return BigDecimal.valueOf(9999);
    }

    @Override
    public BigDecimal negative() {
        return BigDecimal.valueOf(-9999);
    }

    @Override
    public BigDecimal negativeMin() {
        return BigDecimal.valueOf(-9999);
    }

    @Override
    public BigDecimal negativeMax() {
        return BigDecimal.valueOf(-99);
    }

    @Override
    public BigDecimal positiveMin() {
        return BigDecimal.valueOf(99);
    }

    @Override
    public BigDecimal positiveMax() {
        return positive();
    }
}

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

public class ShortValues implements BoundNumberValues<Short> {

    @Override
    public Short negativeOne() {
        return -1;
    }

    @Override
    public Short zero() {
        return 0;
    }

    @Override
    public Short one() {
        return 1;
    }

    @Override
    public Short two() {
        return 2;
    }

    @Override
    public Short three() {
        return 3;
    }

    @Override
    public Short four() {
        return 4;
    }

    @Override
    public Short five() {
        return 5;
    }

    @Override
    public Short positive() {
        return 9999;
    }

    @Override
    public Short negative() {
        return -9999;
    }

    @Override
    public Short negativeMin() {
        return -9999;
    }

    @Override
    public Short negativeMax() {
        return -99;
    }

    @Override
    public Short positiveMin() {
        return 99;
    }

    @Override
    public Short positiveMax() {
        return positive();
    }

    @Override
    public Short negativeJustOverHalfMaxValue() {
        return (short) (minValue() / 2);
    }

    @Override
    public Short positiveJustOverHalfMaxValue() {
        return (short) (maxValue() / 2);
    }

    @Override
    public Short minValue() {
        return Short.MIN_VALUE;
    }

    @Override
    public Short maxValue() {
        return Short.MAX_VALUE;
    }
}

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

public class IntegerValues implements BoundNumberValues<Integer> {

    @Override
    public Integer negativeOne() {
        return -1;
    }

    @Override
    public Integer zero() {
        return 0;
    }

    @Override
    public Integer one() {
        return 1;
    }

    @Override
    public Integer two() {
        return 2;
    }

    @Override
    public Integer three() {
        return 3;
    }

    @Override
    public Integer four() {
        return 4;
    }

    @Override
    public Integer five() {
        return 5;
    }

    @Override
    public Integer positive() {
        return 9999;
    }

    @Override
    public Integer negative() {
        return -9999;
    }

    @Override
    public Integer negativeMin() {
        return -9999;
    }

    @Override
    public Integer negativeMax() {
        return -99;
    }

    @Override
    public Integer positiveMin() {
        return 99;
    }

    @Override
    public Integer positiveMax() {
        return positive();
    }

    @Override
    public Integer negativeJustOverHalfMaxValue() {
        return minValue() / 2;
    }

    @Override
    public Integer positiveJustOverHalfMaxValue() {
        return maxValue() / 2;
    }

    @Override
    public Integer minValue() {
        return Integer.MIN_VALUE;
    }

    @Override
    public Integer maxValue() {
        return Integer.MAX_VALUE;
    }
}

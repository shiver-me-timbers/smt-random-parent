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

public class DoubleValues implements BoundNumberValues<Double> {

    @Override
    public Double negativeOne() {
        return -1.0D;
    }

    @Override
    public Double zero() {
        return 0.0D;
    }

    @Override
    public Double one() {
        return 1.0D;
    }

    @Override
    public Double two() {
        return 2.0D;
    }

    @Override
    public Double three() {
        return 3.0D;
    }

    @Override
    public Double four() {
        return 4.0D;
    }

    @Override
    public Double five() {
        return 5.0D;
    }

    @Override
    public Double positive() {
        return 9999.0D;
    }

    @Override
    public Double negative() {
        return -9999.0D;
    }

    @Override
    public Double negativeMin() {
        return -9999.0D;
    }

    @Override
    public Double negativeMax() {
        return -99.0D;
    }

    @Override
    public Double positiveMin() {
        return 99.0D;
    }

    @Override
    public Double positiveMax() {
        return positive();
    }

    @Override
    public Double negativeJustOverHalfMaxValue() {
        return minValue() / 2;
    }

    @Override
    public Double positiveJustOverHalfMaxValue() {
        return maxValue() / 2;
    }

    @Override
    public Double minValue() {
        return -Double.MAX_VALUE;
    }

    @Override
    public Double maxValue() {
        return Double.MAX_VALUE;
    }
}

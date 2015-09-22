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

public class FloatValues implements BoundNumberValues<Float> {

    @Override
    public Float negativeOne() {
        return -1.0F;
    }

    @Override
    public Float zero() {
        return 0.0F;
    }

    @Override
    public Float one() {
        return 1.0F;
    }

    @Override
    public Float two() {
        return 2.0F;
    }

    @Override
    public Float three() {
        return 3.0F;
    }

    @Override
    public Float four() {
        return 4.0F;
    }

    @Override
    public Float five() {
        return 5.0F;
    }

    @Override
    public Float positive() {
        return 9999.0F;
    }

    @Override
    public Float negative() {
        return -9999.0F;
    }

    @Override
    public Float negativeMin() {
        return -9999.0F;
    }

    @Override
    public Float negativeMax() {
        return -99.0F;
    }

    @Override
    public Float positiveMin() {
        return 99.0F;
    }

    @Override
    public Float positiveMax() {
        return positive();
    }

    @Override
    public Float negativeJustOverHalfMaxValue() {
        return minValue() / 2;
    }

    @Override
    public Float positiveJustOverHalfMaxValue() {
        return maxValue() / 2;
    }

    @Override
    public Float minValue() {
        return -Float.MAX_VALUE;
    }

    @Override
    public Float maxValue() {
        return Float.MAX_VALUE;
    }
}

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

public class LongValues implements BoundNumberValues<Long> {

    @Override
    public Long negativeOne() {
        return -1L;
    }

    @Override
    public Long zero() {
        return 0L;
    }

    @Override
    public Long one() {
        return 1L;
    }

    @Override
    public Long two() {
        return 2L;
    }

    @Override
    public Long three() {
        return 3L;
    }

    @Override
    public Long four() {
        return 4L;
    }

    @Override
    public Long five() {
        return 5L;
    }

    @Override
    public Long positive() {
        return 9999L;
    }

    @Override
    public Long negative() {
        return -9999L;
    }

    @Override
    public Long negativeMin() {
        return -9999L;
    }

    @Override
    public Long negativeMax() {
        return -99L;
    }

    @Override
    public Long positiveMin() {
        return 99L;
    }

    @Override
    public Long positiveMax() {
        return positive();
    }

    @Override
    public Long negativeJustOverHalfMaxValue() {
        return minValue() / 2;
    }

    @Override
    public Long positiveJustOverHalfMaxValue() {
        return maxValue() / 2;
    }

    @Override
    public Long minValue() {
        return Long.MIN_VALUE;
    }

    @Override
    public Long maxValue() {
        return Long.MAX_VALUE;
    }
}

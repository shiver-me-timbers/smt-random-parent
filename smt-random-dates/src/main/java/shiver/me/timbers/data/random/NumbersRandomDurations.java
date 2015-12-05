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
class NumbersRandomDurations implements RandomDurations {

    private static final int MILLISECONDS_IN_ONE_SECOND = 1000;
    private static final int MILLISECONDS_IN_ONE_MINUTE = MILLISECONDS_IN_ONE_SECOND * 60;
    private static final int MILLISECONDS_IN_ONE_HOUR = MILLISECONDS_IN_ONE_MINUTE * 60;
    private static final int MILLISECONDS_IN_ONE_DAY = MILLISECONDS_IN_ONE_HOUR * 24;
    private static final int MILLISECONDS_IN_ONE_WEEK = MILLISECONDS_IN_ONE_DAY * 7;

    private final Numbers<Integer> integers;

    public NumbersRandomDurations(Numbers<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public long someTimeInASecond() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_SECOND);
    }

    @Override
    public long someTimeInAMinute() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_MINUTE);
    }

    @Override
    public long someTimeInAnHour() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_HOUR);
    }

    @Override
    public long someTimeInADay() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_DAY);
    }

    @Override
    public long someTimeInAWeek() {
        return integers.someNumberBetween(0, MILLISECONDS_IN_ONE_WEEK);
    }

    @Override
    public long someTimeInDays(int days) {
        return (long) integers.someNumberBetween(0, days) * MILLISECONDS_IN_ONE_DAY;
    }
}

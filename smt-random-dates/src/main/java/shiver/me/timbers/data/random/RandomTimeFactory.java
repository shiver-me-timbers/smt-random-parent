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

import java.util.Date;

/**
 * @author Karl Bennett
 */
interface RandomTimeFactory<D extends Date> {

    D create(Date date);

    D now();

    D between(Date min, Date max);

    D thisSecond();

    D thisMinute();

    D thisHour();

    D today();

    D thisWeek();

    D thisWeekOn(WeekDay weekDay);

    D lastMonth();

    D thisMonth();

    D nextMonth();

    D lastMonthOnThe(int date);

    D thisMonthOnThe(int date);

    D nextMonthOnThe(int date);

    D lastYear();

    D thisYear();

    D nextYear();

    D lastYearOnDay(int day);

    D thisYearOnDay(int day);

    D nextYearOnDay(int day);

    D random();
}
